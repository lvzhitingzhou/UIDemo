package com.saku.uidemo.activities.adapter;

import com.saku.uidemo.activities.typeProcessor.BaseTypeHolder;
import com.saku.uidemo.data.listdata.ItemData;

import java.util.List;

public class CarListAdapter extends BaseCarAdapter<List<ItemData>> {

    public CarListAdapter(List<ItemData> data, BaseTypeHolder<List<ItemData>> typeHolder) {
        super(data, typeHolder);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
