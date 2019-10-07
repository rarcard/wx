package com.wx.service;

import com.wx.po.Kuser;

import java.util.List;

public interface KuserService {
    Kuser selectByOpenid(String openid);
    int insert(Kuser kuser);
    List<Kuser> selectFriend(Integer userid);
}
