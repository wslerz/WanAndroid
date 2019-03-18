package com.wslerz.wanandroid.http.bean;

import com.wslerz.wanandroid.base.BaseEntity;

/**
 * @author lzz
 * @time 2019/3/18 16:14
 * @desc
 */
public class TagsBean extends BaseEntity {
    /**
     * name : 公众号
     * url : /wxarticle/list/408/1
     */

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
