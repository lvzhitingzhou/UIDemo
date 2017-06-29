package com.saku.uidemo.activities.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.saku.uidemo.activities.typeProcessor.BaseTypeHolder;
import com.saku.uidemo.activities.viewProcessors.BaseViewProcessor;

public abstract class BaseCarAdapter<T> extends RecyclerView.Adapter {
    protected T mData;
    private BaseTypeHolder<T> mTypeHolder;

    public BaseCarAdapter(T data, BaseTypeHolder<T> typeHolder) {
        this.mData = data;
        this.mTypeHolder = typeHolder;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final BaseViewProcessor vp = mTypeHolder.getViewProcessor(viewType);
        return vp.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int viewType = getItemViewType(position);
        final BaseViewProcessor<T> vp = mTypeHolder.getViewProcessor(viewType);
        vp.onBindViewHolder(holder, mData, position);
    }

    @Override
    public int getItemViewType(int position) {
       return mTypeHolder.getItemType(position, mData);
    }
}


