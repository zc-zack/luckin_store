package com.lucky.luckinstore.mapper;

import com.lucky.luckinstore.pojo.dto.GoodsDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsMapper {

    /**
     * @description 插入订单里的商品信息
     * @author 张成
     * @date 2019/10/9 13:14
     * @param goodsDTOList 商品列表
     * @param orderId 订单号
     * @param userId 用户id
     * @return int 插入成功返回1，否则返回0
     */
    int insertOrderGoods(@Param("list")List<GoodsDTO> goodsDTOList, @Param("orderId")Integer orderId, @Param("userId") Integer userId);

    /**
     * @description 获取商品通过订单id
     * @author 张成
     * @date 2019/10/12 16:58
     * @param orderId
     * @return list
     */
    List<Integer> selectGoodsIdByOrderId(Integer orderId);
}