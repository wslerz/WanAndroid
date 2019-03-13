package com.wslerz.wanandroid.base;

/**
 * @author lzz
 * @time 2019/3/13 9:52
 * @desc
 */
public  class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected T mView;


    @Override
    public void attachView(T t) {
        mView = t;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
