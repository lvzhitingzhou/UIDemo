package com.saku.uidemo.utils;

import com.saku.uidemo.component.ApiComponent;
import com.saku.uidemo.component.AppComponent;
import com.saku.uidemo.component.NetComponent;

public class DaggerHelper {
    private volatile static DaggerHelper sDaggerHelper;
    private NetComponent mNetComponent;
    private ApiComponent mApiComponent;
    private AppComponent mAppComponent;

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

    public void setApiComponent(ApiComponent apiComponent) {
        this.mApiComponent = apiComponent;
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public void setAppComponent(AppComponent mAppComponent) {
        this.mAppComponent = mAppComponent;
    }
}
