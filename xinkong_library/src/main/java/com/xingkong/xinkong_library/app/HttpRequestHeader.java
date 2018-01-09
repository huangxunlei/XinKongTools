package com.xingkong.xinkong_library.app;

import okhttp3.Headers;

/**
 *
 * @author huangxunlei
 * @date 2018/1/9
 *
 * 请求
 */

public class HttpRequestHeader {

    private Headers.Builder mHeaders;


    public Headers.Builder getHeaders() {
        return mHeaders;
    }

    public void setHeaders(Headers.Builder headers) {
        mHeaders = headers;
    }

    public static HttpRequestHeader getInstance() {
        return new HttpRequestHeader();
    }
}
