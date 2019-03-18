package com.wslerz.wanandroid.mvp.presenterimpl;

import android.annotation.SuppressLint;

import com.wslerz.wanandroid.base.BaseEntity;
import com.wslerz.wanandroid.base.BasePresenterImpl;
import com.wslerz.wanandroid.http.bean.WxArticleBean;
import com.wslerz.wanandroid.http.bean.WxArticleDetailBean;
import com.wslerz.wanandroid.http.manager.WanAndroidManager;
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
    private WanAndroidManager manager;

    public TestPresenterImpl() {
        manager = WanAndroidManager.getInstance();
    }

    @Override
    public void getChapters() {
//        manager.getChapters()
//                .subscribe(new Consumer<List<WxArticleBean>>() {
//                    @Override
//                    public void accept(List<WxArticleBean> chapterBeanList) {
//                        mView.getChaptersSuc(chapterBeanList);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) {
//                        mView.getChaptersFail(throwable);
//                    }
//                });
//        manager.getWxArticleDetail(408, 1).subscribe(new Consumer<WxArticleDetailBean>() {
//            @Override
//            public void accept(WxArticleDetailBean baseEntity) throws Exception {
//
//            }
//        });
//        manager.getWxArticleDetail(408, 1, "android").subscribe(new Consumer<WxArticleDetailBean>() {
//            @Override
//            public void accept(WxArticleDetailBean baseEntity) throws Exception {
//
//            }
//        });

    }
}
