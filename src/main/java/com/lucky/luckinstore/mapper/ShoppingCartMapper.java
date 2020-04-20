package com.lucky.luckinstore.mapper;

import com.lucky.luckinstore.pojo.dto.ShoppingCartDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartMapper {
    /**
     * @description 添加购物车商品
     * @author 张成
     * @date 2019/9/26 17:30
     * @param shoppingCartDTO
     * @return int
     */
    int insertGoodsIntoCart(ShoppingCartDTO shoppingCartDTO);

    /**
     * @description 获取用户的购物车里的所有商品
     * @author 张成
     * @date 2019/10/4 21:58
     * @param userId
     * @return list
     */
    List<ShoppingCartDTO> selectCartByUserId(Integer userId);

    /**
     * @description 删除购物车数据通过id
     * @author 张成
     * @date 2019/10/10 3:10
     * @param cartId
     * @return int 删除成功返回1否则返回0
     */
    int updateDeletedById(Integer cartId);

    /**
     * @Description 根据用户id和确认用户是否添加过此商品
     * @Author 张成
     * @Date 2019/10/13 1:12
     * @param userId
     * @return id
     */
    Integer selectIdByGoodsIdAndUserId(@Param("goodsId") Integer goodsId, @Param("userId") Integer userId);

    /**
     * @Description 更新购物车商品数量
     * @Author 张成
     * @Date 2019/10/13 1:25
     * @param id 购物车id
     * @param num 商品数量
     * @return int 如果成功则返回1
     */
    int updateNumById(@Param("id") Integer id, @Param("num") Integer num);
}