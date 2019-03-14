package com.wslerz.wanandroid.http.service;

import com.wslerz.wanandroid.base.BaseResponse;
import com.wslerz.wanandroid.http.bean.ChapterBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * @author lzz
 * @time 2019/3/6 16:13
 * @desc 接口
 */
public interface ApiService {

    /**
     * 获取公众号列表
     * https://wanandroid.com/wxarticle/chapters/json
     *
     * @return 公众号列表
     */
    @GET("wxarticle/chapters/json")
    Flowable<BaseResponse<List<ChapterBean>>> getChapters();


}
