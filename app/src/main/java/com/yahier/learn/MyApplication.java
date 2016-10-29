package com.yahier.learn;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class MyApplication extends MultiDexApplication {

    private static MyApplication mInstance = null;

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        context = getApplicationContext();
    }


    public static MyApplication getInstance() {
        return mInstance;
    }


}

