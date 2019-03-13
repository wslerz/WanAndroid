package com.wslerz.wanandroid.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wslerz.wanandroid.utils.ToastUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lzz
 * @time 2019/3/13 15:10
 * @desc BaseFragment
 */
public abstract class BaseFragment<T extends BasePresenterImpl<BaseView>> extends Fragment implements BaseView {
    protected T mPresenter;
    protected Context context;
    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutRes(), container, false);
        unbinder = ButterKnife.bind(rootView);
        mPresenter = initPresenter();
        mPresenter.attachView(this);
        initView();
        initData();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showData();
    }


    protected abstract void initData();

    protected abstract void initView();

    protected abstract T initPresenter();

    protected abstract int getLayoutRes();

    protected abstract void bindData();

    protected void showData() {
        bindData();
    }


    @Override
    public void toast(int id) {
        ToastUtil.show(id);
    }

    @Override
    public void toast(String msg) {
        ToastUtil.show(msg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }

        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
