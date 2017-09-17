package com.xingkong.xinkong_library.app;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by hxl on 2017/9/12 0012.
 * 设置okhttp的debug显示模式
 */

public class LogLevel {
    private HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;

    public static LogLevel getInstance() {
        return LogLevel.SingletonHolder.INSTANCE;
    }

    private static final class SingletonHolder {
        private static final LogLevel INSTANCE = new LogLevel();


        private SingletonHolder() {
        }
    }

    public void setLevel(HttpLoggingInterceptor.Level level) {
        this.level = level;
    }

    public HttpLoggingInterceptor.Level getLevel() {
        return level;
    }
}
