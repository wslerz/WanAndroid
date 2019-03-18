package com.wslerz.wanandroid.http.manager;

import com.wslerz.wanandroid.base.BaseEntity;
import com.wslerz.wanandroid.http.bean.HomeBannerBean;
import com.wslerz.wanandroid.http.bean.WxArticleBean;
import com.wslerz.wanandroid.http.bean.WxArticleDetailBean;
import com.wslerz.wanandroid.http.service.ApiService;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author lzz
 * @time 2019/3/14 10:58
 * @desc
 */
public class WanAndroidManager extends BaseRetrofitManager {
    private ApiService apiService;

    private WanAndroidManager() {
        apiService = getRetrofit().create(ApiService.class);
    }

    private static final class SingletonHolder {
        private static final WanAndroidManager INSTANCE = new WanAndroidManager();
    }

    public static WanAndroidManager getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public Flowable<List<WxArticleBean>> getChapters() {
        return apiService.getWxArticle().compose(this.<List<WxArticleBean>>applySchedulers());
    }

    public Flowable<WxArticleDetailBean> getWxArticleDetail(int id, int pageNo) {
        return apiService.getWxArticleDetail(id, pageNo).compose(this.<WxArticleDetailBean>applySchedulers());
    }

    public Flowable<WxArticleDetailBean> getWxArticleDetail(int id, int pageNo, String k) {
        return apiService.getWxArticleDetail(id, pageNo, k).compose(this.<WxArticleDetailBean>applySchedulers());
    }

    public Flowable<WxArticleDetailBean> getWxArticleTime() {
        return apiService.getWxArticleTime(0).compose(this.<WxArticleDetailBean>applySchedulers());
    }

    public Flowable<WxArticleDetailBean> getHomeArticle() {
        return apiService.getHomeArticle(0).compose(this.<WxArticleDetailBean>applySchedulers());
    }

    public Flowable<List<HomeBannerBean>> getHomeBanner() {
        return apiService.getHomeBanner().compose(this.<List<HomeBannerBean>>applySchedulers());
    }


}
