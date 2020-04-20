package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.service.ImageService;
import com.lucky.luckinstore.util.LayuiUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author: 张成
 * @date: Create in 2019/9/24
 * @description:
 */
@Service
public class ImageServiceImpl implements ImageService {

    private LayuiUtil layuiUtil;

    /**
     * @param file
     * @return JSON
     * 上传图片
     * @author 张成
     * @date 2019/9/24 8:50
     */
    @Override
    public JSONObject uploadImage(MultipartFile file) {
        JSONObject result = new JSONObject();
        layuiUtil = new LayuiUtil();
        //获取文件的名字
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //文件的保存路径
        String dataImg = "http://localhost:8080/img/" + fileName;
        String filePath = "D:/img/";
        fileName = filePath + fileName;
        result = layuiUtil.getImgJSON(dataImg);
        File imgFile = new File(fileName);
        try {
            file.transferTo(imgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.toString());
        return result;
    }
}
