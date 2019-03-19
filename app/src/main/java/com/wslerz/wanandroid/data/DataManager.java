package com.wslerz.wanandroid.data;

import com.wslerz.wanandroid.base.BaseEntity;
import com.wslerz.wanandroid.data.http.bean.ArticleListBean;
import com.wslerz.wanandroid.data.http.bean.FeedArticleDetailBean;
import com.wslerz.wanandroid.data.http.bean.HomeBannerBean;
import com.wslerz.wanandroid.data.http.bean.HotKeyBean;
import com.wslerz.wanandroid.data.http.bean.KnowledgeHierarchyBean;
import com.wslerz.wanandroid.data.http.bean.NavigationListBean;
import com.wslerz.wanandroid.data.http.bean.RegisterBean;
import com.wslerz.wanandroid.data.http.bean.WebsiteBean;
import com.wslerz.wanandroid.data.http.manager.HttpHelper;
import com.wslerz.wanandroid.data.http.manager.HttpHelperImpl;
import com.wslerz.wanandroid.data.pres.PreferencesHelper;
import com.wslerz.wanandroid.data.pres.PreferencesHelperImpl;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author lzz
 * @time 2019/3/19 10:45
 * @desc
 */
public class DataManager implements HttpHelper, PreferencesHelper {
    private HttpHelper httpHelper;
    private PreferencesHelper preferencesHelper;

    private DataManager() {
        this.httpHelper = HttpHelperImpl.getInstance();
        this.preferencesHelper = PreferencesHelperImpl.getInstance();
    }

    private static class SingletonHolder {
        public static DataManager INSTANCE = new DataManager();
    }

    public static DataManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Flowable<List<ArticleListBean>> getWxArticle() {
        return httpHelper.getWxArticle();
    }

    @Override
    public Flowable<FeedArticleDetailBean> getWxArticleDetail(int id, int pageNo) {
        return null;
    }

    @Override
    public Flowable<FeedArticleDetailBean> getWxArticleDetail(int id, int pageNo, String java) {
        return null;
    }

    @Override
    public Flowable<FeedArticleDetailBean> getWxArticleTime(int pageNo) {
        return null;
    }

    @Override
    public Flowable<FeedArticleDetailBean> getHomeArticle(int pageNo) {
        return null;
    }

    @Override
    public Flowable<List<HomeBannerBean>> getHomeBanner() {
        return null;
    }

    @Override
    public Flowable<List<WebsiteBean>> getFriend() {
        return null;
    }

    @Override
    public Flowable<List<HotKeyBean>> getHotKey() {
        return null;
    }

    @Override
    public Flowable<List<KnowledgeHierarchyBean>> getKnowledgeHierarchy() {
        return null;
    }

    @Override
    public Flowable<FeedArticleDetailBean> getKnowledgeHierarchyDetail(int pageNo, int cid) {
        return null;
    }

    @Override
    public Flowable<NavigationListBean> getNavigationList() {
        return null;
    }

    @Override
    public Flowable<ArticleListBean> getProjectTree() {
        return null;
    }

    @Override
    public Flowable<FeedArticleDetailBean> getProjectList(int pageNo, int cid) {
        return null;
    }

    @Override
    public Flowable<RegisterBean> login(String username, String password) {
        return httpHelper.login(username, password);
    }

    @Override
    public Flowable<RegisterBean> register(String username, String password, String repassword) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> logout() {
        return null;
    }

    @Override
    public Flowable<BaseEntity> getCollectList(int pageNo) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> collect(int id) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> collectOut(String title, String author, String link) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> unCollectOriginId(int id) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> unCollect(int id, int originId) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> getCollectUserTool() {
        return null;
    }

    @Override
    public Flowable<BaseEntity> addCollectUserTool(String name, String link) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> updateCollectUserTool(int id, String name, String link) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> deleteCollectUserTool(int id) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> search(int pageNo, String k) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> addTodo(String title, String content, String date, int type, int priority) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> updateTode(int id, String title, String content, String date, int type, int status, int priority) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> deleteTode(int id) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> updateTodeStatus(int id, int status) {
        return null;
    }

    @Override
    public Flowable<BaseEntity> getTodeList(int pageNo, int status, int type, int priority, int orderby) {
        return null;
    }

    @Override
    public String getUsername() {
        return preferencesHelper.getUsername();
    }

    @Override
    public void setUsername(String username) {
        preferencesHelper.setUsername(username);
    }

    @Override
    public String getPassword() {
        return preferencesHelper.getPassword();
    }

    @Override
    public void setPassword(String password) {
        preferencesHelper.setPassword(password);
    }

    @Override
    public boolean isLogin() {
        return preferencesHelper.isLogin();
    }

    @Override
    public void setLogin(boolean login) {
        preferencesHelper.setLogin(login);
    }

    @Override
    public boolean isNightMode() {
        return preferencesHelper.isNightMode();
    }

    @Override
    public void setNightMode(boolean nightMode) {
        preferencesHelper.setNightMode(nightMode);
    }
}
