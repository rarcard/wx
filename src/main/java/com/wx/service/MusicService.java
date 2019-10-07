package com.wx.service;

import com.wx.po.Music;

import java.util.List;

public interface MusicService {
    List<Music> findByUserId(Integer userid);
    Music findById(Integer id);
    int insert(Music music);
}
