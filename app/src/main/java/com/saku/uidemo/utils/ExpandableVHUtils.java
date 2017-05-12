package com.saku.uidemo.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.saku.uidemo.activities.adapter.ListTextAdapter;

public class ExpandableVHUtils {


    public static <VH extends RecyclerView.ViewHolder & ListTextAdapter.Expandable> void open(final VH holder, final View expandView, boolean animate) {
        if (animate) {
            expandView.setVisibility(View.VISIBLE);
            final Animator animator = ViewHolderAnimator.ofItemViewHeight(holder);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    final ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(expandView, View.ALPHA, 1);
                    alphaAnimator.addListener(new ViewHolderAnimator.ViewHolderAnimatorListener(holder));
                    alphaAnimator.start();

                    final RecyclerView recyclerView = (RecyclerView) holder.itemView.getParent();
                    final LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    final int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                    if (holder.getAdapterPosition() == lastVisibleItemPosition) {
                        final int itemHeight = holder.itemView.getMeasuredHeight();
                        Rect visibleRect = new Rect();
                        recyclerView.getGlobalVisibleRect(visibleRect);
                        final int visibleHeight = visibleRect.height();

                        Log.i("lm", "onAnimationEnd: itemHeight: " + itemHeight +" , visibleHeight =" +visibleHeight);

                        Log.i("lm", "onAnimationEnd: getY = " + holder.itemView.getY());
                        final float visibleH = visibleHeight - holder.itemView.getY();
                        Log.i("lm", "onAnimationEnd: visibleH = " + visibleH);
                        final float deltaH = itemHeight - visibleH;
                        Log.i("lm", "onAnimationEnd: deltaH = " + deltaH);
                        final int expandVHeight = holder.getExpandView().getMeasuredHeight();
                        final int restPartH = itemHeight - expandVHeight;
                        Log.i("lm", "onAnimationEnd: restPartH = " + restPartH);

                        if (visibleH <= restPartH) {
                            Log.i("lm", "onAnimationEnd: scrolllllll");
                            recyclerView.scrollBy(0, (int) deltaH);
                        }


                    }
                }
            });
            animator.start();
        } else {
            expandView.setVisibility(View.VISIBLE);
            expandView.setAlpha(1);
        }
    }

    public static <VH extends RecyclerView.ViewHolder & ListTextAdapter.Expandable> void close(final VH holder, final View expandView, boolean animate) {
        if (animate) {
            expandView.setVisibility(View.GONE);
            final Animator animator = ViewHolderAnimator.ofItemViewHeight(holder);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    final ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(expandView, View.ALPHA, 0);
                    alphaAnimator.addListener(new ViewHolderAnimator.ViewHolderAnimatorListener(holder));
                    alphaAnimator.start();
                }
            });
            animator.start();
        } else {
            expandView.setVisibility(View.GONE);
            expandView.setAlpha(0);
        }
    }
}
