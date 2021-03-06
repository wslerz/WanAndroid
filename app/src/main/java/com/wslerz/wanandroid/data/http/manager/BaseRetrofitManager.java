package com.wslerz.wanandroid.data.http.manager;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.wslerz.wanandroid.app.Constants;
import com.wslerz.wanandroid.app.WApplication;
import com.wslerz.wanandroid.base.BaseEntity;
import com.wslerz.wanandroid.base.BaseResponse;
import com.wslerz.wanandroid.data.http.tool.SSLSocketFactoryUtils;

import org.reactivestreams.Publisher;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author lzz
 * @time 2019/3/6 16:57
 * @desc Retrofit基类
 */
public abstract class BaseRetrofitManager {

    //设置缓存的大小50M
    private static final int CACHE_MAX = 1024 * 1024 * 50;

    protected Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(getBaseUrl())
                .client(getClient())
                .build();
    }

    private OkHttpClient getClient() {
        Cache cache = new Cache(new File(Constants.FilePath.PATH_CACHE), CACHE_MAX);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS) //设置超时
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                //错误重连
                .cache(cache)
                .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor)
                .sslSocketFactory(SSLSocketFactoryUtils.createSSLSocketFactory(), SSLSocketFactoryUtils.createTrustAllManager())
                .cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(WApplication.getInstance())))
                .build();
    }


    protected String getBaseUrl() {
        return Constants.Url.BASE_URL;
    }

    protected <T> FlowableTransformer<BaseResponse<T>, T> applySchedulers() {
        return new FlowableTransformer<BaseResponse<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<BaseResponse<T>> upstream) {
                return upstream
//                        .onErrorResumeNext(new HttpResultFunc<BaseResponse<T>>())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMap(new Function<BaseResponse<T>, Flowable<T>>() {
                            @Override
                            public Flowable<T> apply(BaseResponse<T> response) throws Exception {
                                return flatResponse(response);
                            }
                        });
            }
        };
    }

    private <T> Flowable<T> flatResponse(final BaseResponse<T> response) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                if (response != null) {
                    if (response.getErrorCode() == BaseResponse.SUCCESS) {
                        T data = response.getData();
                        if (data == null) {
                            try {
                                data = (T) new BaseEntity();
                            } catch (ClassCastException e) {
                                e.printStackTrace();
                                emitter.onError(new Throwable(e));
                            }
                        }
                        emitter.onNext(data);
                    } else {
                        emitter.onError(new Throwable(response.getErrorMsg(),
                                new Throwable(response.getErrorCode() + "")));
                    }
                }
                emitter.onComplete();
            }
        }, BackpressureStrategy.BUFFER);
    }
}
