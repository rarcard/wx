package com.wx.controller;

import com.wx.po.Kuser;
import com.wx.po.Music;
import com.wx.po.WxM;
import com.wx.service.KuserService;
import com.wx.service.MusicService;
import com.wx.service.WxmService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传
 */
@Controller
public class FileUploadController {
    /**
     * 执行文件上传
     */
    @Autowired
    private MusicService musicService;
    @Autowired
    private KuserService kuserService;

    @Autowired
    private WxmService wxmService;
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> handleFormUpload(@RequestParam String openid, @RequestParam Integer id,
                                                @RequestParam("uploadfile") List<MultipartFile> uploadfile,
                                                HttpServletRequest request, Model model) {
        // 判断所上传文件是否存在
        System.out.println(id);
        String filex = "";
        Map<String, Object> res = new HashMap<String, Object>();
        if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
            for (MultipartFile file : uploadfile) {
                String originalFilename = file.getOriginalFilename();
                String dirPath =
                        request.getServletContext().getRealPath("/static/file/");
                File filePath = new File(dirPath);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                String newFilename = originalFilename;
                String files = "/static/file/" + newFilename;
                filex = "http://localhost:8080/wx/static/file/"+ newFilename;
                try {
                    model.addAttribute("up", files);
                    file.transferTo(new File(dirPath + newFilename));

                } catch (Exception e) {
                    e.printStackTrace();
                    res.put("code", 0);
                    return res;
                }
            }
            res.put("code", 1);
            System.out.println(filex);
            Kuser kuser = kuserService.selectByOpenid(openid);
            WxM wxM =wxmService.findone(id);
            Music music = new Music();
            music.setUserid(kuser.getUserid());
            music.setMusicgrade(wxM.getName());
            music.setMusicimg(wxM.getImgurl());
            music.setMusicurl(filex);
            int m=musicService.insert(music);

            return res;

        } else {
            res.put("code", 2);
            return res;
        }
    }


//	@RequestMapping("/download")
//	public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,
//	                                           String filename) throws Exception{
//	    // 指定要下载的文件所在路径
//	    String path = request.getServletContext().getRealPath("/upload/");
//	    // 创建该文件对象
//	    File file = new File(path+File.separator+filename);
//	    // 设置响应头
//	    HttpHeaders headers = new HttpHeaders();
//	    // 通知浏览器以下载的方式打开文件
//	    headers.setContentDispositionFormData("attachment", filename);
//	    // 定义以流的形式下载返回文件数据
//	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//	    // 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
//	   return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
//	                                                       headers,HttpStatus.OK);
//	}

    @RequestMapping(value = "/download/{filename}", method = RequestMethod.POST)
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,
                                               @PathVariable("filename") String filename) throws Exception {
        // 指定要下载的文件所在路径
        String path = request.getServletContext().getRealPath("/static/file/");
        // 创建该文件对象
        File file = new File(path + File.separator + filename);
        // 对文件名编码，防止中文文件乱码
        filename = this.getFilename(request, filename);
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        // 通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", filename);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.OK);
    }

    /**
     * 根据浏览器的不同进行编码设置，返回编码后的文件名
     */
    public String getFilename(HttpServletRequest request,
                              String filename) throws Exception {
        // IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核浏览器，统一为UTF-8编码显示
                return URLEncoder.encode(filename, "UTF-8");
            }
        }
        //火狐等其它浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }


}
