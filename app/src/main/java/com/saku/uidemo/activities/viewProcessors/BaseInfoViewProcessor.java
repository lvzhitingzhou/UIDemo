package com.saku.uidemo.activities.viewProcessors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saku.uidemo.R;
import com.saku.uidemo.data.listdata.BaseInfoData;
import com.saku.uidemo.data.listdata.ItemData;
import com.saku.uidemo.utils.DaggerHelper;

import java.util.List;

public class BaseInfoViewProcessor extends ListViewPorcessor<BaseInfoData, ItemData>  {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(DaggerHelper.getInstance().getAppComponent().getContext())
                .inflate(R.layout.item_baseinfo_layout, parent, false);
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
