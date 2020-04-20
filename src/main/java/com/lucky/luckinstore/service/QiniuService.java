package com.lucky.luckinstore.service;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author: 张成
 * @date: Create in 2019/9/26
 * @description:
 */
public interface QiniuService {

    JSONObject uploadImage(FileInputStream file, String key);

    void test();
}

