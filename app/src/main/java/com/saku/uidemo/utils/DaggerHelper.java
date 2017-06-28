package com.saku.uidemo.utils;

import com.saku.uidemo.component.ApiComponent;
import com.saku.uidemo.component.NetComponent;

public class DaggerHelper {
    private volatile static DaggerHelper sDaggerHelper;
    private NetComponent mNetComponent;
    private ApiComponent mApiComponent;

    private DaggerHelper() {

    }

    public static DaggerHelper getInstance() {
        if (sDaggerHelper == null) {
            synchronized (DaggerHelper.class) {
                if (sDaggerHelper == null) {
                    sDaggerHelper = new DaggerHelper();
                }
            }
        }
        return sDaggerHelper;
    }



    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public void setNetComponent(NetComponent netComponent) {
        this.mNetComponent = netComponent;
    }

    public void setRestApiComponent(ApiComponent restApiComponent) {
        this.mApiComponent = restApiComponent;
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }
}
