package com.wx.controller;

import com.wx.po.Keyword;
import com.wx.po.Kuser;
import com.wx.po.Music;
import com.wx.po.WxM;
import com.wx.service.KuserService;
import com.wx.service.MusicService;
import com.wx.service.WxmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KuserController {
    @Autowired
    private KuserService kuserService;
    @Autowired
    private MusicService musicService;
    @Autowired
    private WxmService wxmService;
    @RequestMapping(value = "getkuser",method = RequestMethod.POST)
    @ResponseBody
    public Kuser getkuser(@RequestBody Kuser kusers){
        Kuser kuser=kuserService.selectByOpenid(kusers.getOpenid());
        return kuser;
    }
    @RequestMapping(value="getFriend",method = RequestMethod.POST)
    @ResponseBody
    public List<Kuser> getfriend(@RequestBody Kuser kusers){
        Kuser kuser=kuserService.selectByOpenid(kusers.getOpenid());
        List<Kuser>kuserList=kuserService.selectFriend(kuser.getUserid());
        return kuserList;
    }
    @RequestMapping(value="getMusic",method = RequestMethod.POST)
    @ResponseBody
    public List<Music> music(@RequestBody Kuser kusers){
        Kuser kuser=kuserService.selectByOpenid(kusers.getOpenid());
        List<Music>musicList=musicService.findByUserId(kuser.getUserid());
        return musicList;
    }
    @RequestMapping(value="getMusicx",method = RequestMethod.POST)
    @ResponseBody
    public Music musicx(@RequestBody Music music){


        return musicService.findById(music.getId());
    }
    @RequestMapping(value="grade",method =RequestMethod.GET)
    @ResponseBody
    public String[] grade(){
        String[] num=new String[2];
        int numx= (int)(Math.random( )*50+50) ;
        num[0]=numx+"";
        if(numx<=60){
           num[1]="D" ;
        }
        else if(60<numx&&numx<=80){
            num[1]="C";
        }
        else if(80<numx&&numx<=90){
            num[1]="B";
        }
        else if(90<numx&&numx<=100){
            num[1]="A";
        }
        System.out.println(num);
        return num;

    }
    @RequestMapping(value="search",method = RequestMethod.POST)
    @ResponseBody
    public List<WxM> search(@RequestBody Keyword word){
        if (word==null){
            return null;
        }
        System.out.println("搜索");
        System.out.println(word);
        List<WxM> wxMList= wxmService.search(word.getWord());
        return wxMList;
    }
}
