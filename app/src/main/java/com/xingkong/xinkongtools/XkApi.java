/**
 * XkApi 2017-07-07
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools;

import com.xingkong.xinkong_library.BaseResponse;
import com.xingkong.xinkongtools.bean.MemberInfo;
import com.xingkong.xinkongtools.bean.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * class description here
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-07-07 11:20
 */
public interface XkApi {
    @POST("login")
    Observable<BaseResponse<UserDao>> login(@QueryMap HashMap<String, String> params);
    /**
     * 上传头像
     *
     * @param file
     * @return
     */
    @Multipart
    @POST("upload4")
    Observable<BaseResponse<String>> uploadAvatar(@Part MultipartBody.Part file);

    @POST("BDSatelliteInfoService/teamManagerAction_{path}.action")
    Observable<MyBaseResponse<List<MemberInfo>>>teamManager(@Path("path") String path, @QueryMap Map<String, Object> param);
}
