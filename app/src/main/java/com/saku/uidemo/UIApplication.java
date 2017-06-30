package com.saku.uidemo;

import android.app.Application;

import com.saku.uidemo.component.ApiComponent;
import com.saku.uidemo.component.AppComponent;
import com.saku.uidemo.component.DaggerApiComponent;
import com.saku.uidemo.component.DaggerNetComponent;
import com.saku.uidemo.component.NetComponent;
import com.saku.uidemo.module.AppModule;
import com.saku.uidemo.module.NetModule;
import com.saku.uidemo.module.ApiModule;
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
        AppModule appModule = new AppModule(this);
        final NetComponent netComponent = DaggerNetComponent.builder()
                .appModule(appModule)
                .netModule(new NetModule(ConstantUtils.baseUrl))
                .build();

        final ApiComponent apiComponent = DaggerApiComponent.builder()
                .netComponent(netComponent)
                .apiModule(new ApiModule())
                .build();

        final AppComponent appComponent = AppComponent.Initializer.init(this);

        DaggerHelper.getInstance().setNetComponent(netComponent);
        DaggerHelper.getInstance().setApiComponent(apiComponent);
        DaggerHelper.getInstance().setAppComponent(appComponent);
    }


    public static UIApplication getApplication() {
        return sApplication;
    }
}
