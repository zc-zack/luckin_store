package com.lucky.luckinstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.util.LayuiUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class TestController {

    private LayuiUtil layuiUtil;

    private JSONObject result;

    @RequestMapping("/test")
    @ResponseBody
    public JSONObject test(@RequestParam("file") MultipartFile file) {
        layuiUtil = new LayuiUtil();
//        //获取文件的名字
//        String fileName = file.getOriginalFilename();
//        //获取文件后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        //文件的保存路径
//        String dataImg = "http://localhost:8080/img/" + fileName;
//        String filePath = "D:/img/";
//        fileName = filePath + fileName;
//        result = layuiUtil.getImgJSON(dataImg);
//        File imgFile = new File(fileName);
//        try {
//            file.transferTo(imgFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(file.toString());
        return result;
    }

    @RequestMapping("/user/index")
    public String index(){
        return "index";
    }
}
