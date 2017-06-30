package com.saku.uidemo.activities.viewProcessors;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * @param <I> list data数据的具体类型
 * @param <D> list data数据的接口类型
 */
public abstract class ListViewPorcessor<I, D> implements BaseViewProcessor<List<D>> {
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, List<D> mData, int position) {
        onBindViewHolder(viewHolder, mData, position, (I) mData.get(position));
    }

    public abstract void onBindViewHolder(RecyclerView.ViewHolder viewHolder, List<D> mData, int position, I i);

    @Override
    public boolean matchesViewType(int position, List<D> data) {
        return matchesViewType(position, data, data.get(position));
    }

    public abstract boolean matchesViewType(int position, List<D> data, D item);


//    static class A<T> {
//        void add(A<T> a) {
//
//        }
//    }
//
//    static class B<D> extends A<List<D>> {
//
//    }
//
//    static {
//        A<List<String>> a = new A<>();
//        a.add(new B<String>());
//    }
}