package com.wslerz.wanandroid.mvp.presenterimpl;

import com.wslerz.wanandroid.base.BasePresenterImpl;
import com.wslerz.wanandroid.http.bean.ChapterBean;
import com.wslerz.wanandroid.http.manager.TestManager;
import com.wslerz.wanandroid.mvp.contract.TestContract;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * @author lzz
 * @time 2019/3/14 10:57
 * @desc
 */
public class TestPresenterImpl extends BasePresenterImpl<TestContract.TestView> implements TestContract.TestPresenter {
    @Override
    public void getChapters() {
        TestManager.getInstance().getChapters()
                .subscribe(new Consumer<List<ChapterBean>>() {
                    @Override
                    public void accept(List<ChapterBean> chapterBeanList) throws Exception {
                        mView.getChaptersSuc(chapterBeanList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.getChaptersFail(throwable);
                    }
                });
    }
}
