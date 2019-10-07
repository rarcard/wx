package com.wx.dao;

import com.wx.po.WxM;

import java.util.List;

public interface WxMDao {
    int deleteByPrimaryKey(Integer id);

    int insert(WxM record);

    int insertSelective(WxM record);

    WxM selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxM record);

    int updateByPrimaryKey(WxM record);
    List<WxM> selectAll();
    List<WxM> search(String word);
}