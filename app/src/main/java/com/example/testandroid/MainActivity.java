package com.example.testandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testandroid.lifecycletest.LifeCycleTestActivity;
import com.example.testandroid.nestedscroller.NestedScrollerActivity;
import com.example.testandroid.proxytest.ProxyTestActivity;
import com.example.testandroid.sysnestedscrollerview.NestedScrollerViewActivity;
import com.example.testandroid.testlistscroller.ListScrollerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mScrolerTest;
    private TextView mNestedScrolerTest;
    private TextView mSysNestedScrollerView;
    private TextView mProxyTest;
    private TextView mLifecycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScrolerTest = findViewById(R.id.test_list_scroller);
        mNestedScrolerTest = findViewById(R.id.test_list_nested_scroller);
        mSysNestedScrollerView = findViewById(R.id.test_list_sys_nested_scroller);
        mProxyTest = findViewById(R.id.test_proxy);
        mLifecycle = findViewById(R.id.test_lifecycle);
        mScrolerTest.setOnClickListener(this);
        mNestedScrolerTest.setOnClickListener(this);
        mSysNestedScrollerView.setOnClickListener(this);
        mProxyTest.setOnClickListener(this);
        mLifecycle.setOnClickListener(this);
    }

    private void testDoubleEquel(){
        double num = 0.000000000000000000000000000000000000000000001D;
        if ( 1E-16 > num && num > -1E-16){
            Toast.makeText(this,"0 == num  TRUE num = "+num,Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"0 == num  false num = "+num,Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onClick(View v) {
        if(v == mScrolerTest){
            startActivity(new Intent(this, ListScrollerActivity.class));
        }else if(v == mNestedScrolerTest){
            startActivity(new Intent(this, NestedScrollerActivity.class));
        }else if(v == mSysNestedScrollerView){
            startActivity(new Intent(this, NestedScrollerViewActivity.class));
        }else if(v == mProxyTest){
            startActivity(new Intent(this, ProxyTestActivity.class));
        }else if(v == mLifecycle){
            startActivity(new Intent(this, LifeCycleTestActivity.class));
        }
    }
}
