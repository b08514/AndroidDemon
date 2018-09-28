package com.example.testandroid.lifecycletest;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;

public interface LifeCycleObserverInterface {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreat();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume();

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestory();

}
