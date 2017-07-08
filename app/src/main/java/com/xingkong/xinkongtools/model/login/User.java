/**
 * User 2017-07-02
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.model.login;

/**
 * class description here
 *
 * @author huangxunlei
 * @version 1.0.0
 * @since 2017-07-02 23:13
 */
public class User {
    private Long id;// 用户id
    private String token;//登录open_id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
