package com.yahier.learn;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;
import com.hyphenate.util.NetUtils;
import com.yahier.learn.act.MainActivity;

public class MyApplication extends MultiDexApplication {

    private static MyApplication mInstance = null;

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        context = getApplicationContext();

        initHuanxin();
    }


    //初始化环信
    void initHuanxin() {
        EMOptions options = new EMOptions();
        //默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        //初始化
        EMClient.getInstance().init(this, options);
        EMClient.getInstance().addConnectionListener(new MyConnectionListener());
        //初始化EaseUI
        EaseUI.getInstance().init(this, options);
    }

    public static MyApplication getInstance() {
        return mInstance;
    }


    private class MyConnectionListener implements EMConnectionListener {
        @Override
        public void onConnected() {

        }

        @Override
        public void onDisconnected(final int error) {
            if (error == EMError.USER_REMOVED) {
                // 显示帐号已经被移除
            } else if (error == EMError.USER_LOGIN_ANOTHER_DEVICE) {
                // 显示帐号在其他设备登录
            } else {
                if (NetUtils.hasNetwork(getInstance())) {
                    //连接不到聊天服务器
                } else {
                    //当前网络不可用，请检查网络设置
                }
            }

        }
    }
}

