package com.wslerz.wanandroid;

import com.wslerz.wanandroid.base.BaseActivity;
import com.wslerz.wanandroid.data.http.bean.ArticleListBean;
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
        mPresenter.getWxArticle();
    }

    @Override
    public void getWxArticleSuc(List<ArticleListBean> chapterBeanList) {
    }

    @Override
    public void getWxArticleFail(Throwable throwable) {
        toast(throwable.getMessage());
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
        mPresenter.getWxArticle();
    }
}
