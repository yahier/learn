package com.yahier.learn.act;

import android.os.Bundle;
import android.view.View;

import com.yahier.learn.R;
import com.yahier.learn.util.ToastUtil;

/**
 * Created by lenovo on 2016/10/29.
 * 发布页面
 */

public class PublishAct extends ThemeAct {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_publish);
        setLabel("发布");
        //getActionBar().hide();这种直接操作导致崩溃
        getDelegate().getSupportActionBar().hide();
        setRightText("完成", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToastUtil.showToast("点击了完成");
            }
        });
    }
}
