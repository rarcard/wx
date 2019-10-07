package com.wx.controller;


import com.wx.po.Kuser;
import com.wx.po.User;
import com.wx.service.KuserService;
import com.wx.util.AesCbcUtil;
import com.wx.util.HttpRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class loController {
    @Autowired
   private KuserService kuserService;

    @ResponseBody
    @RequestMapping(value = "/decodeUserInfo", method = RequestMethod.POST)
    public Map decodeUserInfo(@RequestBody User encryptedData) {

        Map map = new HashMap();
        //登录凭证不能为空
        if (encryptedData.getCode() == null || encryptedData.getCode().length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        String wxspAppid =
                "wx78e814f63c08c5a0";
        String wxspSecret = "219ef811fec963e6dd9348a40aa2f5aa";
        String grant_type = "authorization_code";
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + encryptedData.getCode() + "&grant_type=" + grant_type;
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        JSONObject json = JSONObject.fromObject(sr);
        String session_key = json.get("session_key").toString();
        String openid = (String) json.get("openid");
        try {
            String result = AesCbcUtil.decrypt(encryptedData.getEncryptedData(), session_key, encryptedData.getIv(), "UTF-8");
            if (null != result && result.length() > 0) {

                map.put("status", 1);
                map.put("msg", "解密成功");
                JSONObject userInfoJSON = JSONObject.fromObject(result);
                Map userInfo = new HashMap();
                userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                userInfo.put("unionId", userInfoJSON.get("unionId"));
                map.put("userInfo", userInfo);
                String openids= (String) userInfoJSON.get("openId");
                String name= (String) userInfoJSON.get("nickName");
                if(kuserService.selectByOpenid(openids)==null){
                    Kuser kuser=new Kuser();
                    kuser.setImg("https://wx.qlogo.cn/mmopen/vi_32/z8cTVftXphLL5GUoh1J6IWEEN7iav9pT20HGlSgP1AzB1QiaibR2xgQAJE0OicWV9ddgrl0j6kn9MZD22z02KGwyqg/132");
                    kuser.setOpenid(openids);
                    String a= UUID.randomUUID().toString();
                    kuser.setUserno(a);
                    kuser.setUserflower("0");
                    kuserService.insert(kuser);
                }
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
    }

}
