package com.wslerz.wanandroid.utils;

import android.annotation.SuppressLint;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.wslerz.wanandroid.app.WApplication;

/**
 * @author lzz
 * @time 2019/3/13 10:49
 * @desc 吐司
 */
public class ToastUtil {
    private static Toast toast;


    public static void show(String msg) {
        check();
        toast.setText(msg);
        toast.show();
    }

    public static void show(@StringRes int id) {
        show(WApplication.getInstance().getResources().getString(id));
    }

    public static void showLong(String msg) {
        check();
        toast.setText(msg);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    public static void showLong(@StringRes int id) {
        showLong(WApplication.getInstance().getResources().getString(id));
    }

    @SuppressLint("ShowToast")
    private static void check() {
        if (toast == null) {
            toast = Toast.makeText(WApplication.getInstance(), "", Toast.LENGTH_SHORT);
        }
    }
}
