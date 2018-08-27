package com.example.testandroid.nestedscroller;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.testandroid.R;
import com.example.testandroid.base.RecycleViewListAdapter;

public class NestedScrollerActivity extends Activity {

    private RecycleViewListAdapter mListAdapter = new RecycleViewListAdapter();
    private RecyclerView mRecyclerView;
    private NestedScrollingParentRelativeLayout parentRelativeLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nested_scroller_ly);
        parentRelativeLayout = findViewById(R.id.nested_scroller_parent);
        mRecyclerView = findViewById(R.id.nested_scroller_children_recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();
    }


}
