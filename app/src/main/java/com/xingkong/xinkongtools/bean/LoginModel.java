/**
 * LoginModel 2017-07-07
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.bean;

import com.xingkong.xinkong_library.BaseResponse;
import com.xingkong.xinkong_library.HttpFunction;
import com.xingkong.xinkongtools.base.BaseModel;

import java.io.File;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

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

    public void uploadAatar(String path, Observer<BaseResponse<String>> observer) {
        File file = new File(path);
        String type = file.getName().substring(file.getName().indexOf(".") + 1);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/" + type), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        Observable<BaseResponse<String>> observable = mServletApi.uploadAvatar(body);
        toSubscribe(observable, observer);
    }

}
