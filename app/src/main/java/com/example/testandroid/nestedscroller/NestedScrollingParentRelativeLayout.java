package com.example.testandroid.nestedscroller;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

public class NestedScrollingParentRelativeLayout extends RelativeLayout implements NestedScrollingParent{

    private NestedScrollingParentHelper mNestedScrollingParentHelper;
    private int mScreenHeight;
    private int minHeight;
    private int maxHeight;

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

    private void initView(){
        mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mScreenHeight = displayMetrics.heightPixels;
        float scaledDensity = displayMetrics.scaledDensity;
        minHeight = (int) (50*scaledDensity);
        maxHeight = (int) (200*scaledDensity);

    }


    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        float childViewY = target.getY();
        int childViewHeight = (int) (mScreenHeight - childViewY);

        if(dy>0){
            //向上滑动
            if(childViewHeight >= maxHeight){
                consumed[1]=0;
            }else {
                consumed[1]=dy;
                scrollBy(0,dy);
            }
 
        }else {
            //向下滑动
            if(childViewHeight <= minHeight){
                consumed[1]=0;
            }else {
                consumed[1]=dy;
                scrollBy(0,dy);
            }

        }

    }
}
