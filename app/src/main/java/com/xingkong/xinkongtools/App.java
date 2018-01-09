package com.xingkong.xinkongtools;

import com.xingkong.xinkong_library.HttpServletAddress;
import com.xingkong.xinkong_library.app.LogLevel;
import com.xingkong.xinkong_library.app.XKApplication;
import com.xingkong.xinkongtools.base.Utils;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by hxl on 2017/7/2 0002.
 */

public class App extends XKApplication {
    @Override
    public void onCreate() {
        Utils.init(this);
        super.onCreate();
    }
}
