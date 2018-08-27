package com.example.testandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.testandroid.nestedscroller.NestedScrollerActivity;
import com.example.testandroid.testlistscroller.ListScrollerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mScrolerTest;
    private TextView mNestedScrolerTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScrolerTest = findViewById(R.id.test_list_scroller);
        mNestedScrolerTest = findViewById(R.id.test_list_nested_scroller);
        mScrolerTest.setOnClickListener(this);
        mNestedScrolerTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mScrolerTest){
            startActivity(new Intent(this, ListScrollerActivity.class));
        }else if(v == mNestedScrolerTest){
            startActivity(new Intent(this, NestedScrollerActivity.class));
        }
    }
}
