package com.saku.uidemo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.DisplayMetrics;

public class UIUtils {

    public static Bitmap zoomImage(Bitmap bmp, double newWidth, double  newHeight) {
        int oldWidth = bmp.getWidth();
        int oldHeight = bmp.getHeight();
        float scaleHeight = (float) (newHeight / oldHeight);
        float scaleWidth = (float) (newWidth / oldWidth);

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        return Bitmap.createBitmap(bmp, 0, 0, oldWidth, oldHeight, matrix, true);

    }

    public static int dp2px(Context context, int dp) {
        final DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) (metrics.density * dp + 0.5f);

    }
}
