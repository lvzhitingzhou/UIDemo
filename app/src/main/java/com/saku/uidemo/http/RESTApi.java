package com.saku.uidemo.http;

import com.saku.uidemo.data.GeneralProduct;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RESTApi {

    @GET("search/productList")
    Call<BaseData<GeneralProduct>> getCarList();
}
