package com.wx.po;

import java.io.Serializable;

/**
 * friend
 * @author 
 */
public class Friend implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer friendid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFriendid() {
        return friendid;
    }

    public void setFriendid(Integer friendid) {
        this.friendid = friendid;
    }
}