package com.saku.uidemo.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

import static android.animation.ValueAnimator.*;

public class LayoutAnimator {

    public static Animator ofHeight(View view, int start, int end) {
        final ValueAnimator animator = ofInt(start, end);
        animator.addUpdateListener(new LayoutHeightUpdateListener(view));
        return animator;
    }


    public static class LayoutHeightUpdateListener implements AnimatorUpdateListener {

        private final View mView;

        public LayoutHeightUpdateListener(View view) {
            mView = view;
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            final ViewGroup.LayoutParams lp = mView.getLayoutParams();
            lp.height = (int) animation.getAnimatedValue();
            mView.setLayoutParams(lp);
        }

    }

    public static class LayoutParamsAnimatorListener extends AnimatorListenerAdapter {
        private final View _view;
        private final int _paramsWidth;
        private final int _paramsHeight;

        public LayoutParamsAnimatorListener(View view, int paramsWidth, int paramsHeight) {
            _view = view;
            _paramsWidth = paramsWidth;
            _paramsHeight = paramsHeight;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            final ViewGroup.LayoutParams params = _view.getLayoutParams();
            params.width = _paramsWidth;
            params.height = _paramsHeight;
            _view.setLayoutParams(params);
        }
    }
}