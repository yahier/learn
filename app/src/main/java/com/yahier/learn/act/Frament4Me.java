package com.yahier.learn.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yahier.learn.R;
import com.yahier.learn.util.ToastUtil;

/**
 * Created by Administrator on 2016/10/27.
 */

public class Frament4Me extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4_me, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.tvMyPost).setOnClickListener(this);
        view.findViewById(R.id.tvMyFavor).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.tvMyPost:
                ToastUtil.showToast("点击了我的发布");
                break;
            case R.id.tvMyFavor:
                ToastUtil.showToast("点击了我的收藏");
                break;
        }

    }
}
