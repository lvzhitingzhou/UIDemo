package com.saku.uidemo.activities.typeProcessor;

import android.util.SparseArray;

import com.saku.uidemo.activities.viewProcessors.BaseViewProcessor;

/**
 * 处理recyclerView的type对应的viewholder，和数据绑定
 */
public abstract class BaseTypeHolder<T> {


    protected SparseArray<BaseViewProcessor<T>> mViewPros;
//    protected Map<Integer, BaseViewProcessor> mViewPros;   // key如果不连续，用map比较合适

    public BaseTypeHolder() {
        mViewPros = new SparseArray<>();
        addViewProcessor();
    }

    public abstract void addViewProcessor();

    public BaseViewProcessor<T> getViewProcessor(int type) {
        return mViewPros.get(type);
    }

    public SparseArray<BaseViewProcessor<T>> getViewProcessors() {
        return mViewPros;
    }

    /**
     * 遍历集合找出当前数据集position的数据对应的view类型
     */
    public int getItemType(int position, T data) {
        for (int i = 0; i < mViewPros.size(); i++) {
            final int key = mViewPros.keyAt(i);
            final BaseViewProcessor<T> viewProcessor = mViewPros.get(key);
            boolean matched = viewProcessor.matchesViewType(position, data);
            if (matched) {
                return key;
            }
        }
        throw new RuntimeException("itemModel type is wrong");
    }

}
