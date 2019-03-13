package com.wslerz.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author lzz
 * @time 2019/3/13 15:20
 * @desc BaseTabFragment  懒加载
 */
public abstract class BaseTabFragment extends BaseFragment implements BaseView {
    //当前Fragment是否可见
    private boolean isVisible = false;
    //是否与View建立起映射关系
    private boolean isInitView = false;
    //是否是第一次加载数据
    private boolean isFirstLoad = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isInitView = true;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void showData() {
        if ((isFirstLoad && isInitView && isVisible)) {
            isFirstLoad = false;
            bindData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        if (isVisibleToUser) {
            showData();
        }
    }
}
