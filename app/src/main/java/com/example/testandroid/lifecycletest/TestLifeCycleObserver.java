package com.example.testandroid.lifecycletest;

import android.arch.lifecycle.LifecycleObserver;
import android.util.Log;

public class TestLifeCycleObserver implements LifecycleObserver, LifeCycleObserverInterface{

    private final static String TAG="TestLifeCycleObserver";
    @Override
    public void onCreat() {
        Log.d(TAG,"LifecycleObserver onCreat");
    }

    @Override
    public void onStart() {
        Log.d(TAG,"LifecycleObserver onStart");
    }

    @Override
    public void onResume() {
        Log.d(TAG,"LifecycleObserver onResume");
    }

    @Override
    public void onPause() {
        Log.d(TAG,"LifecycleObserver onResume");
    }

    @Override
    public void onStop() {
        Log.d(TAG,"LifecycleObserver onStop");
    }

    @Override
    public void onDestory() {
        Log.d(TAG,"LifecycleObserver onDestory");
    }
}
