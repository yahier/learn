package com.yahier.learn.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yahier.learn.R;
import com.yahier.learn.adapter.Fragment1Adapter;

/**
 * Created by Administrator on 2016/10/27.
 */

public class Frament1Home extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Fragment1Adapter adapter = new Fragment1Adapter(getActivity());
        mRecyclerView.setAdapter(adapter);

        view.findViewById(R.id.imgPublish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),PublishAct.class);
                startActivity(intent);
            }
        });

    }
}
