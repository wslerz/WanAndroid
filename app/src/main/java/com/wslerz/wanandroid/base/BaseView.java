package com.wslerz.wanandroid.base;

import android.support.annotation.StringRes;

/**
 * @author lzz
 * @time 2019/3/13 9:48
 * @desc BaseView
 */
public interface BaseView {
    void toast(String msg);

    void toast(@StringRes int id);
}
