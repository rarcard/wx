package com.wx.service.impl;

import com.wx.dao.MusicDao;
import com.wx.po.Music;
import com.wx.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicDao musicDao;
    public List<Music> findByUserId(Integer userid) {
        return musicDao.selectByUserId(userid);
    }

    public Music findById(Integer id) {
        return musicDao.selectByPrimaryKey(id);
    }

    public int insert(Music music) {
        return musicDao.insertSelective(music);
    }
}
