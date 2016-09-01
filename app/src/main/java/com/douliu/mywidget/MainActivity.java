package com.douliu.mywidget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    private CustomDailog mCustomDailog;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        Button bt1 = (Button) findViewById(R.id.button);
        Button bt2 = (Button) findViewById(R.id.button2);
        Button bt3 = (Button) findViewById(R.id.button3);
        Button bt4 = (Button) findViewById(R.id.button4);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(mContext)
                        .title("MaterialDialog")
                        .content("牛逼的材料设计")
                        .positiveText("yes")
                        .negativeText("no")
                        .show();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCustomDailog = new CustomDailog(mContext, R.style.CustomDialog);
                mCustomDailog.setCancel(true);
                mCustomDailog.show();
            }
        });

        final String [] items = new String[]{"1","2","3","4","5","6"};

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(mContext)
                        .title("haha")
                        .items(items)
                        .itemsCallback(new MaterialDialog.ListCallback(){
                            @Override
                            public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                                Toast.makeText(mContext,"position="+position+"---text="+text,Toast.LENGTH_SHORT).show();
                            }
                        })
                        .positiveText("确定")
                        .show();


            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(mContext)
                        .title("input")
                        .content("请输入账号密码")
                        .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                        .input("请输入账号", null, new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // Do something
                            }
                        })
                        .input("请输入密码", "", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // Do something
                            }
                        })
                        .show();
            }
        });


    }




}
