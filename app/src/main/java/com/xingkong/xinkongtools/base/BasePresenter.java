/**
 * BasePresenter 2017-07-02
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.base;

import java.lang.ref.WeakReference;

/**
 * class description here
 *
 * @author huangxunlei
 * @version 1.0.0
 * @since 2017-07-02 22:57
 */
public class BasePresenter<VIEW> {
    private WeakReference<VIEW> mViews;

    protected void attachView(VIEW view) {
        mViews = new WeakReference<VIEW>(view);
    }

    protected VIEW getView() {
        return isViewAttached() ? mViews.get() : null;
    }

    private boolean isViewAttached() {
        return null != mViews && null != mViews.get();
    }

    protected void detachView() {
        if (null != mViews) {
            mViews.clear();
            mViews = null;
        }
    }
}
