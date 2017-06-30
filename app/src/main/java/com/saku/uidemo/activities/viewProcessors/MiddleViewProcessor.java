package com.saku.uidemo.activities.viewProcessors;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.saku.uidemo.data.listdata.ItemData;
import com.saku.uidemo.data.listdata.MiddleData;

import java.util.List;

/**
 * 处理recyclerView的adapter对应的view绑定，数据展示等的基类
 */
public class MiddleViewProcessor extends ListViewPorcessor<MiddleData, ItemData>{

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, List<ItemData> mData, int position, MiddleData middleData) {

    }

    @Override
    public boolean matchesViewType(int position, List<ItemData> data, ItemData item) {
        return false;
    }
}
