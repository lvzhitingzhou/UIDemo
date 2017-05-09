package com.saku.uidemo.dagger.modules;

import com.saku.uidemo.UIApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    @Provides
    public UIApplication provideApplication() {
        return UIApplication.getApplication();
    }

}
