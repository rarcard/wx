package com.wx.dao;

import com.wx.po.Kuser;

import java.util.List;

public interface KuserDao {
    int deleteByPrimaryKey(Integer userid);

    int insert(Kuser record);

    int insertSelective(Kuser record);

    Kuser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Kuser record);

    int updateByPrimaryKey(Kuser record);
    Kuser selectByOpenid(String openid);
    List<Kuser>selectFriend(Integer userid);
}