package com.saku.uidemo.activities.typeProcessor;

import android.content.Context;

import com.saku.uidemo.activities.ChooseCarActivity;
import com.saku.uidemo.activities.viewProcessors.BaseInfoViewProcessor;
import com.saku.uidemo.activities.viewProcessors.BottomViewProcessor;
import com.saku.uidemo.activities.viewProcessors.DailyPriceViewProcessor;
import com.saku.uidemo.activities.viewProcessors.MiddleViewProcessor;
import com.saku.uidemo.activities.viewProcessors.CarTypeViewProcessor;
import com.saku.uidemo.data.listdata.ItemData;

import java.util.List;

public class CarTypeProcessor extends BaseTypeHolder<List<ItemData>> {
   public static int TYPE_BASE_INFO = 1;
   public static int TYPE_MIDDLE = 2;
   public static int TYPE_STANDBY_VIEW = 3;
   public static int TYPE_BOTTOM = 4;

    public CarTypeProcessor(Context context) {

    }

    @Override
    public void addViewProcessor() {
        mViewPros.put(TYPE_BASE_INFO, new BaseInfoViewProcessor());
        mViewPros.put(TYPE_MIDDLE, new MiddleViewProcessor());
        mViewPros.put(TYPE_STANDBY_VIEW, new CarTypeViewProcessor());
        mViewPros.put(TYPE_STANDBY_VIEW, new DailyPriceViewProcessor());
        mViewPros.put(TYPE_BOTTOM, new BottomViewProcessor());
    }
}
