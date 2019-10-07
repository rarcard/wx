package com.wx.po;

import java.io.Serializable;

/**
 * wx_m
 * @author 
 */
public class WxM implements Serializable {
    private Integer id;

    private String imgurl;

    private String musicurl;

    private String word;

    private String name;

    private String per;

    private String message;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getMusicurl() {
        return musicurl;
    }

    public void setMusicurl(String musicurl) {
        this.musicurl = musicurl;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WxM{" +
                "id=" + id +
                ", imgurl='" + imgurl + '\'' +
                ", musicurl='" + musicurl + '\'' +
                ", word='" + word + '\'' +
                ", name='" + name + '\'' +
                ", per='" + per + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}