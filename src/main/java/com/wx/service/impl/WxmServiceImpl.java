package com.wx.service.impl;

import com.wx.dao.WxMDao;
import com.wx.po.WxM;
import com.wx.service.WxmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WxmServiceImpl implements WxmService {
    @Autowired
    private WxMDao wxMDao;
    public List<WxM> findall() {
        return wxMDao.selectAll() ;
    }

    public WxM findone(Integer id) {
        return wxMDao.selectByPrimaryKey(id);
    }

    public List<WxM> search(String word) {
        return wxMDao.search(word);
    }
}
