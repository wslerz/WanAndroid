package com.wslerz.wanandroid.http.manager;

import com.wslerz.wanandroid.http.bean.ChapterBean;
import com.wslerz.wanandroid.http.service.ApiService;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author lzz
 * @time 2019/3/14 10:58
 * @desc
 */
public class TestManager extends BaseRetrofitManager {
    private ApiService apiService;

    private TestManager() {
        apiService = getRetrofit().create(ApiService.class);
    }

    private static final class SingletonHolder {
        private static final TestManager INSTANCE = new TestManager();
    }

    public static TestManager getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public Flowable<List<ChapterBean>> getChapters() {
        return apiService.getChapters().compose(this.<List<ChapterBean>>applySchedulers());
    }

}
