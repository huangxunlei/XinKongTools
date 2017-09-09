/**
 * MyApplication 2017-07-07
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools;

import com.xingkong.xinkong_library.HttpServletAddress;
import com.xingkong.xinkong_library.app.XKApplication;

/**
 * class description here
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-07-07 10:15
 */
public class MyApplication extends XKApplication {
    @Override
    public void onCreate() {
        super.onCreate();

      //  PgyCrashManager.register(this);
        HttpServletAddress.getInstance().setOfflineAddress("http://192.168.1.136:8080/");
    }
}
