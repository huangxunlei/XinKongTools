/**
 * LoginModel  2017-07-02
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.model.login;

import com.xingkong.xinkongtools.base.BaseModel;

import io.reactivex.Observer;

/**
 * class description here
 *
 * @author huangxunlei
 * @version 1.0.0
 * @since 2017-07-02 23:42
 */
public class LoginModel extends BaseModel {
    public static LoginModel getInstance() {
        return getPresent(LoginModel.class);
    }

    public void execute(String phone, String password, Observer<User> observer) {
        addParams("username", phone);
        addParams("password", password);
        //Observable observable = mServletApi.getUserInfo(mParams).map();
        // toSubscribe(observable, observer);
    }
}
