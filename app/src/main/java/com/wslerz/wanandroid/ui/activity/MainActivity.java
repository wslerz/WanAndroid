package com.wslerz.wanandroid.ui.activity;

import android.support.v4.content.ContextCompat;

import com.wslerz.wanandroid.R;
import com.wslerz.wanandroid.base.BaseActivity;
import com.wslerz.wanandroid.data.http.bean.ArticleListBean;
import com.wslerz.wanandroid.mvp.contract.TestContract;
import com.wslerz.wanandroid.mvp.presenterimpl.TestPresenterImpl;
import com.wslerz.wanandroid.utils.StatusBarUtil;

import java.util.List;

public class MainActivity extends BaseActivity<TestPresenterImpl> implements TestContract.TestView {

    @Override
    protected TestPresenterImpl initPresenter() {
        return new TestPresenterImpl();
    }

    @Override
    protected void initView() {
        setSwipeBackEnable(false);
        StatusBarUtil.setStatusColor(getWindow(), ContextCompat.getColor(this, R.color.main_color), 1f);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindData() {
        mPresenter.getWxArticle();
    }

    @Override
    public void getWxArticleSuc(List<ArticleListBean> chapterBeanList) {
    }

    @Override
    public void getWxArticleFail(Throwable throwable) {
        toast(throwable.getMessage());
    }
}
