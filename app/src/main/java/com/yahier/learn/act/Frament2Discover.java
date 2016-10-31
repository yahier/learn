package com.yahier.learn.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.yahier.learn.R;
import com.yahier.learn.adapter.Fragment1Adapter;
import com.yahier.learn.util.ToastUtil;

/**
 * Created by Administrator on 2016/10/27.
 */

public class Frament2Discover extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_dis, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Fragment1Adapter adapter = new Fragment1Adapter(getActivity());
        mRecyclerView.setAdapter(adapter);


        final EditText input = (EditText) view.findViewById(R.id.input);

        input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    Intent intent = new Intent(getContext(), SearchAct.class);
                    intent.putExtra("word", input.getText().toString());
                    startActivity(intent);
                }
                return false;
            }
        });

    }
}
