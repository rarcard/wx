package com.wx.controller;

import com.wx.po.WxM;
import com.wx.service.WxmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {
@Autowired
private WxmService wxmService;
    @RequestMapping(value = "/getdada" ,method = RequestMethod.GET)
    @ResponseBody
    public List<WxM> addr_getList() {
         List<WxM> wxMList=wxmService.findall();
        return wxMList;
    }
    @RequestMapping(value = "/getone" ,method = RequestMethod.POST)
    @ResponseBody
    public WxM addr(@RequestBody WxM wxMS) {
       WxM wxM=wxmService.findone(wxMS.getId());
        return wxM;
    }
}