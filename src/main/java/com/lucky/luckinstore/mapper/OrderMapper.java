package com.lucky.luckinstore.mapper;

import com.lucky.luckinstore.pojo.ao.OrderAO;
import com.lucky.luckinstore.pojo.dto.*;
import com.lucky.luckinstore.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    /**
     * @description 查询所有订单信息情况
     * @author 张成
     * @date 2019/9/23 12:21
     * @return list
     */
    List<OrderAO> selectAllOrder();

    /**
     * @description 修改订单信息，修改收货地址和联系电话
     * @author 张成
     * @date 2019/9/23 16:38
     * @param orderDTO
     * @return int
     */
    int updateOrderByOrderId(OrderDTO orderDTO);

    /**
     * @description 根据状态查询订单
     * @author 张成
     * @date 2019/9/24 22:49
     * @param searchOrderDTO
     * @return list
     */
    List<OrderDTO> selectOrderByStatusAndTele(SearchOrderDTO searchOrderDTO);

    /**
     * @description 通过手机号查询订单
     * @author 张成
     * @date 2019/9/25 1:01
     * @param
     * @return
     */
    List<OrderAdminDTO> selectOrderByTele(SearchOrderDTO searchOrderDTO);

    /**
     * @description 创建新的订单
     * @author 张成
     * @date 2019/9/27 1:12
     * @param orderDTO
     * @return int
     */
    int insertOrder(OrderDTO orderDTO);

    /**
     * @description 修改订单状态
     * @author 张成
     * @date 2019/9/29 10:48
     * @param status
     * @param orderId
     * @return int
     */
    int updateOrderStatusById(@Param("status") Integer status, @Param("orderId")Integer orderId);

    /**
     * @description 根据用户id返回所有订单
     * @author 张成
     * @date 2019/9/29 17:28
     * @param userId
     * @return list
     */
    List<OrderDTO> selectOrderByUserId(Integer userId);

    /**
     * @description 根据订单id获取价钱
     * @author 张成
     * @date 2019/9/29 18:46
     * @param orderId
     * @return double
     */
    Double selectPriceById(Integer orderId);

    /**
     * @description 根据订单id返回订单
     * @author 张成
     * @date 2019/10/9 22:35
     * @param orderId 订单号
     * @return list 订单的List
     */
    OrderDTO selectOrderById(Integer orderId);

    /**
     * @description 用户付款时修改订单的状态
     * @author 张成
     * @date 2019/10/10 13:57
     * @param payDTO
     * @return int 修改成功返回1否则返回0
     */
    int updateStatusByPay(PayDTO payDTO);

}