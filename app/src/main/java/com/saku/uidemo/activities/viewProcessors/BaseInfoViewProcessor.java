package com.saku.uidemo.activities.viewProcessors;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.saku.uidemo.data.listdata.BaseInfoData;
import com.saku.uidemo.data.listdata.ItemData;

import java.util.List;

public class BaseInfoViewProcessor<BaseInfoData, ItemData> extends ListViewPorcessor<BaseInfoData, ItemData>  {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, List<ItemData> mData, int position, BaseInfoData baseInfoData) {

    }

    @Override
    public boolean matchesViewType(int position, List<ItemData> data, ItemData item) {
        return false;
    }
}
