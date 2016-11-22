package com.yahier.learn.util;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/11/22.
 */

public class ApiManage {

    public ZhihuApi zhihuApi;
    public static ApiManage apiManage;

    public static ApiManage getInstence() {
        if (apiManage == null) {
            synchronized (ApiManage.class) {
                if (apiManage == null) {
                    apiManage = new ApiManage();
                }
            }

        }
        return apiManage;
    }


    public ZhihuApi getApiService() {
        if (zhihuApi == null) {
            Log.e("ApiManage", "getZhihuApiService");
            zhihuApi = new Retrofit.Builder()
                    .baseUrl("http://news-at.zhihu.com")
                    //增加返回值为Oservable<T>的支持
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    //client也不是必要的
                    //.client(client)
                    //增加返回值为Gson的支持(以实体类返回)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ZhihuApi.class);

        }

        return zhihuApi;
    }
}
