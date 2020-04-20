package com.lucky.luckinstore.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 张成
 * @date: Create in 2019/9/24
 * @description:
 */
public interface ImageService {
    /**
     * @description 上传图片
     * @author 张成
     * @date 2019/9/24 8:50
     * @param file
     * @return JSON
     */
    JSONObject uploadImage(MultipartFile file);
}
