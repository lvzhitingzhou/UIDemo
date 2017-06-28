package com.saku.uidemo.http;

import com.saku.uidemo.data.GeneralProduct;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RESTApi {

    @GET
    Call<BaseData<GeneralProduct>> getCarList();
}
