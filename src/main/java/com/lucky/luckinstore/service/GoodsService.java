package com.lucky.luckinstore.service;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.pojo.ao.GoodsAO;
import com.lucky.luckinstore.pojo.dto.GoodsDTO;
import com.lucky.luckinstore.pojo.dto.LabelDTO;
import com.lucky.luckinstore.pojo.vo.GoodsVO;
import com.lucky.luckinstore.pojo.vo.LabelVO;
import com.lucky.luckinstore.util.Result;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/19
 * @description: 商品的service层
 */
public interface GoodsService {

    /**
     * @return json
     * @description 获取所有商品，返回格式是json的格式
     * @author 张成
     * @date 2019/9/19 22:14
     */
    JSONObject selectAllGoodsJSON(Integer status);

    /**
     * @param goodsDTO
     * @return result 如果成功，则result.data为1否则为0
     * @description 插入商品
     * @author 张成
     * @date 2019/9/20 14:44
     */
    Result<Integer> insertGoods(GoodsDTO goodsDTO);

    /**
     * @param deleted
     * @return json
     * @description 返回所有的标签
     * @author 张成
     * @date 2019/9/21 14:06
     */
    JSONObject selectAllLabelJSON(Boolean deleted);

    /**
     * @param labelDTO
     * @return result 如果插入新标签成功则result.data为1，否则为0
     * @description 插入新的标签
     * @author 张成
     * @date 2019/9/21 14:54
     */
    Result<Integer> insertLabel(LabelDTO labelDTO);

    /**
     * @description 获取所有标签的list
     * @author 张成
     * @date 2019/9/23 9:18
     * @param deleted
     * @return list
     */
    List<LabelVO> selectAllLabelListByDeleted(Boolean deleted);

    /**
     * @description 获取所有商品的List
     * @author 张成
     * @date 2019/9/23 18:02
     * @param status
     * @return list
     */
    List<GoodsAO> selectAllGoodsList(Integer status);

    /**
     * @description 修改商品信息的service
     * @author 张成
     * @date 2019/9/23 21:50
     * @param goodsDTO
     * @return result 如果更新成功则result.data 为1，否则为0
     */
    Result<Integer> updateGoodsById(GoodsDTO goodsDTO);

    /**
     * @description 修改商品状态
     * @author 张成
     * @date 2019/9/24 10:25
     * @param goodsDTO
     * @return result 如果修改成功则result.data值为1否则为0
     */
    Result<Integer> updateGoodsStatusById(GoodsDTO goodsDTO);

    /** 
     * @description 模糊查询获取数据
     * @author 张成
     * @date 2019/9/24 18:10
     * @param goodsName
     * @return list
     */
    Result<List> selectGoodsByNameList(String goodsName, Integer pageNum, Integer pageSize);


    /**
     * @description 通过商品的id获取商品的详细信息
     * @author 张成
     * @date 2019/9/26 16:04
     * @param id
     * @return goodAO
     */
    GoodsVO selectGoodsById(Integer id);

    /**
     * @description 通过商品名字获取商品信息
     * @author 张成
     * @date 2019/10/7 16:11
     * @param goodsName
     * @param status
     * @return list
     */
    List<GoodsVO> selectGoodsByNameAndStatusList(String goodsName,Integer labelId, Integer status);

    /**
     * @description 对购物车里的订单进行验证
     * @author 张成
     * @date 2019/10/9 16:16
     * @param goodsDTOList 商品的List
     * @return result
     */
    Result<Integer> selectGoodsListById(List<GoodsDTO> goodsDTOList);

    /**
     * @description 从session里获取订单的商品列表
     * @author 张成
     * @date 2019/10/9 16:35
     * @return list 商品的list
     */
    List<GoodsVO> getOrderGoodsList();

    /**
     * @description 购买商品后商品数量的更新
     * @author 张成
     * @date 2019/10/9 18:07
     * @param goodsDTOList
     * @return Integer
     */
    Integer updateGoodsAmount(List<GoodsDTO> goodsDTOList);

    /**
     * @Description 通过根据热度返回商品信息
     * @author 张成
     * @date 2019/10/11 21:08
     * @param goodsName
     * @return list
     */
    List<GoodsVO> selectGoodsByBehavior(String goodsName);

    /**
     * @Description 取消订单回滚操作
     * @Author 张成
     * @Date 2019/10/14 1:21
     * @param goodsDTOList
     * @return int
     */
    int updateAmountByCancelOrder(List<GoodsDTO> goodsDTOList);
}
