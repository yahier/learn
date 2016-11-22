package com.yahier.learn.util;


import com.google.gson.Gson;
import com.yahier.learn.item.ZhihuDaily;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2016/11/22.
 */

public class Http {

    //这个请求真真是看不懂啊
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
}
