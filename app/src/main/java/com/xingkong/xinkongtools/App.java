package com.xingkong.xinkongtools;

import com.xingkong.xinkong_library.HttpServletAddress;
import com.xingkong.xinkong_library.app.XKApplication;

/**
 * Created by hxl on 2017/7/2 0002.
 */

public class App extends XKApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpServletAddress.getInstance().setOfflineAddress("http://192.168.1.136:8080/");
    }
}
