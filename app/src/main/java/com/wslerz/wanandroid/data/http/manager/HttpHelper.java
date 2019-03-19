package com.wslerz.wanandroid.data.http.manager;

import com.wslerz.wanandroid.base.BaseEntity;
import com.wslerz.wanandroid.data.http.bean.ArticleListBean;
import com.wslerz.wanandroid.data.http.bean.FeedArticleDetailBean;
import com.wslerz.wanandroid.data.http.bean.HomeBannerBean;
import com.wslerz.wanandroid.data.http.bean.HotKeyBean;
import com.wslerz.wanandroid.data.http.bean.KnowledgeHierarchyBean;
import com.wslerz.wanandroid.data.http.bean.NavigationListBean;
import com.wslerz.wanandroid.data.http.bean.RegisterBean;
import com.wslerz.wanandroid.data.http.bean.WebsiteBean;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author lzz
 * @time 2019/3/19 10:18
 * @desc
 */
public interface HttpHelper {

    Flowable<List<ArticleListBean>> getWxArticle();

    Flowable<FeedArticleDetailBean> getWxArticleDetail(int id, int pageNo);

    Flowable<FeedArticleDetailBean> getWxArticleDetail(int id, int pageNo, String java);

    Flowable<FeedArticleDetailBean> getWxArticleTime(int pageNo);

    Flowable<FeedArticleDetailBean> getHomeArticle(int pageNo);

    Flowable<List<HomeBannerBean>> getHomeBanner();

    Flowable<List<WebsiteBean>> getFriend();

    Flowable<List<HotKeyBean>> getHotKey();

    Flowable<List<KnowledgeHierarchyBean>> getKnowledgeHierarchy();

    Flowable<FeedArticleDetailBean> getKnowledgeHierarchyDetail(int pageNo, int cid);

    Flowable<NavigationListBean> getNavigationList();

    Flowable<ArticleListBean> getProjectTree();

    Flowable<FeedArticleDetailBean> getProjectList(int pageNo, int cid);

    Flowable<RegisterBean> login(String username, String password);

    Flowable<RegisterBean> register(String username, String password, String repassword);

    Flowable<BaseEntity> logout();

    Flowable<BaseEntity> getCollectList(int pageNo);

    Flowable<BaseEntity> collect(int id);

    Flowable<BaseEntity> collectOut(String title, String author, String link);

    Flowable<BaseEntity> unCollectOriginId(int id);

    Flowable<BaseEntity> unCollect(int id, int originId);

    Flowable<BaseEntity> getCollectUserTool();

    Flowable<BaseEntity> addCollectUserTool(String name, String link);

    Flowable<BaseEntity> updateCollectUserTool(int id, String name, String link);

    Flowable<BaseEntity> deleteCollectUserTool(int id);

    Flowable<BaseEntity> search(int pageNo, String k);

    Flowable<BaseEntity> addTodo(String title, String content, String date, int type, int priority);

    Flowable<BaseEntity> updateTode(int id, String title, String content, String date, int type, int status, int priority);

    Flowable<BaseEntity> deleteTode(int id);

    Flowable<BaseEntity> updateTodeStatus(int id, int status);

    Flowable<BaseEntity> getTodeList(int pageNo, int status, int type, int priority, int orderby);
}
