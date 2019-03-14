package com.wslerz.wanandroid;

import com.wslerz.wanandroid.base.BaseActivity;
import com.wslerz.wanandroid.http.bean.WxArticleBean;
import com.wslerz.wanandroid.mvp.contract.TestContract;
import com.wslerz.wanandroid.mvp.presenterimpl.TestPresenterImpl;

import java.util.List;

import butterknife.OnClick;

public class MainActivity extends BaseActivity<TestPresenterImpl> implements TestContract.TestView {

    @Override
    protected TestPresenterImpl initPresenter() {
        return new TestPresenterImpl();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindData() {
        mPresenter.getChapters();
    }

    @Override
    public void getChaptersSuc(List<WxArticleBean> chapterBeanList) {

    }

    @Override
    public void getChaptersFail(Throwable throwable) {
        toast(throwable.getMessage());
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
        mPresenter.getChapters();
    }
}
