package com.wslerz.wanandroid.base;

import com.wslerz.wanandroid.data.DataManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author lzz
 * @time 2019/3/13 9:52
 * @desc
 */
public abstract class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected T mView;

    private CompositeDisposable compositeDisposable;

    protected DataManager dataManager;

    @Override
    public void attachView(T t) {
        mView = t;
        dataManager = DataManager.getInstance();
    }


    @Override
    public void detachView() {
        mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }

    @Override
    public void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @Override
    public void addRxBindingSubscribe(Disposable disposable) {
        addSubscribe(disposable);
    }
}
