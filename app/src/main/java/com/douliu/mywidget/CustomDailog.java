package com.douliu.mywidget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * 自定义材料设计风格的进度条
 * Created by douliu on 2016/8/24.
 */
public class CustomDailog extends ProgressDialog {

    private boolean cancelable = false;

    public CustomDailog(Context context) {
        super(context);
    }

    public CustomDailog(Context context,int theme) {
        super(context,theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }

    private void init(Context context) {
        //设置不可取消，点击其他区域不能取消，实际中可以抽出去封装供外包设置
        setCancelable(cancelable);
        setCanceledOnTouchOutside(cancelable);

        setContentView(R.layout.load_dialog);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

    @Override
    public void show() {
        super.show();
    }

    /**
     * 设置点击外部或返回键进度条消失
     * @param cancel true 消失   false 不消失
     */
    public void setCancel(boolean cancel){
       cancelable = cancel;
    }
}
