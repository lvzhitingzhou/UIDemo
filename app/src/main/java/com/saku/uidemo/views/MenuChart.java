package com.saku.uidemo.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.saku.uidemo.data.Pie;
import com.saku.uidemo.utils.UIUtils;

import java.util.ArrayList;

/**
 * 自定义图形 http://chuansong.me/n/1758687151424
 */
public class MenuChart extends View {

    private static final float PIE_SPACING = 2f;
    private int DEFAUT_WIDTH;
    private int DEFAULT_HEIGHT;

    private int mWidth;
    private int mHeight;
    /**
     * 最外层圆半径,
     * btmap圆半径,
     * 内层圆半径,
     * 最内层透明圆半径
     */
    private float rLabel, r, rGold, rIn;
    private RectF rectFLabel, rectFBmp, rectFGold, rectFIn;
    /**
     * 绘制模块，和弹出模块的文字
     */
    private Paint mPaint;
    /**
     * 每个模块边缘上的label文字
     */
    private Paint mLabelPaint;
    /**
     * 使用xfermode时使用的paint
     */
    private Paint mXPaint;

    private int touchTextColor = Color.BLACK;
    private int labelTextColor = Color.WHITE;
    private int touchTextSize = 40;
    private int labelTextSize = 50;

    private int PIE_VIEW_ANGLE = 360;
    private float startAngle = 0;

    private float mRLabelRatio = 1.2f;
    private float mRBmpRatio = 0.8f;
    private float mRGoldRatio = 0.4f;
    private float mRInRatio = 0.2f;

    private ArrayList<Pie> pies;
    private float[] pieAngels;  // 每个模块的角度，占用的总角度之和
    private final float PIE_ANGLE_TOTAL = 360F;
    private double mBmpScale = 1;
    private ArrayList<Bitmap> mBmpList = new ArrayList<>();  // 绘制每个模块中的图片
    private int mTouchedId; // 触摸到的模块id；
    private float mAnimatedValue;
    //白金区域颜色
    private int goldColor = 0x66b8e0e0;

    public MenuChart(Context context) {
        this(context, null);
    }

    public MenuChart(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(touchTextSize);
        mPaint.setColor(touchTextColor);
        mPaint.setTextAlign(Paint.Align.CENTER);

        mLabelPaint = new Paint();
        mLabelPaint.setAntiAlias(true);
        mLabelPaint.setStyle(Paint.Style.FILL);
        mLabelPaint.setTextSize(labelTextSize);
        mLabelPaint.setColor(labelTextColor);
        mLabelPaint.setTextAlign(Paint.Align.CENTER);

        mXPaint = new Paint();
        mXPaint.setStyle(Paint.Style.FILL);

        if (DEFAULT_HEIGHT == 0 || DEFAUT_WIDTH == 0) {
            WindowManager winMnger = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
            Point size = new Point();
            winMnger.getDefaultDisplay().getSize(size);
            DEFAUT_WIDTH = size.x;
            DEFAULT_HEIGHT = size.y;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = measureSize(1, DEFAUT_WIDTH, widthMeasureSpec);
        int measuredHeight = measureSize(1, DEFAULT_HEIGHT, heightMeasureSpec);

        int measuredSize = Math.min(measuredWidth, measuredHeight);
        setMeasuredDimension(measuredSize, measuredSize);
    }

    private int measureSize(int specType, int mandatorySize, int measureSpec) {
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        int result;
        if (mode == MeasureSpec.EXACTLY) {
            result = Math.min(mandatorySize, size);
        } else {
            result = mandatorySize;
            if (specType == 1) {
                result += getPaddingLeft() + getPaddingRight();
            } else {
                result += getPaddingTop() + getPaddingBottom();
            }
        }
        return result;
    }

    // onMeasured -> onSizeChanged -> onDraw
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = w;
        mHeight = h;

        float halfSize = Math.max(w, h) / 2;
        rLabel = halfSize * mRLabelRatio * mRBmpRatio;
        rectFLabel = new RectF(-rLabel, -rLabel, rLabel, rLabel);
        r = halfSize * mRBmpRatio;
        rectFBmp = new RectF(-r, -r, r, r);
        rGold = halfSize * mRGoldRatio;
        rectFGold = new RectF(-rGold, -rGold, rGold, rGold);
        rIn = halfSize * mRInRatio;
        rectFIn = new RectF(-rIn, -rIn, rIn, rIn);

        initData(pies);
    }

    /**
     * r 和rGold在onSizeChanged中才能获取到
     *
     * @param pies
     */
    private void initData(ArrayList<Pie> pies) {
        if (pies == null || pies.isEmpty()) {
            return;
        }
        pieAngels = new float[pies.size()];

        int sumAngle = 0;
        float sumWeight = 0;
        for (int i = 0; i < pies.size(); i++) {
            Pie pie = pies.get(i);
            sumWeight += pie.getWeight();
        }

        for (int j = 0; j < pies.size(); j++) {
            Pie pie = pies.get(j);
            float percent = pie.getWeight() / sumWeight;
            int angle = (int) (percent * PIE_ANGLE_TOTAL);
            pie.setAngle(angle);
            sumAngle += angle;
            pieAngels[j] = sumAngle;

            /****************防止cos90° 取值极其小*********************/
            // 设置每个模块内切圆对应的正方形边长是 bmp的最大宽， bmp的最大高是r-rGold;
            double centerR = (r + rGold) / 2;
            double maxH = r - rGold;
            double maxW = Math.sin(Math.toRadians(angle / 2)) * centerR * Math.sqrt(2);
            maxH = maxH < 1 ? maxW : maxH;
            maxW = maxW < 1 ? maxH : maxW;

            pie.setMax_bmp_size(Math.min(maxW, maxH) * mBmpScale);
            // 设置 扇形内的bitmap
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), pie.getDrawableId());
            Bitmap zoomedBmp = UIUtils.zoomImage(bitmap, pie.getMax_bmp_size(), pie.getMax_bmp_size());
            mBmpList.add(zoomedBmp);
        }
        mTouchedId = -1;
    }

    public void setPieData(ArrayList<Pie> pies) {
        this.pies = pies;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (pies == null || pies.isEmpty()) {
            return;
        }

        // onSizechanged中初始化rectF都是-半径开始，在此把画布拖到中心点. 画布原来的中心点是view的左上角。
        canvas.translate(mWidth / 2, mHeight / 2);
        //画中心线
        canvas.drawLine(-mWidth / 2, 0, mWidth / 2, 0, mPaint);
        canvas.drawLine(0, -mHeight / 2, 0, mHeight / 2, mPaint);
        //todo 展示时旋转中心图片

        // 画扇形的每个模块
        drawPieArc(canvas);

    }

    /**
     * 绘制扇形的每个模块
     *
     * @param canvas 画布
     */
    private void drawPieArc(Canvas canvas) {
        float currentStartAngle = 0; // 当前已绘制的角度，从0开始，知道animatedValue
        canvas.save();
        canvas.rotate(startAngle);  // 可以设置旋转的角度

        float sweepAngle = 0; // 当前要绘制的角度
        for (int i = 0; i < pies.size(); i++) {
            Pie pie = pies.get(i);
            Log.d("lm", "mAnimatedValue = " + mAnimatedValue);
            // pie.getAngle() - PIE_SPACING 为了画间隔
            sweepAngle = Math.min(pie.getAngle() - PIE_SPACING, mAnimatedValue - currentStartAngle);
            Log.d("lm", "=== sweepAngle = " + sweepAngle);

//            //防止最后一个模块缺角 ，如果是 360° 且最后一块希望是缺觉，可以注释这段
//            if (currentStartAngle + sweepAngle == PIE_ANGLE_TOTAL - PIE_SPACING) {
//                sweepAngle = pie.getAngle();
//            }

            if (sweepAngle > 0) {
                Log.d("lm", " sweepAngel " + sweepAngle);
                drawEachArc(pie, canvas, sweepAngle, currentStartAngle);
            }

            currentStartAngle += pie.getAngle();
        }
        canvas.restore();
    }

    private void drawEachArc(Pie pie, Canvas canvas, float sweepAngle, float currentStartAngle) {
        int layerId;
        layerId = canvas.saveLayer(rectFLabel, mPaint, Canvas.ALL_SAVE_FLAG);
        // 标签层
        mXPaint.setColor(pie.getLabelColor());
        canvas.drawArc(rectFLabel, currentStartAngle, sweepAngle, true, mXPaint);
        // bitmap层
        mXPaint.setColor(Color.WHITE);
        canvas.drawArc(rectFBmp, currentStartAngle, sweepAngle, true, mXPaint);

        // 先清除内层gold圈，再画图
        mXPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawArc(rectFGold, currentStartAngle - PIE_SPACING, sweepAngle + PIE_SPACING, true, mXPaint);
        mXPaint.setXfermode(null);

        // 内层颜色圈 不要间隔
        if (sweepAngle <= pie.getAngle() - PIE_SPACING) {
            sweepAngle += PIE_SPACING;
        }
        mXPaint.setColor(goldColor);
        canvas.drawArc(rectFGold, currentStartAngle, sweepAngle, true, mXPaint);

        // 清空最内圈 方便画中心的图片
        mXPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawArc(rectFIn, -1f, PIE_VIEW_ANGLE + PIE_SPACING, true, mXPaint);
        mXPaint.setXfermode(null);
        // mode.clear时可以有透明的效果
        canvas.restoreToCount(layerId);
    }
}

