/**
 * XKToast 2017-07-02
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkong_library.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.Toast;

import com.xingkong.xinkong_library.app.XKApplication;

/**
 * 对toast的封装
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-07-02 04:17
 */
public class XKToast {
    private static Toast mToast = null;

    public XKToast() {
    }

    /**
     * 获取资源
     *
     * @return 资源
     */
    private static Resources getResources() {
        return XKApplication.getInstance().getResources();
    }

    /**
     * 获取文字
     *
     * @param resId 文字的对应的资源id
     * @return
     */
    private static String getString(int resId) {
        return XKApplication.getInstance().getResources().getString(resId);
    }

    private static long getMainThreadId() {
        return XKApplication.getMainThreadId();
    }

    /**
     * 获取主线程的handler
     */
    private static Handler getHandler() {
        return XKApplication.getMainThreadHandler();
    }

    /**
     * 在主线程执行runnable
     */
    private static boolean post(Runnable runnable) {
        return getHandler().post(runnable);
    }

    /**
     * 判断当前的线程是不是在主线程
     *
     * @return
     */
    private static boolean isRunInMainThread() {
        return android.os.Process.myTid() == getMainThreadId();
    }

    /**
     * 对toast的简易封装。线程安全，可以在非UI线程调用。
     */
    public static void showToastSafe(final int resId) {
        showToastSafe(getString(resId));
    }

    /**
     * 对toast的简易封装。线程安全，可以在非UI线程调用。
     */
    public static void showToastSafe(final String str) {
        if (isRunInMainThread()) {
            showToast(str);
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    showToast(str);
                }
            });
        }
    }

    private static void showToast(String str) {
        Context context = XKApplication.getInstance();
        if (context != null) {
            showToast(context, str);
        }
    }

    public static void showToast(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_LONG);
        }

        mToast.show();
    }

}
