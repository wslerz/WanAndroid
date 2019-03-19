package com.wslerz.wanandroid.mvp.presenterimpl;

import android.annotation.SuppressLint;

import com.wslerz.wanandroid.base.BaseEntity;
import com.wslerz.wanandroid.base.BasePresenterImpl;
import com.wslerz.wanandroid.data.http.bean.ArticleListBean;
import com.wslerz.wanandroid.data.http.bean.RegisterBean;
import com.wslerz.wanandroid.data.http.manager.HttpHelper;
import com.wslerz.wanandroid.data.http.manager.HttpHelperImpl;
import com.wslerz.wanandroid.mvp.contract.TestContract;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * @author lzz
 * @time 2019/3/14 10:57
 * @desc
 */
@SuppressLint("CheckResult")
public class TestPresenterImpl extends BasePresenterImpl<TestContract.TestView> implements TestContract.TestPresenter {

    public TestPresenterImpl() {

    }

    @Override
    public void getWxArticle() {
        addSubscribe(dataManager.getWxArticle()
                .subscribe(new Consumer<List<ArticleListBean>>() {
                    @Override
                    public void accept(List<ArticleListBean> chapterBeanList) {
                        mView.getWxArticleSuc(chapterBeanList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        mView.getWxArticleFail(throwable);
                    }
                }));

//        addSubscribe(HttpHelperImpl.getInstance().register("wslerztest1", "wa19930925", "wa19930925")
//                .subscribe(new Consumer<RegisterBean>() {
//                    @Override
//                    public void accept(RegisterBean baseEntity) throws Exception {
//
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                    }
//                }));

        addSubscribe(HttpHelperImpl.getInstance().login("wslerztest1", "wa19930925")
                .subscribe(new Consumer<RegisterBean>() {
                    @Override
                    public void accept(RegisterBean baseEntity) throws Exception {
                        mView.toast(baseEntity.getUsername());
//                        addSubscribe(HttpHelperImpl.getInstance().logout()
//                                .subscribe(new Consumer<BaseEntity>() {
//                                    @Override
//                                    public void accept(BaseEntity baseEntity) throws Exception {
//
//                                    }
//                                }, new Consumer<Throwable>() {
//                                    @Override
//                                    public void accept(Throwable throwable) throws Exception {
//
//                                    }
//                                }));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));


    }
}
