package com.saku.uidemo.module;

import com.saku.uidemo.data.GeneralProduct;
import com.saku.uidemo.http.BaseData;
import com.saku.uidemo.http.RESTApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;

@Module
public class RESTModule {

    @Provides
    Call<BaseData<GeneralProduct>> provideGeneralProduct(RESTApi restApi) {
        return restApi.getCarList();
    }

//    @Singleton
    @Provides
    RESTApi provideRESTApi(Retrofit retrofit) {
        return retrofit.create(RESTApi.class);
    }
}
