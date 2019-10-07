package com.wx.service;

import com.wx.po.WxM;

import java.util.List;

public interface WxmService {
    List<WxM> findall();
    WxM findone(Integer id);
    List<WxM> search(String word);
}
