package com.douliu.mywidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {

    private CustomDailog mCustomDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomDailog = new CustomDailog(this, R.style.CustomDialog);
//        mCustomDailog.setCancel(true);
        mCustomDailog.show();
    }


}
