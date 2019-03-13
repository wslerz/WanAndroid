package com.wslerz.wanandroid.http.tool;

import com.google.gson.JsonParseException;
import com.wslerz.wanandroid.app.Constant;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import retrofit2.HttpException;

/**
 * @author lzz
 * @time 2019/3/11 15:06
 * @desc
 */
public class ExceptionConverter {
    private static final String TAG = "ExceptionConverter";
    public static Throwable convertException(Throwable e) {
        Throwable finalThrow;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int httpCode = httpException.code();
            switch (httpCode) {
                case Constant.HttpConstant.REQUEST_TIMEOUT:
                case Constant.HttpConstant.GATEWAY_TIMEOUT:
                case Constant.HttpConstant.BAD_GATEWAY:
                    finalThrow = new Throwable(Constant.HttpConstant.NET_ERROR_MSG,
                            new Throwable(String.valueOf(Constant.HttpConstant.NET_ERROR_CODE)));
                    break;
                case Constant.HttpConstant.SERVICE_UNAVAILABLE:
                case Constant.HttpConstant.FORBIDDEN:
                case Constant.HttpConstant.NOT_FOUND:
                case Constant.HttpConstant.UNAUTHORIZED:
                case Constant.HttpConstant.INTERNAL_SERVER_ERROR:
                default:
                    finalThrow = new Throwable(Constant.HttpConstant.SERVER_ERROR_MSG,
                            new Throwable(String.valueOf(Constant.HttpConstant.SERVER_ERROR_CODE)));
                    break;
            }
            return finalThrow;
        } else if (e instanceof ServerException) {
            ServerException resultException = (ServerException) e;
            finalThrow = new Throwable(resultException.getMessage(), new Throwable(resultException.getCode() + ""));
            return finalThrow;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            finalThrow = new Throwable(Constant.HttpConstant.SERVER_ERROR_MSG,
                    new Throwable(String.valueOf(Constant.HttpConstant.SERVER_ERROR_CODE)));
            return finalThrow;
        } else if (e instanceof ConnectException || e instanceof SocketTimeoutException) {
            finalThrow = new Throwable(Constant.HttpConstant.NET_ERROR_MSG,
                    new Throwable(String.valueOf(Constant.HttpConstant.NET_ERROR_CODE)));
            return finalThrow;
        } else if (e instanceof UnknownHostException) {
            finalThrow = new Throwable(Constant.HttpConstant.SERVER_ERROR_MSG,
                    new Throwable(String.valueOf(Constant.HttpConstant.SERVER_ERROR_CODE)));
            return finalThrow;
        } else {
            finalThrow = new Throwable(Constant.HttpConstant.DEFAULT_ERROR_MSG,
                    new Throwable(String.valueOf(Constant.HttpConstant.DATA_ERROR_CODE)));
            return finalThrow;
        }
    }
}
