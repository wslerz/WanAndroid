package com.wslerz.wanandroid.mvp.contract;

import com.wslerz.wanandroid.base.BasePresenter;
import com.wslerz.wanandroid.base.BaseView;
import com.wslerz.wanandroid.http.bean.ChapterBean;

import java.util.List;

/**
 * @author lzz
 * @time 2019/3/14 10:54
 * @desc
 */
public interface TestContract {
    interface TestPresenter extends BasePresenter<TestView> {
        void getChapters();
    }

    interface TestView extends BaseView {
        void getChaptersSuc(List<ChapterBean> chapterBeanList);

        void getChaptersFail(Throwable throwable);
    }
}
