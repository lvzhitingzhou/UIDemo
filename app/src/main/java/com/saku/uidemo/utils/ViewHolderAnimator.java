package com.saku.uidemo.utils;

import android.animation.Animator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ViewHolderAnimator {
    public static Animator ofItemViewHeight(RecyclerView.ViewHolder holder) {
        View parent = (View) holder.itemView.getParent();
        if (parent == null)
            throw new IllegalStateException("Cannot animate the layout of a view that has no parent");

        int start = holder.itemView.getMeasuredHeight();
        holder.itemView.measure(View.MeasureSpec.makeMeasureSpec(parent.getMeasuredWidth(), View.MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        int end = holder.itemView.getMeasuredHeight();
//  6
        final Animator animator = LayoutAnimator.ofHeight(holder.itemView, start, end);
//        设定该item在动画开始结束和取消时能否被recycle
        animator.addListener(new ViewHolderAnimatorListener(holder));
//        设定结束时这个item的宽高
        animator.addListener(new LayoutAnimator.LayoutParamsAnimatorListener(holder.itemView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return animator;
    }

    public static class ViewHolderAnimatorListener implements Animator.AnimatorListener{
        private final RecyclerView.ViewHolder _holder;

        public ViewHolderAnimatorListener(RecyclerView.ViewHolder holder) {
            _holder = holder;
        }

        @Override
        public void onAnimationStart(Animator animation) {
            _holder.setIsRecyclable(false);
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            _holder.setIsRecyclable(true);
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            _holder.setIsRecyclable(true);
        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    }


}
