package com.yahier.learn.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yahier.learn.R;

/**
 * Created by Administrator on 2016/10/27.
 */

public class Frament3Message extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_message, container, false);
        return view;
    }
}
