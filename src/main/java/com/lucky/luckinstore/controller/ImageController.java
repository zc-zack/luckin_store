package com.lucky.luckinstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.service.ImageService;
import com.lucky.luckinstore.service.QiniuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: 张成
 * @date: Create in 2019/9/24
 * @description: 图片处理的TOC
 */
@RestController
public class ImageController {

    @Autowired
    private QiniuService qiniuService;

    /** 
     * @description 
     * @author 张成
     * @date 2019/10/11 18:17
     * @param  file 晚间
     * @return
     */
    @RequestMapping("/uploadImage")
    @ResponseBody
    public JSONObject uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        JSONObject src = qiniuService.uploadImage((FileInputStream) file.getInputStream(), fileName);
        return src;
    }
}
