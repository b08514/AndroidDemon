package com.example.testandroid.sysnestedscrollerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.testandroid.R;
import com.example.testandroid.base.RecycleViewListAdapter;

public class NestedScrollerViewActivity extends Activity {
    private RecycleViewListAdapter mListAdapter = new RecycleViewListAdapter();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system_nested_scroller_view);
        mRecyclerView = findViewById(R.id.sys_nested_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mListAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mListAdapter.notifyDataSetChanged();
    }
}
