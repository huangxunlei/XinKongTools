/**
 * MyHttpFunction 2017-08-11
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools;


import android.util.Log;

import io.reactivex.functions.Function;

/**
 * class description here
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-08-11 10:47
 */
public class MyHttpFunction<T> implements Function<MyBaseResponse<T>, T> {
    @Override
    public T apply(MyBaseResponse<T> response) throws Exception {
        Log.e("hxl", response.getTotal() + "");
        return response.getRoot();
    }
}
