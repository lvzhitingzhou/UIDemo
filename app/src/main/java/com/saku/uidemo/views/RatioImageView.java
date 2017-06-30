package com.saku.uidemo.views;
/**
 * Created by liumin on 2016-6-7.
 */


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.saku.uidemo.R;

/**
 * User: Missa
 * Date: 2016-06-07
 * Time: 16:17
 * Description:
 */
public class RatioImageView extends ImageView {

    private float mRatio;  // width : height

    public RatioImageView(Context context) {
        this(context, null);
    }

    public RatioImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        mRatio = ta.getFloat(R.styleable.RatioImageView_ratio, 0);
        ta.recycle();
    }

    /**
     * width : height
     *
     * @param ratio
     */
    public void setRatio(float ratio) {
        this.mRatio = ratio;
        if (mRatio != 0.0f) {
            invalidate();
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec - getPaddingLeft() - getPaddingRight());
        int height = MeasureSpec.getSize(heightMeasureSpec - getPaddingTop() - getPaddingBottom());

        // 宽 填充父控件 或具体指
        if (widthMode == MeasureSpec.EXACTLY && heightMode != MeasureSpec.EXACTLY && mRatio != 0.0f) {
            height = (int) (width / mRatio + 0.5f);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height + getPaddingTop() + getPaddingBottom(), MeasureSpec.EXACTLY);
        } else if (widthMode != MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY && mRatio != 0.0f) {
            width = (int) (height * mRatio + 0.5f);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(width + getPaddingLeft() + getPaddingRight(), MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
