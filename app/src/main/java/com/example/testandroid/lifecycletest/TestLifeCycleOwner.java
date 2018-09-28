package com.example.testandroid.lifecycletest;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

public class TestLifeCycleOwner implements LifecycleOwner {
    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
