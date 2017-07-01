/**
 * XKApplication 2017-07-02
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkong_library.app;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

/**
 * 全局唯一的Application实例，只要继承XKApplication就可以了，XKApplication会把this存到单实例引用
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-07-02 03:54
 */
public class XKApplication extends Application {
    private static XKApplication sInstance;
    /**
     * 主线程ID
     */
    public static int mMainThreadId = -1;
    /**
     * 主线程ID
     */
    public static Thread mMainThread;
    /**
     * 主线程Handler
     */
    public static Handler mMainThreadHandler;
    /**
     * 主线程Looper
     */
    public static Looper mMainLooper;


    /**
     * 获取主线程ID
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /**
     * 获取主线程
     */
    public static Thread getMainThread() {
        return mMainThread;
    }

    /**
     * 获取主线程的handler
     */
    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    /**
     * 获取主线程的looper
     */
    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static XKApplication getInstance() {
        return sInstance;
    }

    protected XKApplication() {
        sInstance = this;
        mMainThreadId = android.os.Process.myTid();
        mMainThread = Thread.currentThread();
        mMainThreadHandler = new Handler();
        mMainLooper = getMainLooper();
    }
}
