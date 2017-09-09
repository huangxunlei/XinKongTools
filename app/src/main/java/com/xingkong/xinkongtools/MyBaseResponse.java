/**
 * MyBaseResponse 2017-08-11
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * class description here
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-08-11 10:48
 */
public class MyBaseResponse<T> implements Serializable {
    @SerializedName("total")
    private int total;
    @SerializedName("root")
    private T root;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }
}
