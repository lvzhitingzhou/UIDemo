package com.saku.uidemo.activities.typeProcessor;

import com.saku.uidemo.activities.viewProcessors.BaseInfoViewProcessor;
import com.saku.uidemo.activities.viewProcessors.BaseViewProcessor;
import com.saku.uidemo.activities.viewProcessors.BottomViewProcessor;
import com.saku.uidemo.activities.viewProcessors.MiddleViewProcessor;
import com.saku.uidemo.activities.viewProcessors.StandByViewProcessor;
import com.saku.uidemo.data.listdata.BaseInfoData;
import com.saku.uidemo.data.listdata.ItemData;

import java.util.List;

public class CarTypeProcessor extends BaseTypeHolder<List<ItemData>> {
   public static int TYPE_BASE_INFO = 1;
   public static int TYPE_MIDDLE = 2;
   public static int TYPE_STANDBY_VIEW = 3;
   public static int TYPE_BOTTOM = 4;

    @Override
    public void addViewProcessor() {
        mViewPros.put(TYPE_BASE_INFO, new BaseInfoViewProcessor<BaseInfoData, ItemData>());
//        mViewPros.put(TYPE_MIDDLE, new MiddleViewProcessor());
//        mViewPros.put(TYPE_STANDBY_VIEW, new StandByViewProcessor());
//        mViewPros.put(TYPE_BOTTOM, new BottomViewProcessor());
    }
}
