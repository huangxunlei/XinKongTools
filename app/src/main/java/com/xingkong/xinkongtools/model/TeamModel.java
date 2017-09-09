/**
 * TeamModel 2017-08-11
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.model;


import com.xingkong.xinkongtools.MyHttpFunction;
import com.xingkong.xinkongtools.base.BaseModel;
import com.xingkong.xinkongtools.bean.MemberInfo;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;

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
     * @param path
     * @param params
     * @param observer
     */
    public void teamManger(String path, Map<String, Object> params, Observer<List<MemberInfo>> observer) {
        Observable<List<MemberInfo>> observable = mServletApi.teamManager(path, params).map(new MyHttpFunction());
        toSubscribe(observable, observer);

    }
}
