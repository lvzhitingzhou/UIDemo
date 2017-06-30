package com.saku.uidemo.activities.viewProcessors;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.saku.uidemo.data.listdata.ItemData;
import com.saku.uidemo.data.listdata.CarTypesData;

import java.util.List;

public class CarTypeViewProcessor extends ListViewPorcessor<CarTypesData, ItemData> {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, List<ItemData> mData, int position, CarTypesData standByData) {

    }

    @Override
    public boolean matchesViewType(int position, List<ItemData> data, ItemData item) {
        return false;
    }
}
