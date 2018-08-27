package com.example.testandroid.testlistscroller;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testandroid.R;
import com.example.testandroid.base.RecycleViewListAdapter;

import java.util.ArrayList;

public class ListScrollerActivity extends Activity {
    private RecycleViewListAdapter mListAdapter = new RecycleViewListAdapter();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_list_scroller);
        mRecyclerView = findViewById(R.id.test_recycler_view);
        mRecyclerView.setAdapter(mListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mListAdapter.notifyDataSetChanged();
    }

}
