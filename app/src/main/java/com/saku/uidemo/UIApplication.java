package com.saku.uidemo;

import android.app.Application;

public class UIApplication extends Application {
    private static UIApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static UIApplication getApplication() {
        return sApplication;
    }
}
