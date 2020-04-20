package com.lucky.luckinstore.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: 张成
 * @date: Create in 2019/9/20
 * @description: 操作会员的服务层
 */
public interface MemberService {

    /**
     * @param status
     * @return json
     * @description 返回所有用户的JSON数据
     * @author 张成
     * @date 2019/9/20 10:55
     */
    JSONObject getAllUserByStatusJSON(Integer status);
}
