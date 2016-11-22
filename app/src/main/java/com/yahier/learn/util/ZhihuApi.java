package com.yahier.learn.util;


import com.yahier.learn.item.ZhihuDaily;
import com.yahier.learn.item.ZhihuStory;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface ZhihuApi {

    @GET("/api/4/news/latest")
    Observable<ZhihuDaily> getLastDaily();

    @GET("/api/4/news/before/{date}")
    Observable<ZhihuDaily> getTheDaily(@Path ("date") String date);


    //以下是call的返回测试

    @GET("/api/4/news/{id}")
    Call<ZhihuStory> getZhihuStory(@Path("id") String id);

    @GET("/api/4/news/latest")
    Call<ZhihuDaily> getLastDailyCall();

}
