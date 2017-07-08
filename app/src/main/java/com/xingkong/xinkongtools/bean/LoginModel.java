/**
 * LoginModel 2017-07-07
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.bean;

import com.xingkong.xinkong_library.HttpFunction;
import com.xingkong.xinkongtools.base.BaseModel;

import java.util.HashMap;

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

    public void execute(UserDao userDao, Observer<UserDao> body) {
        // Log.e("hxl", mParams.toString());
        HashMap<String, String> map = new HashMap<>();
        map.put("userName", userDao.getUserName());
        map.put("pwd", userDao.getPwd());
        Observable observable = mServletApi.login(map).map(new HttpFunction());
        toSubscribe(observable, body);
    }
}
