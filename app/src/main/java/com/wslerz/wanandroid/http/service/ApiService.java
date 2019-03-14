package com.wslerz.wanandroid.http.service;

import com.wslerz.wanandroid.base.BaseEntity;
import com.wslerz.wanandroid.base.BaseResponse;
import com.wslerz.wanandroid.http.bean.WxArticleBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author lzz
 * @time 2019/3/6 16:13
 * @desc 接口  https://www.wanandroid.com/blog/show/2
 */
public interface ApiService {

    /**
     * 获取公众号列表
     * https://wanandroid.com/wxarticle/chapters/json
     *
     * @return 公众号列表
     */
    @GET("wxarticle/chapters/json")
    Flowable<BaseResponse<List<WxArticleBean>>> getWxArticle();


    /**
     * 查看某个公众号历史数据
     * https://wanandroid.com/wxarticle/list/408/1/json
     *
     * @param id     公众号 ID：拼接在 url 中，eg:405
     * @param pageNo 公众号页码：拼接在url 中，eg:1
     * @return 公众号历史数据
     */
    @GET("wxarticle/list/{id}/{pageNo}/json")
    Flowable<BaseResponse<BaseEntity>> getWxArticleDetail(@Path("id") int id,
                                                          @Path("pageNo") int pageNo);

    /**
     * 在某个公众号中搜索历史文章
     * https://wanandroid.com/wxarticle/list/405/1/json?k=Java
     *
     * @param id     公众号 ID
     * @param pageNo 公众号页码
     * @param java   k : 字符串
     * @return 在某个公众号中搜索历史文章
     */
    @GET("wxarticle/list/{id}/{pageNo}/json")
    Flowable<BaseResponse<BaseEntity>> getWxArticleDetail(@Path("id") int id,
                                                          @Path("pageNo") int pageNo,
                                                          @Query("k") String java);

    /**
     * 最新项目tab (首页的第二个tab)
     * <p>
     * 按时间分页展示所有项目
     * https://wanandroid.com/article/listproject/0/json
     *
     * @param pageNo 页码，拼接在连接中，从0开始。
     * @return 最新项目tab
     */
    @GET("article/listproject/{pageNo}/json")
    Flowable<BaseResponse<BaseEntity>> getWxArticleTime(@Path("pageNo") int pageNo);


    /**
     * 首页文章列表
     * https://www.wanandroid.com/article/list/0/json
     *
     * @param pageNo 页码，拼接在连接中，从0开始。
     * @return 首页文章列表
     */
    @GET("article/list/{pageNo}/json")
    Flowable<BaseResponse<BaseEntity>> getHomeArticle(@Path("pageNo") int pageNo);

    /**
     * 首页banner
     * https://www.wanandroid.com/banner/json
     *
     * @return 首页banner
     */
    @GET("banner/json")
    Flowable<BaseResponse<BaseEntity>> getBanner();


    /**
     * 常用网站
     * https://www.wanandroid.com/friend/json
     *
     * @return 常用网站
     */
    @GET("friend/json")
    Flowable<BaseResponse<BaseEntity>> getFriend();

    /**
     * 搜索热词
     * https://www.wanandroid.com//hotkey/json
     *
     * @return 搜索热词
     */
    @GET("hotkey/json")
    Flowable<BaseResponse<BaseEntity>> getHotKey();


    /**
     * 体系数据 主要标识的网站内容的体系结构，二级目录。部分数据参考
     * https://www.wanandroid.com/tree/json
     *
     * @return 体系数据
     */
    @GET("tree/json")
    Flowable<BaseResponse<BaseEntity>> getTree();

    /**
     * 知识体系下的文章
     * https://www.wanandroid.com/article/list/0/json?cid=60
     *
     * @param pageNo 页码：拼接在链接上，从0开始
     * @param cid    分类的id，上述二级目录的id
     * @return 知识体系下的文章
     */
    @GET("article/list/{pageNo}/json")
    Flowable<BaseResponse<BaseEntity>> getTreeAirticle(@Path("pageNo") int pageNo,
                                                       @Query("cid") int cid);

    /**
     * 导航数据
     * https://www.wanandroid.com/navi/json
     *
     * @return 导航数据
     */
    @GET("navi/json")
    Flowable<BaseResponse<BaseEntity>> getNavi();


    /**
     * 项目分类
     * https://www.wanandroid.com/project/tree/json
     *
     * @return 项目分类
     */
    @GET("project/tree/json")
    Flowable<BaseResponse<BaseEntity>> getProjectTree();


    /**
     * 项目列表数据
     * https://www.wanandroid.com/project/list/1/json?cid=294
     *
     * @param pageNo 拼接在链接中，从1开始
     * @param cid    分类的id，上面项目分类接口
     * @return 项目列表数据
     */
    @GET("project/list/{pageNo}/json")
    Flowable<BaseResponse<BaseEntity>> getProjectList(@Path("pageNo") int pageNo,
                                                      @Query("cid") int cid);

    /**
     * 登录
     * https://www.wanandroid.com/user/login
     *
     * @param username 名称
     * @param password 密码
     * @return 登录
     */
    @POST("user/login")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> login(@Field("username") String username,
                                             @Field("password") String password);

    /**
     * 注册
     * https://www.wanandroid.com/user/register
     *
     * @param username   名称
     * @param password   密码
     * @param repassword 密码2
     * @return 注册
     */
    @POST("user/register")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> register(@Field("username") String username,
                                                @Field("password") String password,
                                                @Field("repassword") String repassword);

    /**
     * 退出
     * https://www.wanandroid.com/user/logout/json
     *
     * @return 退出
     */
    @GET("user/logout/json")
    Flowable<BaseResponse<BaseEntity>> logout();


    ////////需要登录/////////

    /**
     * 收藏文章列表
     * https://www.wanandroid.com/lg/collect/list/0/json
     *
     * @param pageNo 页码：拼接在链接中，从0开始。
     * @return 收藏文章列表
     */
    @GET("lg/collect/list/{pageNo}/json")
    Flowable<BaseResponse<BaseEntity>> getCollectList(@Path("pageNo") int pageNo);


    /**
     * 收藏站内文章
     *
     * @param id 文章id，拼接在链接中。
     * @return 收藏站内文章
     */
    @POST("lg/collect/{id}/json")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> collect(@Field("id") int id);

    /**
     * 收藏站外文章
     * https://www.wanandroid.com/lg/collect/add/json
     *
     * @param title  title
     * @param author author
     * @param link   link
     * @return 收藏站外文章
     */
    @POST("lg/collect/add/json")
    Flowable<BaseResponse<BaseEntity>> collectOut(@Field("title") String title,
                                                  @Field("author") String author,
                                                  @Field("link") String link);




}
