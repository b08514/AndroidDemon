package com.example.testandroid.base;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testandroid.R;

import java.util.ArrayList;

import hugo.weaving.DebugLog;


@DebugLog
public class RecycleViewListAdapter extends RecyclerView.Adapter<RecycleViewListAdapter.MyViewHolder> {

    private static final String TAG = "RecycleViewListAdapter";
    private static int MAX_COUNT = 40;
    private ArrayList<String> mData = new ArrayList<>();

    public RecycleViewListAdapter(){
        initData();
    }


    @Override
    public RecycleViewListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, null);

        return new RecycleViewListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewListAdapter.MyViewHolder holder, int position) {
        if (holder != null){
            holder.mItmeText.setText(mData.get(position));
        }

        Log.d(TAG,"onBindViewHolder position = "+position);

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    private void initData() {
        mData.clear();
        for (int i = 0; i < MAX_COUNT; i++) {
            mData.add(i + " Item");
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mItmeText;

        public MyViewHolder(View itemView) {
            super(itemView);
            mItmeText = itemView.findViewById(R.id.item_text);
        }
    }
}
