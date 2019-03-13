package com.wslerz.wanandroid.http.bean;

/**
 * @author lzz
 * @time 2019/3/11 11:22
 * @desc
 */
public class BaseResponse<T > {
    //    {
//        "data": ...,
//        "errorCode": 0,
//            "errorMsg": ""
//    }
//    errorCode = 0 代表执行成功，不建议依赖任何非0的 errorCode.
//    errorCode = -1001 代表登录失效，需要重新登录。
    public static final int SUCCESS = 0;

    private String errorMsg;
    private int errorCode;
    private T data;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
