package com.example.testandroid.lifecycletest;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.testandroid.R;

public class LifeCycleTestActivity extends Activity implements LifecycleOwner{
    private LifecycleRegistry mLifecycleRegistry;
    private TestLifeCycleObserver mTestLifeCycleObserver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_main);
        init();
        mLifecycleRegistry.addObserver(mTestLifeCycleObserver);
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mLifecycleRegistry.markState(Lifecycle.State.STARTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLifecycleRegistry.markState(Lifecycle.State.RESUMED);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        mLifecycleRegistry.markState(Lifecycle.State.DESTROYED);
        super.onDestroy();
    }


    private void init(){
        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry = (LifecycleRegistry) this.getLifecycle();
        mTestLifeCycleObserver = new TestLifeCycleObserver();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }
}
