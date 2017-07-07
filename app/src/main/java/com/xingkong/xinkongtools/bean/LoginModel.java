/**
 * LoginModel 2017-07-07
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.bean;

import android.util.Log;

import com.xingkong.xinkong_library.HttpFunction;
import com.xingkong.xinkongtools.base.BaseModel;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * class description here
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-07-07 11:27
 */
public class LoginModel extends BaseModel {
    public static LoginModel getInstance() {
        return getPresent(LoginModel.class);
    }

    public void execute(UserDao userDao, Observer<UserDao> observer) {
        Log.e("hxl", mParams.toString());
        Observable observable = mServletApi.login(userDao ).map(new HttpFunction());
        toSubscribe(observable, observer);
    }
}
