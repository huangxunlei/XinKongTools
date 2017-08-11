/**
 * XKApi  2017-07-02
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.model;


import com.xingkong.xinkong_library.BaseResponse;
import com.xingkong.xinkongtools.model.login.User;
import com.xingkong.xinkongtools.model.main.MainInfo;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 接口
 *
 * @author huangxunlei
 * @version 1.0.0
 * @since 2017-07-02 23:11
 */
public interface XKApi {
    @FormUrlEncoded
    @POST("LoginServlet")
    Observable<BaseResponse<User>> getUserInfo(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("MainServlet")
    Observable<BaseResponse<List<MainInfo>>> getArticle(@FieldMap Map<String, String> params);


}
