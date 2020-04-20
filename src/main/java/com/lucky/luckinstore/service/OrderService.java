package com.lucky.luckinstore.service;

import com.alibaba.fastjson.JSONObject;
import com.lucky.luckinstore.pojo.ao.OrderAO;
import com.lucky.luckinstore.pojo.dto.OrderDTO;
import com.lucky.luckinstore.pojo.dto.PayDTO;
import com.lucky.luckinstore.pojo.dto.SearchOrderDTO;
import com.lucky.luckinstore.pojo.vo.OrderVO;
import com.lucky.luckinstore.util.Result;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/23
 * @description:
 */
public interface OrderService {

    /**
     * @description 获取所有订单，返回list格式
     * @author 张成
     * @date 2019/9/23 12:23
     * @return list
     */
    List<OrderAO> selectAllOrderList();


    /**
     * @description 修改订单信息
     * @author 张成
     * @date 2019/9/23 16:39
     * @param orderDTO
     * @return result， 如果修改成功则result.data为1否则为0
     */
    Result<Integer> updateOrderByOrderId(OrderDTO orderDTO);

    /**
     * @description 获取订单的list
     * @author 张成
     * @date 2019/9/24 22:51
     * @param searchOrderDTO
     * @return list
     */
    List<OrderVO> selectOrderByStatusList(SearchOrderDTO searchOrderDTO);


    /**
     * @description 封装实体类
     * @author 张成
     * @date 2019/9/25 0:40
     * @param status
     * @Param tele
     * @return SearchOrderDTO
     */
    SearchOrderDTO getSearchOrderDTO(String tele, Integer status);

    /**
     * @description 通过手机号查询订单返回list
     * @author 张成
     * @date 2019/9/25 1:03
     * @param tele 手机号
     * @param status 订单状态
     * @return result
     */
    Result<List> selectOrderByTeleList(String tele, Integer status, Integer page, Integer limit);


    /**
     * @description 创建新的订单
     * @author 张成
     * @date 2019/9/27 1:13
     * @param
     * @return
     */
    Result<Integer> insertOrder(OrderDTO orderDTO);

    /**
     * @description 返回要付款的订单信息
     * @author 张成
     * @date 2019/9/29 9:27
     * @param orderId
     * @return orderVO
     */
    OrderDTO selectOrderById(Integer orderId);

    /**
     * @description 根据订单id修改订单状态
     * @author 张成
     * @date 2019/9/29 10:49
     * @param status
     * @param orderId
     * @return int
     */
    int updateOrderStatusById(Integer status, Integer orderId);

    /**
     * @description 返回所有订单
     * @author 张成
     * @date 2019/9/29 17:32
     * @return list
     */
    List<OrderDTO> selectOrderByUserId();


    /**
     * @description 用户下订单时修改订单状态
     * @author 张成
     * @date 2019/10/10 13:58
     * @param payDTO
     * @return result 如果修改成功，则result.data为1,否则为0
     */
    Result<Integer> updateStatusByPay(PayDTO payDTO);

    /**
     * @Description 取消订单
     * @Author 张成
     * @Date 2019/10/14 1:24
     * @param orderDTO
     * @return result
     */
    Result<Integer> cancelOrder(OrderDTO orderDTO);
}
