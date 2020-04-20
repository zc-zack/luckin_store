package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.config.QiniuProperties;
import com.lucky.luckinstore.service.QiniuService;
import com.lucky.luckinstore.util.LayuiUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;

/**
 * @author: 张成
 * @date: Create in 2019/9/26
 * @description:
 */
@Service
public class QiniuServiceImpl implements QiniuService {


    @Autowired
    private QiniuProperties qiniuProperties;

    //日志文件
    private final static Logger logger = LoggerFactory.getLogger(QiniuServiceImpl.class);

    private LayuiUtil layuiUtil;
    private Configuration configuration;
    private UploadManager uploadManager;
    private Auth auth;
    private Response response;
    private DefaultPutRet defaultPutRet;


    @Override
    public JSONObject uploadImage(FileInputStream file, String key) {
        configuration = new Configuration(Zone.zone2());
        uploadManager = new UploadManager(configuration);
        layuiUtil = new LayuiUtil();
        JSONObject result = null;
        auth = Auth.create(qiniuProperties.getAccessKey(), qiniuProperties.getSecretKey());
        String upToken = auth.uploadToken(qiniuProperties.getBucket());
        try {
            response = uploadManager.put(file, key, upToken, null, null);
            defaultPutRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
            String src = qiniuProperties.getPath() + "/" + defaultPutRet.key;
            logger.info("src:" +src);
            result = layuiUtil.getImgJSON(qiniuProperties.getPath() + "/" + defaultPutRet.key);
            logger.info("src:" +result.toJSONString());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void test(){
        System.out.println(qiniuProperties.toString());
    }
}
