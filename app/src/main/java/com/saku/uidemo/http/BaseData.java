package com.saku.uidemo.http;

import com.google.gson.annotations.SerializedName;

public class BaseData<T> {
    @SerializedName("errno")
    public int errCode;
    @SerializedName("errmsg")
    public String errMsg;
    @SerializedName("data")
    public T data;
}
