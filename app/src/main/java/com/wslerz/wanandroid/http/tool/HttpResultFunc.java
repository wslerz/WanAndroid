package com.wslerz.wanandroid.http.tool;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * @author lzz
 * @time 2019/3/11 14:28
 * @desc
 */
public class HttpResultFunc<T> implements Function<Throwable, Flowable<T>> {
    @Override
    public Flowable<T> apply(Throwable throwable) throws Exception {
        return Flowable.error(ExceptionConverter.convertException(throwable));
    }
}
