/**
 * BaseModel 2017-07-07
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.base;

import android.text.TextUtils;
import android.util.Log;

import com.xingkong.xinkong_library.BaseRetrofit;
import com.xingkong.xinkongtools.XkApi;

import java.util.HashMap;
import java.util.Map;

/**
 * class description here
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-07-07 11:18
 */
public class BaseModel extends BaseRetrofit {

    private static final String TAG = "BaseModel";

    protected XkApi mServletApi;

    protected Map<String, String> mParams = new HashMap<>();

    public BaseModel() {
        super();
        mServletApi = mRetrofit.create(XkApi.class);
    }

    @Override
    protected Map<String, String> getCommonMap() {
        Map<String, String> commonMap = new HashMap<>();
        commonMap.put("userName", "hxl");
        commonMap.put("password", "hxl");
        return commonMap;

    }

    protected void addParams(String key, String value) {
        if (TextUtils.isEmpty(key)) {
            Log.e(TAG, "the key is null");
            return;
        }
        mParams.put(key, value);
    }

    protected void addParams(Map<String, String> params) {
        if (null == params) {
            Log.e(TAG, "the map is null");
            return;
        }
        mParams.putAll(params);
    }
}
