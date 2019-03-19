package com.wslerz.wanandroid.data.pres;

import android.content.Context;
import android.content.SharedPreferences;

import com.wslerz.wanandroid.app.Constants;
import com.wslerz.wanandroid.app.WApplication;

/**
 * @author lzz
 * @time 2019/3/19 10:44
 * @desc
 */
public class PreferencesHelperImpl implements PreferencesHelper {

    private SharedPreferences sp;

    private PreferencesHelperImpl() {
        sp = WApplication.getInstance().getSharedPreferences(Constants.FilePath.SHARE_PREFER, Context.MODE_PRIVATE);
    }

    private static class SingletonHolder {
        private static PreferencesHelperImpl INSTANCE = new PreferencesHelperImpl();
    }

    public static PreferencesHelperImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public String getUsername() {
        return sp.getString(Constants.SharePrefer.USER_NAME, "");
    }

    @Override
    public void setUsername(String username) {
        sp.edit().putString(Constants.SharePrefer.USER_NAME, username).apply();
    }

    @Override
    public String getPassword() {
        return sp.getString(Constants.SharePrefer.PASSWORD, "");
    }

    @Override
    public void setPassword(String password) {
        sp.edit().putString(Constants.SharePrefer.PASSWORD, password).apply();
    }

    @Override
    public boolean isLogin() {
        return sp.getBoolean(Constants.SharePrefer.LOGIN, false);
    }

    @Override
    public void setLogin(boolean login) {
        sp.edit().putBoolean(Constants.SharePrefer.LOGIN, login).apply();
    }

    @Override
    public boolean isNightMode() {
        return sp.getBoolean(Constants.SharePrefer.NIGHT_MODE, false);
    }

    @Override
    public void setNightMode(boolean nightMode) {
        sp.edit().putBoolean(Constants.SharePrefer.NIGHT_MODE, nightMode).apply();
    }
}
