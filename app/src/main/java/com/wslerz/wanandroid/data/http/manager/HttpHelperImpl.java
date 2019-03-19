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
import com.wslerz.wanandroid.data.http.service.ApiService;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author lzz
 * @time 2019/3/14 10:58
 * @desc
 */
public class HttpHelperImpl extends BaseRetrofitManager implements HttpHelper {
    private ApiService apiService;

    private HttpHelperImpl() {
        apiService = getRetrofit().create(ApiService.class);
    }

    private static final class SingletonHolder {
        private static final HttpHelperImpl INSTANCE = new HttpHelperImpl();
    }

    public static HttpHelperImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public Flowable<List<ArticleListBean>> getWxArticle() {
        return apiService.getWxArticle().compose(this.<List<ArticleListBean>>applySchedulers());
    }

    public Flowable<FeedArticleDetailBean> getWxArticleDetail(int id, int pageNo) {
        return apiService.getWxArticleDetail(id, pageNo).compose(this.<FeedArticleDetailBean>applySchedulers());
    }

    public Flowable<FeedArticleDetailBean> getWxArticleDetail(int id, int pageNo, String k) {
        return apiService.getWxArticleDetail(id, pageNo, k).compose(this.<FeedArticleDetailBean>applySchedulers());
    }

    @Override
    public Flowable<FeedArticleDetailBean> getWxArticleTime(int pageNo) {
        return apiService.getWxArticleTime(pageNo).compose(this.<FeedArticleDetailBean>applySchedulers());
    }

    @Override
    public Flowable<FeedArticleDetailBean> getHomeArticle(int pageNo) {
        return apiService.getHomeArticle(pageNo).compose(this.<FeedArticleDetailBean>applySchedulers());
    }


    public Flowable<List<HomeBannerBean>> getHomeBanner() {
        return apiService.getHomeBanner().compose(this.<List<HomeBannerBean>>applySchedulers());
    }

    public Flowable<List<WebsiteBean>> getFriend() {
        return apiService.getFriend().compose(this.<List<WebsiteBean>>applySchedulers());
    }

    public Flowable<List<HotKeyBean>> getHotKey() {
        return apiService.getHotKey().compose(this.<List<HotKeyBean>>applySchedulers());
    }

    public Flowable<List<KnowledgeHierarchyBean>> getKnowledgeHierarchy() {
        return apiService.getKnowledgeHierarchy().compose(this.<List<KnowledgeHierarchyBean>>applySchedulers());
    }

    @Override
    public Flowable<FeedArticleDetailBean> getKnowledgeHierarchyDetail(int pageNo, int cid) {
        return apiService.getKnowledgeHierarchyDetail(pageNo, cid).compose(this.<FeedArticleDetailBean>applySchedulers());
    }

    @Override
    public Flowable<NavigationListBean> getNavigationList() {
        return apiService.getNavigationList().compose(this.<NavigationListBean>applySchedulers());
    }

    @Override
    public Flowable<ArticleListBean> getProjectTree() {
        return apiService.getProjectTree().compose(this.<ArticleListBean>applySchedulers());
    }

    @Override
    public Flowable<FeedArticleDetailBean> getProjectList(int pageNo, int cid) {
        return apiService.getProjectList(pageNo, cid).compose(this.<FeedArticleDetailBean>applySchedulers());
    }

    @Override
    public Flowable<RegisterBean> login(String username, String password) {
        return apiService.login(username, password).compose(this.<RegisterBean>applySchedulers());
    }

    @Override
    public Flowable<RegisterBean> register(String username, String password, String repassword) {
        return apiService.register(username, password, repassword).compose(this.<RegisterBean>applySchedulers());
    }

    @Override
    public Flowable<BaseEntity> logout() {
        return apiService.logout().compose(this.<BaseEntity>applySchedulers());
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


}
