package com.lucky.luckinstore.service;

import com.lucky.luckinstore.pojo.dto.CartGoodsDTO;
import com.lucky.luckinstore.pojo.dto.ShoppingCartDTO;
import com.lucky.luckinstore.pojo.vo.ShoppingCartVO;
import com.lucky.luckinstore.util.Result;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/26
 * @description:
 */
public interface ShoppingCartService {
    /**
     * @description 添加商品至购物车
     * @author 张成
     * @date 2019/9/26 17:22
     * @param shoppingCartDTO
     * @return int
     */
    Result<Integer> insertGoodsIntoCart(ShoppingCartDTO shoppingCartDTO);

    /**
     * @description 获取所有商品的信息
     * @author 张成
     * @date 2019/10/4 21:59
     * @return list
     */
    List<ShoppingCartVO> selectCartByUserId();

    /**
     * @description 将选中的购物车数据暂存session里
     * @author 张成
     * @date 2019/10/9 20:44
     * @param cartGoodsDTOList
     * @return result
     */
    Result<Integer> saveCartGoodsList( List<CartGoodsDTO> cartGoodsDTOList);

    /**
     * @description 删除购物车的商品
     * @author 张成
     * @date 2019/10/10 3:13
     * @param cartId 购物车id
     * @return result 删除成功result.data 为1 否则为0
     */
    Result<Integer> updateDeletedById(Integer cartId);

}
