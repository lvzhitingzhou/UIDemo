package com.saku.uidemo.activities.adapter;

import com.saku.uidemo.activities.typeProcessor.BaseTypeHolder;

import java.util.List;

public class CarListAdatper<D extends List<?>> extends BaseCarAdapter<D> {

    public CarListAdatper(D data, BaseTypeHolder<D> typeHolder) {
        super(data, typeHolder);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
