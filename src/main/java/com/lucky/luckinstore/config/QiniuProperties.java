package com.lucky.luckinstore.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: 张成
 * @date: Create in 2019/9/26
 * @description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "qiniu")
public class QiniuProperties {
    @Value("accessKey")
    private String accessKey;
    @Value("secretKey")
    private String secretKey;
    @Value("bucket")
    private String bucket;
    @Value("path")
    private String path;
}
