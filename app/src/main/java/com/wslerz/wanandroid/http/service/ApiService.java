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
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> collectOut(@Field("title") String title,
                                                  @Field("author") String author,
                                                  @Field("link") String link);


    /**
     * 取消收藏 文章列表
     * https://www.wanandroid.com/lg/uncollect_originId/2333/json
     *
     * @param id 表中文章的id
     * @return 取消收藏
     */
    @POST("lg/uncollect_originId/{id}/json")
    Flowable<BaseResponse<BaseEntity>> unCollectOriginId(@Path("id") int id);


    /**
     * 取消收藏 我的收藏页面（该页面包含自己录入的内容）
     * https://www.wanandroid.com/lg/uncollect/2805/json
     *
     * @param id       id:拼接在链接上
     * @param originId originId:列表页下发，无则为-1 originId 代表的是你收藏之前的那篇文章本身的id； 但是收藏支持主动添加，这种情况下，没有originId则为-1
     * @return 取消收藏
     */
    @POST("lg/uncollect/{id}/json")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> unCollect(@Path("id") int id,
                                                 @Field("originId") int originId);

    /**
     * 6.5 收藏网站列表
     * https://www.wanandroid.com/lg/collect/usertools/json
     *
     * @return 收藏网站列表
     */
    @GET("lg/collect/usertools/json")
    Flowable<BaseResponse<BaseEntity>> getCollectUserTool();

    /**
     * 收藏网址
     * https://www.wanandroid.com/lg/collect/addtool/json
     *
     * @param name name
     * @param link link
     * @return 收藏网址
     */
    @POST("lg/collect/addtool/json")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> addCollectUserTool(@Field("name") String name,
                                                          @Field("link") String link);

    /**
     * 编辑收藏网站
     * https://www.wanandroid.com/lg/collect/updatetool/json
     *
     * @param id   id
     * @param name name
     * @param link link
     * @return 编辑收藏网站
     */
    @POST("lg/collect/updatetool/json")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> updateCollectUserTool(@Field("id") int id,
                                                             @Field("name") String name,
                                                             @Field("link") String link);

    /**
     * 删除收藏网站
     * https://www.wanandroid.com/lg/collect/deletetool/json
     *
     * @param id id
     * @return 删除收藏网站
     */
    @POST("lg/collect/deletetool/json")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> deleteCollectUserTool(@Field("id") int id);

    /**
     * 搜索
     * https://www.wanandroid.com/article/query/0/json
     *
     * @param pageNo 页码：拼接在链接上，从0开始。
     * @param k      搜索关键词
     * @return 搜索
     */
    @POST("article/query/{pageNo}/json")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> search(@Path("pageNo") int pageNo,
                                              @Field("k") String k);


    /**
     * 新增一个 TODO
     * https://www.wanandroid.com/blog/show/2442
     * http://www.wanandroid.com/lg/todo/add/json
     * <p>
     * title: 新增标题（必须）
     * content: 新增详情（必须）
     * date: 2018-08-01 预定完成时间（不传默认当天，建议传）
     * type: 大于0的整数（可选）；
     * type 可以用于，在app 中预定义几个类别：例如 工作1；
     * 生活2；娱乐3；新增的时候传入0，1，2，查询的时候，传入type 进行筛选；
     * priority 大于0的整数（可选）；
     * priority 主要用于定义优先级，在app 中预定义几个优先级：重要（1），
     * 一般（2）等，查询的时候，传入priority 进行筛选；
     *
     * @param title    标题
     * @param content  详情
     * @param date     预定完成时间
     * @param type     类型
     * @param priority 重要度
     * @return 新增一个 TODO
     */
    @POST("lg/todo/add/json")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> addTodo(@Field("title") String title,
                                               @Field("content") String content,
                                               @Field("date") String date,
                                               @Field("type") int type,
                                               @Field("priority") int priority);


    /**
     * 更新一个 Todo
     *
     * @param id       拼接在链接上，为唯一标识，列表数据返回时，每个todo 都会有个id标识 （必须）
     * @param title    更新标题 （必须）
     * @param content  新增详情（必须）
     * @param date     2018-08-01（必须）
     * @param type     0 // 0为未完成，1为完成
     * @param status   status
     * @param priority priority
     * @return
     */
    @POST("lg/todo/update/{id}/json")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> updateTode(@Path("id") int id,
                                                  @Field("title") String title,
                                                  @Field("content") String content,
                                                  @Field("date") String date,
                                                  @Field("type") int type,
                                                  @Field("status") int status,
                                                  @Field("priority") int priority);

    /**
     * 删除一个 Todo
     * http://www.wanandroid.com/lg/todo/delete/83/json
     *
     * @param id id
     * @return 删除一个
     */
    @POST("lg/todo/delete/{id}/json")
    @FormUrlEncoded
    Flowable<BaseResponse<BaseEntity>> deleteTode(@Path("id") int id);

    /**
     * 仅更新完成状态Todo
     * http://www.wanandroid.com/lg/todo/done/80/json
     * 只会变更status，未完成->已经完成 or 已经完成->未完成。
     *
     * @param id     id: 拼接在链接上，为唯一标识
     * @param status 0或1，传1代表未完成到已完成，反之则反之。
     * @return 仅更新完成状态Todo
     */
    @POST("lg/todo/done/{id}/json")
    Flowable<BaseResponse<BaseEntity>> updateTodeStatus(@Path("id") int id,
                                                        @Field("status") int status);

    /**
     * http://www.wanandroid.com/lg/todo/v2/list/页码/json
     * TODO 列表
     *
     * @param pageNo   页码从1开始，拼接在url 上
     * @param status   status 状态， 1-完成；0未完成; 默认全部展示；
     * @param type     type 创建时传入的类型, 默认全部展示
     * @param priority priority 创建时传入的优先级；默认全部展示
     * @param orderby  orderby 1:完成日期顺序；2.完成日期逆序；3.创建日期顺序；4.创建日期逆序(默认)；
     * @return
     */
    @GET("lg/todo/v2/list/{pageNo}/json")
    Flowable<BaseResponse<BaseEntity>> getTodeList(@Path("pageNo") int pageNo,
                                                   @Query("status") int status,
                                                   @Query("type") int type,
                                                   @Query("priority") int priority,
                                                   @Query("orderby") int orderby);
}
