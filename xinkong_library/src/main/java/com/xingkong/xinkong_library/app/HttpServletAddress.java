/**
 * HttpServletAddress 2017-07-02
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkong_library.app;

import android.text.TextUtils;

/**
 * 设置网络请求的公共地址  可以是测试地址和服务器地址
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-07-02 04:26
 */
public class HttpServletAddress {
    private String onlineAddress;   //线上地址
    private String offlineAddress;  //线下地址

    private static final class SingletonHolder {
        private static final HttpServletAddress INSTANCE = new HttpServletAddress();
    }

    private HttpServletAddress() {
    }

    public String getOnlineAddress() {
        return onlineAddress;
    }

    public void setOnlineAddress(String onlineAddress) {
        this.onlineAddress = onlineAddress;
    }

    public String getOfflineAddress() {
        return offlineAddress;
    }

    public void setOfflineAddress(String offlineAddress) {
        this.offlineAddress = offlineAddress;
    }

    public String getServletAddress() {
        return TextUtils.isEmpty(onlineAddress) ? offlineAddress : onlineAddress;
    }
}
