package com.lucky.luckinstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucky.luckinstore.constant.StaticVariable;
import com.lucky.luckinstore.mapper.AddressMapper;
import com.lucky.luckinstore.mapper.GoodsMapper;
import com.lucky.luckinstore.mapper.OrderGoodsMapper;
import com.lucky.luckinstore.mapper.OrderMapper;
import com.lucky.luckinstore.pojo.ao.OrderAO;
import com.lucky.luckinstore.pojo.dto.*;
import com.lucky.luckinstore.pojo.entity.User;
import com.lucky.luckinstore.pojo.vo.OrderVO;
import com.lucky.luckinstore.service.*;
import com.lucky.luckinstore.util.LayuiUtil;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: 张成
 * @date: Create in 2019/9/23
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private HttpSession session;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private BehaviorService behaviorService;

    private final static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    private LayuiUtil layuiUtil;

    /**
     * @return list
     * @description 获取所有订单，返回list格式
     * @author 张成
     * @date 2019/9/23 12:23
     */
    @Override
    public List<OrderAO> selectAllOrderList() {
        return orderMapper.selectAllOrder();
    }


    /**
     * @param orderDTO
     * @return int
     * @description 修改订单信息
     * @author 张成
     * @date 2019/9/23 16:39
     */
    @Override
    public Result<Integer> updateOrderByOrderId(OrderDTO orderDTO) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        orderDTO.setModifier(userDTO.getId());
        Result<Integer> result = new Result<>();
        result.setData(orderMapper.updateOrderByOrderId(orderDTO));
        return result;
    }

    /**
     * @description 获取订单的Service层
     * @author 张成
     * @date 2019/9/24 22:51
     * @param searchOrderDTO
     * @return list
     */
    @Override
    public List<OrderVO> selectOrderByStatusList(SearchOrderDTO searchOrderDTO) {
        List<OrderDTO> orderDTOList = orderMapper.selectOrderByStatusAndTele(searchOrderDTO);
        JSONArray orderJSON = JSONArray.parseArray(JSON.toJSONString(orderDTOList));
        List<OrderVO> orderVOList = JSONObject.parseArray(orderJSON.toJSONString(), OrderVO.class);
        return orderVOList;
    }

    /**
     * @param status
     * @param tele
     * @return SearchOrderDTO
     * @description 封装实体类
     * @author 张成
     * @date 2019/9/25 0:40
     * @Param tele
     */
    @Override
    public SearchOrderDTO getSearchOrderDTO(String tele, Integer status) {
        SearchOrderDTO searchOrderDTO = new SearchOrderDTO();
        searchOrderDTO.setStatus(status);
        searchOrderDTO.setTele(tele);
        return searchOrderDTO;
    }

    /**
     * @param tele
     * @return list
     * @description 通过手机号查询订单返回list
     * @author 张成
     * @date 2019/9/25 1:03
     */
    @Override
    public Result<List> selectOrderByTeleList(String tele, Integer status, Integer page, Integer limit) {
        SearchOrderDTO searchOrderDTO = getSearchOrderDTO(tele, status);
        logger.info("searchOrder:" + searchOrderDTO.toString());
        PageHelper.startPage(page, limit);
        List<OrderAdminDTO> orderAdminDTOList = orderMapper.selectOrderByTele(searchOrderDTO);
        PageInfo<OrderAdminDTO> pageInfo = new PageInfo<OrderAdminDTO>(orderAdminDTOList);
        logger.info(orderAdminDTOList.toString());
        Result<List> result = new Result<>();
        result.setData(orderAdminDTOList);
        result.setCount(orderAdminDTOList.size());
        return result;
    }

    /**
     * @param orderDTO
     * @return
     * @description 创建新的订单
     * @author 张成
     * @date 2019/9/27 1:13
     */
    @Override
    public Result<Integer> insertOrder(OrderDTO orderDTO) {
        Result<Integer> result = new Result<>();
        String orderNumber;
        double total = 0;
        //商品列表
        List<GoodsDTO> goodsDTOList = (List<GoodsDTO>) session.getAttribute("goodsList");
        //购物车id列表
        List<Integer> cartIdList = (List<Integer>) session.getAttribute("cartIdList");
        BehaviorDTO behaviorDTO = new BehaviorDTO();
        behaviorDTO.setBehavior(StaticVariable.PAYMENT);
        logger.info(goodsDTOList.toString());
        //计算价格
        for(GoodsDTO goodsDTO: goodsDTOList){
            double temp = goodsDTO.getTotal();
            total += temp;
            //剩余数量
            goodsDTO.setAmount(goodsDTO.getAmount() - goodsDTO.getNum());
            //下单时的订单操作
            behaviorDTO.setLabelId(goodsMapper.selectLabelIdById(goodsDTO.getId()));
            behaviorService.updateBehaviorById(behaviorDTO);
            //下单商品热度增加
            goodsDTO.setHot(StaticVariable.PAYMENT);
            goodsMapper.updateHotById(goodsDTO);
            logger.info("in pay");
        }
        UserDTO user = (UserDTO) session.getAttribute("user");
        AddressDTO addressDTO = addressMapper.selectAddressById(orderDTO.getAddressId());
        //通过UUID和时间生成订单号
        String number = UUID.randomUUID().toString().replace("-", "").substring(StaticVariable.START, StaticVariable.END);
        String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());
        orderNumber = number + sdf;
        orderDTO.setOrderNumber(orderNumber);
        //拼接订单信息
        orderDTO.setUserId(user.getId());
        orderDTO.setReceiveName(addressDTO.getReceiveName());
        orderDTO.setTele(addressDTO.getTele());
        orderDTO.setAddress(addressDTO.getAddress());
        orderDTO.setSex(addressDTO.getSex());
        orderDTO.setOrderTotal(total);
        logger.info(orderDTO.toString());
        orderMapper.insertOrder(orderDTO);
        logger.info("orderId:" + orderDTO.getId());
        //插入带订单商品列表中
        logger.info(goodsDTOList.toString());
        Integer data = orderGoodsMapper.insertOrderGoods(goodsDTOList, orderDTO.getId(), user.getId());
        logger.info("--------------");
        goodsService.updateGoodsAmount(goodsDTOList);
        logger.info("--------------");

        //从购物车中移除商品
        for(Integer cartId: cartIdList){
            shoppingCartService.updateDeletedById(cartId);
        }
        result.setCode(data);
        result.setData(orderDTO.getId());
        return result;
    }

    /**
     * @param orderId
     * @return orderVO
     * @description 返回要付款的订单信息
     * @author 张成
     * @date 2019/9/29 9:27
     */
    @Override
    public OrderDTO selectOrderById(Integer orderId) {
        OrderDTO orderDTO = orderMapper.selectOrderById(orderId);
        logger.info(orderDTO.toString());
//        OrderVO orderVO = new OrderVO();
//        BeanUtils.copyProperties(orderDTO, orderVO);
        return orderDTO;
    }

    /**
     * @param status
     * @param orderId
     * @return int
     * @description 根据订单id修改订单状态
     * @author 张成
     * @date 2019/9/29 10:49
     */
    @Override
    public int updateOrderStatusById(Integer status, Integer orderId) {
        ScoreDTO scoreDTO = new ScoreDTO();
        double orderTotal = orderMapper.selectPriceById(orderId);
        //如果状态为1说明付款了
        if( status == 1 ){
            scoreDTO.setPresentScore((int)orderTotal);
            scoreService.updatePayScoreByUserId(scoreDTO);
        }
        return orderMapper.updateOrderStatusById(status, orderId);
    }

    /**
     * @return list
     * @description 返回所有订单
     * @author 张成
     * @date 2019/9/29 17:32
     */
    @Override
    public List<OrderDTO> selectOrderByUserId() {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        List<OrderDTO> orderDTOList = orderMapper.selectOrderByUserId(userDTO.getId());
        return orderDTOList;
    }


    /**
     * @param payDTO
     * @return result 如果修改成功，则result.data为1,否则为0
     * @description 用户下订单时修改订单状态
     * @author 张成
     * @date 2019/10/10 13:58
     */
    @Override
    public Result<Integer> updateStatusByPay(PayDTO payDTO) {
        UserDTO user = (UserDTO) session.getAttribute("user");
        ScoreDTO scoreDTO = new ScoreDTO();
        payDTO.setUserId(user.getId());
        Result<Integer> result = new Result<>();
        result.setData(orderMapper.updateStatusByPay(payDTO));
        //添加积分，下单完成后
        scoreDTO.setUserId(user.getId());
        double score = orderMapper.selectPriceById(payDTO.getOrderId());
        scoreDTO.setPresentScore((int)score);
        scoreService.updatePayScoreByUserId(scoreDTO);
        return result;
    }

    /**
     * @param orderId
     * @return result
     * @Description 取消订单
     * @Author 张成
     * @Date 2019/10/14 1:24
     */
    @Override
    public Result<Integer> cancelOrder(OrderDTO orderDTO) {
        Result<Integer> result = new Result<>();
        orderMapper.updateOrderStatusById(orderDTO.getStatus(), orderDTO.getId());
        OrderDTO temp = orderMapper.selectOrderById(orderDTO.getId());
        result.setData(goodsMapper.updateAmountByCancelOrder(temp.getGoodsList()));
        return result;
    }

}
