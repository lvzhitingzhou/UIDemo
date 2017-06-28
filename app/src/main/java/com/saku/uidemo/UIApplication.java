package com.saku.uidemo;

import android.app.Application;

import com.saku.uidemo.component.ApiComponent;
import com.saku.uidemo.component.DaggerApiComponent;
import com.saku.uidemo.component.DaggerNetComponent;
import com.saku.uidemo.component.NetComponent;
import com.saku.uidemo.module.AppModule;
import com.saku.uidemo.module.NetModule;
import com.saku.uidemo.module.RESTModule;
import com.saku.uidemo.utils.ConstantUtils;
import com.saku.uidemo.utils.DaggerHelper;

public class UIApplication extends Application {
    private static UIApplication sApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;

        setComponent();

    }

    private void setComponent() {
        final NetComponent netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(ConstantUtils.baseUrl))
                .build();

        final ApiComponent apiComponent = DaggerApiComponent.builder()
                .netComponent(netComponent)
                .rESTModule(new RESTModule())
                .build();

        DaggerHelper.getInstance().setNetComponent(netComponent);
        DaggerHelper.getInstance().setRestApiComponent(apiComponent);
    }


    public static UIApplication getApplication() {
        return sApplication;
    }
}
