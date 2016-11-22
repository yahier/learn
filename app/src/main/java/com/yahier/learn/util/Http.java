package com.yahier.learn.util;


import com.google.gson.Gson;
import com.yahier.learn.item.ZhihuDaily;
import com.yahier.learn.item.ZhihuStory;

import retrofit2.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2016/11/22.
 */

public class Http {

    //请求成功
    public void getLastZhihuNews() {
        // mZhihuFragment.showProgressDialog();
        Subscription subscription = ApiManage.getInstence().getApiService().getLastDaily()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhihuDaily>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //mZhihuFragment.hidProgressDialog();
                        // mZhihuFragment.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(ZhihuDaily zhihuDaily) {
                        Gson gson = new Gson();
                        String value = gson.toJson(zhihuDaily);
                        LogUtil.logE("Http", "getLastZhihuNews " + value);
                        //mZhihuFragment.hidProgressDialog();
                        //mCacheUtil.put(Config.ZHIHU, gson.toJson(zhihuDaily));
                        //mZhihuFragment.updateList(zhihuDaily);
                    }
                });
        //addSubscription(subscription);
    }


    //测试新的请求方式 测试成功
    public void testRequest2() {
        ZhihuApi api = ApiManage.getInstence().getApiService();
        Call call = api.getZhihuStory("9001111");//传入我们请求的键值对的值
        //利用得到的Call对象，然后我们就发出网络请求了：
        call.enqueue(new retrofit2.Callback() {
            @Override
            public void onResponse(Call call, retrofit2.Response response) {
                ZhihuStory stpry = (ZhihuStory) response.body();
                Gson gson = new Gson();
                String value = gson.toJson(stpry);
                LogUtil.logE("Http", "testRequest2 " + value);
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}