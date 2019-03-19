package com.wslerz.wanandroid.base;

import io.reactivex.disposables.Disposable;

/**
 * @author lzz
 * @time 2019/3/13 9:49
 * @desc
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(T t);

    void detachView();

    void addRxBindingSubscribe(Disposable disposable);

    void addSubscribe(Disposable disposable);

}
