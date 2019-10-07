package com.wx.po;

import java.io.Serializable;

/**
 * kuser
 * @author 
 */
public class Kuser implements Serializable {
    private Integer userid;

    private String openid;

    private String userno;

    private String userflower;

    private String img;

    private String username;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getUserflower() {
        return userflower;
    }

    public void setUserflower(String userflower) {
        this.userflower = userflower;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}