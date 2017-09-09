package com.xingkong.xinkongtools.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * class description here
 *
 * @author hxl
 * @version 1.0.0
 * @since 2017-08-11 10:56
 */
@Entity
public class MemberInfo {

    /**
     * code : 524018
     * id : 3
     * latitude : 20.029747
     * longitude : 110.368151
     * name : 大队
     * rank : 2
     * rastContent : 测试
     * state : 正在进行
     * taskId : 1
     * teamId : 1
     * tel : 1894264119
     * type : 0
     * username : 韩维
     */


    @Id
    private int id;
    private String code;
    private double latitude;
    private double longitude;
    private String name;
    private String rank;
    private String rastContent;
    private String state;
    private int taskId;
    private String teamId;
    private String tel;
    private String type;
    private String username;

    @Generated(hash = 1509790307)
    public MemberInfo(int id, String code, double latitude, double longitude,
                      String name, String rank, String rastContent, String state, int taskId,
                      String teamId, String tel, String type, String username) {
        this.id = id;
        this.code = code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.rank = rank;
        this.rastContent = rastContent;
        this.state = state;
        this.taskId = taskId;
        this.teamId = teamId;
        this.tel = tel;
        this.type = type;
        this.username = username;
    }

    @Generated(hash = 175316736)
    public MemberInfo() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRastContent() {
        return rastContent;
    }

    public void setRastContent(String rastContent) {
        this.rastContent = rastContent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
