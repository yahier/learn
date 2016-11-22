package com.yahier.learn.act;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.yahier.learn.R;
import com.yahier.learn.util.LogUtil;
import com.yahier.learn.util.ToastUtil;

/**
 * Created by yahier on 16/11/6.
 */

public class TestAct extends ThemeAct {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill_item);
        setLabel("test");

        View view = findViewById(R.id.qwe);

//        view.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                LogUtil.logE("view","toast");
//                return true;
//            }
//        });



    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.logE("act","toast");
        return false;
    }
}
