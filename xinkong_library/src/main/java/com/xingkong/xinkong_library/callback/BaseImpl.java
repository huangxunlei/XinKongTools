/**
 * BaseImpl 2017-07-02
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkong_library.callback;

import android.content.Context;

import io.reactivex.disposables.Disposable;

/**
 * class description here
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-07-02 04:13
 */
public interface BaseImpl {
    boolean addDisposable(Disposable disposable);

    Context getContext();
}
