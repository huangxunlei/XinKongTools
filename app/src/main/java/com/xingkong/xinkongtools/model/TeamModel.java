/**
 * TeamModel 2017-08-11
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.model;


import android.util.Log;

import com.google.gson.Gson;
import com.xingkong.xinkong_library.app.HttpRequestHeader;
import com.xingkong.xinkongtools.MyHttpFunction;
import com.xingkong.xinkongtools.base.BaseModel;
import com.xingkong.xinkongtools.base.SPUtils;
import com.xingkong.xinkongtools.bean.MemberInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.Headers;
import okhttp3.internal.http2.Header;

/**
 * class description here
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-08-11 11:09
 */
public class TeamModel extends BaseModel {

    public static TeamModel getInstance() {
        return getPresent(TeamModel.class);
    }

    /**
     * 队伍管理
     *
     * @param path
     * @param params
     * @param observer
     */
    public void teamManger(String path, Map<String, Object> params, Observer<List<MemberInfo>> observer) {
        Observable<List<MemberInfo>> observable = mServletApi.teamManager(path, params).map(new MyHttpFunction());
        toSubscribe(observable, observer);

    }

    public String login() {
        final String[] token = new String[1];
        Observable observable = mServletApi.login("abcdefg", "18300856840", "123456");
        toSubscribe(observable, new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object s) {
                Log.e("hxl", "登录成功:" + s.toString());
                try {
                    JSONObject jsonObject = new JSONObject(s.toString());
                    JSONObject data = jsonObject.getJSONObject("data");
                    token[0] = data.getString("token");
                    SPUtils.getInstance().put("id", token[0]);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
             e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });
        return token[0];
    }

    public void info(String token) {
        Observable observable = mServletApi.getInfo("abcdefg");
        toSubscribe(observable, new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object s) {

                Gson gson=new Gson();
                Log.e("hxl", "登录成功:" + gson.toJson(s));

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
