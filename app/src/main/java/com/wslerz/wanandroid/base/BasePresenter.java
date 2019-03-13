package com.wslerz.wanandroid.base;

/**
 * @author lzz
 * @time 2019/3/13 9:49
 * @desc
 */
public interface BasePresenter<T> {
    void attachView(T t);

    void detachView();
}
