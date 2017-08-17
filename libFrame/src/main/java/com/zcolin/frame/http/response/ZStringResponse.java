/*
 * **********************************************************
 *   author   colin
 *   company  fosung
 *   email    wanglin2046@126.com
 *   date     16-10-21 下午12:01
 * *********************************************************
 */

package com.zcolin.frame.http.response;

import android.app.Activity;
import android.app.ProgressDialog;

import com.zcolin.frame.app.BaseFrameActivity;
import com.zcolin.frame.http.okhttp.callback.StringCallback;

import okhttp3.Request;


/**
 * 返回String对象
 */
public abstract class ZStringResponse extends StringCallback {

    private ProgressDialog proBar;        //请求过程中的进度条
    private String         barMsg;        //进度条上的文字

    public ZStringResponse() {
    }

    /**
     * @param barActy 进度条Atvicity实体
     */
    public ZStringResponse(Activity barActy) {
        this(barActy, null);
    }

    /**
     * @param barActy 进度条Atvicity实体
     * @param barMsg  进度条上 显示的信息
     */
    public ZStringResponse(Activity barActy, String barMsg) {
        if (barActy != null) {
            if (barActy instanceof BaseFrameActivity && ((BaseFrameActivity)barActy).getProgressDialog() != null) {
                proBar = ((BaseFrameActivity)barActy).getProgressDialog();
            }  else {
                proBar = new ProgressDialog(barActy);
                proBar.setCancelable(false);
            }
            this.barMsg = barMsg;
        }
    }

    @Override
    public void onStart(Request request) {
        if (proBar != null) {
            proBar.show();
            proBar.setMessage(barMsg);
        }
    }

    @Override
    public void onFinished() {
        if (proBar != null) {
            proBar.dismiss();
            barMsg = null;
        }
    }
}
