package com.saku.uidemo.http;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ApiCallback<T> implements Callback<BaseData<T>> {

    @Override
    public void onResponse(Call<BaseData<T>> call, Response<BaseData<T>> response) {
        if (response.body() == null) {
            onFail(-1, "!!! 网络连接失败！！！");
            return;
        }
        if (response.body().errCode == 0) {
            onSuccess(response.body().data);
        } else {
            onFail(response.body().errCode, response.body().errMsg);
        }
    }

    @Override
    public void onFailure(Call<BaseData<T>> call, Throwable t) {
        onFail(-2, t.toString());
    }

    public abstract void onSuccess(T data);
    public abstract void onFail(int errCode, String errMsg);
}
