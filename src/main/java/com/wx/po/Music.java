package com.wx.po;

import java.io.Serializable;

/**
 * music
 * @author 
 */
public class Music implements Serializable {
    private Integer id;

    private Integer userid;

    private String musicurl;

    private String musicgrade;

    private String musicimg;

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

    public String getMusicurl() {
        return musicurl;
    }

    public void setMusicurl(String musicurl) {
        this.musicurl = musicurl;
    }

    public String getMusicgrade() {
        return musicgrade;
    }

    public void setMusicgrade(String musicgrade) {
        this.musicgrade = musicgrade;
    }

    public String getMusicimg() {
        return musicimg;
    }

    public void setMusicimg(String musicimg) {
        this.musicimg = musicimg;
    }
}