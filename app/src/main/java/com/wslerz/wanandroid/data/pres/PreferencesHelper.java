package com.wslerz.wanandroid.data.pres;

/**
 * @author lzz
 * @time 2019/3/19 10:44
 * @desc
 */
public interface PreferencesHelper {

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    boolean isLogin();

    void setLogin(boolean login);

    boolean isNightMode();

    void setNightMode(boolean nightMode);
}
