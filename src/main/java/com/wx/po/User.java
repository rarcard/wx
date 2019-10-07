package com.wx.po;

public class User {
    private String encryptedData;
    private  String iv;
    private String code;

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "User{" +
                "encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
