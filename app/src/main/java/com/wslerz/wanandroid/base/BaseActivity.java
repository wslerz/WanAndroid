package com.wslerz.wanandroid.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.wslerz.wanandroid.utils.ToastUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lzz
 * @time 2019/3/13 9:35
 * @desc BaseActivity
 */
@SuppressLint("Registered")
public abstract class BaseActivity<P extends BasePresenterImpl> extends BaseSwipeBackActivity implements BaseView {
    protected P mPresenter;
    protected Unbinder unbinder;

    private String TAG = "BaseActivity";

    protected boolean isShowLifeCycle() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
        setContentView(getLayoutId());
        if (isShowLifeCycle()) {
            Log.i(TAG, "onCreate: ");
        }
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        unbinder = ButterKnife.bind(this);
        initStatusBar();
        initView();
        initData();
        bindData();

    }

    protected abstract int getLayoutId();

    protected void initStatusBar() {

    }

    protected P initPresenter() {
        return null;
    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected abstract void bindData();

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void toast(String msg) {
        ToastUtil.show(msg);
    }

    @Override
    public void toast(int id) {
        ToastUtil.show(id);
    }
}
