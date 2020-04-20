package com.lucky.luckinstore.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.pojo.ao.GoodsAO;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/19
 * @description: 封装layui数据
 */
public class LayuiUtil {

    /**
     * @param list
     * @return JSON
     * @description 将传过来的list转化为layui前端能够读取的JSON格式
     * @author 张成
     * @date 2019/9/19 22:02
     */
    public JSONObject getLayuiJSON(List list) {
        JSONObject layuiJSON = new JSONObject();
        JSONArray layuiArray = JSONArray.parseArray(JSON.toJSONString(list));
        layuiJSON.put("code", 0);
        layuiJSON.put("msg", "");
        layuiJSON.put("data", layuiArray);
        return layuiJSON;
    }

    /**
     * @description 封装返回的上传图片的信息
     * @author 张成
     * @date 2019/9/24 0:39
     * @param url
     * @return json
     */
    public JSONObject getImgJSON(String url){
        JSONObject imgJSON = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("src", url);
        imgJSON.put("code", 0);
        imgJSON.put("msg", "");
        imgJSON.put("data", data);
        return imgJSON;
    }
}
