package com.wx.service.impl;

import com.wx.dao.KuserDao;
import com.wx.po.Kuser;
import com.wx.service.KuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class KuserServiceImpl implements KuserService {
    @Autowired
    private KuserDao kuserDao;

    public Kuser selectByOpenid(String openid) {
        return kuserDao.selectByOpenid(openid);
    }

    public int insert(Kuser kuser) {
        return kuserDao.insertSelective(kuser);
    }

    public List<Kuser> selectFriend(Integer userid) {
        return kuserDao.selectFriend(userid);
    }
}
