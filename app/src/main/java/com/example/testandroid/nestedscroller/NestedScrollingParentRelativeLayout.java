package com.example.testandroid.nestedscroller;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;

public class NestedScrollingParentRelativeLayout extends RelativeLayout implements NestedScrollingParent {

    private static final String TAG = "NestedScrollingParent";
    private NestedScrollingParentHelper mNestedScrollingParentHelper;
    private int mScreenHeight;
    private int minHeight;
    private int maxHeight;
    private int mScrollerLength;
    private int mLastDy;

    public NestedScrollingParentRelativeLayout(Context context) {
        super(context);
        initView();
    }

    public NestedScrollingParentRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public NestedScrollingParentRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mScreenHeight = displayMetrics.heightPixels;
        float scaledDensity = displayMetrics.scaledDensity;
        minHeight = (int) (50 * scaledDensity);
        maxHeight = (int) (50 * scaledDensity);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ViewConfiguration.getTouchSlop();
        return super.onTouchEvent(event);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return ViewCompat.SCROLL_AXIS_VERTICAL == nestedScrollAxes;
    }

    @Override
    public void onStopNestedScroll(View child) {
        mNestedScrollingParentHelper.onStopNestedScroll(child);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }


    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        int distance = mLastDy - dy;
        mLastDy = dy;

        Log.d(TAG, "distance = " + distance + " ; mScreenHeight = " + mScreenHeight
                + " ; dy = " + dy + " ; maxHeight = " + maxHeight + " ; minHeight = " + minHeight);
        if (dy > 0) {
            //向上滑动
            consumed[1] = dy;
            ViewCompat.offsetTopAndBottom(this, distance);
//            offsetTopAndBottom(dy);
//                setTop(dy);

        } else {
            //向下滑动
            consumed[1] = 0;

        }

    }
}
