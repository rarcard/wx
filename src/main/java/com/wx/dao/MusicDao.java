package com.wx.dao;

import com.wx.po.Music;

import java.util.List;

public interface MusicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Music record);

    int insertSelective(Music record);

    Music selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);
    List<Music> selectByUserId(Integer userid);
}