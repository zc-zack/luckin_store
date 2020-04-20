package com.lucky.luckinstore.controller;

import com.lucky.luckinstore.constant.StaticVariable;
import com.lucky.luckinstore.pojo.ao.UserAO;
import com.lucky.luckinstore.pojo.ao.UserPortraitAO;
import com.lucky.luckinstore.pojo.dto.GoodsDTO;
import com.lucky.luckinstore.pojo.dto.OrderDTO;
import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.dto.UserPortraitDTO;
import com.lucky.luckinstore.pojo.vo.*;
import com.lucky.luckinstore.service.*;
import com.lucky.luckinstore.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/19
 * @description: 主页的控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private CommentService commentService;


    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * @description 返回前台首页
     * @author 张成
     * @date 2019/9/26 1:42
     * @param modelMap
     * @return string
     */
    @GetMapping("/home")
    public String home(ModelMap modelMap,@RequestParam(defaultValue = "") String goodsName, @RequestParam(defaultValue = "") Integer labelId) {
        logger.info("----------------");
        logger.info(goodsName);
        logger.info(String.valueOf(labelId));
        UserVO userVO = userService.getUser();
        modelMap.put("user", userVO);
        List<LabelVO> labelVOList = labelService.selectNameAndId();
        List<GoodsVO> goodsVOList = goodsService.selectGoodsByNameAndStatusList(goodsName, labelId, StaticVariable.GOODS_STATUS_SELL);
        logger.info("goodsList: " + goodsVOList);
        modelMap.put("goodsList", goodsVOList);
        modelMap.put("labelList", labelVOList);
        return "user/home";
    }

    /**
     * @description 返回详情页
     * @author 张成
     * @date 2019/9/26 15:03
     * @param modelMap
     * @return String
     */
    @GetMapping("/detail")
    public String detail(ModelMap modelMap, @RequestParam Integer id){
        UserVO userVO = userService.getUser();
        List<LabelVO> labelVOList = labelService.selectNameAndId();
        modelMap.put("labelList", labelVOList);
        modelMap.put("user", userVO);
        GoodsVO goodsVO = goodsService.selectGoodsById(id);
        modelMap.put("goods", goodsVO);
        List<CommentVO> commentVOList = commentService.selectCommentByGoodsId(id);
        modelMap.put("commentList", commentVOList);
        return "user/detail";
    }

    @RequestMapping("/order")
    public String order(ModelMap modelMap){
        UserVO userVO = userService.getUser();
        modelMap.put("user", userVO);
        //获取用户的所有地址
        List<AddressVO> addressVOList = addressService.selectAddressByUserIdAndDeleted(StaticVariable.UNDELETE);
        //获取订单的商品列表
        List<GoodsVO> goodsVOList = goodsService.getOrderGoodsList();
        modelMap.put("addressList", addressVOList);
        modelMap.put("goodsList", goodsVOList);
        return "user/order";
    }

    /**
     * @description 支付界面
     * @author 张成
     * @date 2019/10/8 8:55
     * @param modelMap
     * @param orderId
     * @return string
     */
    @GetMapping("/pay")
    public String pay(ModelMap modelMap, @RequestParam Integer orderId){
        UserVO userVO = userService.getUser();
        modelMap.put("user", userVO);
        OrderDTO orderDTO = orderService.selectOrderById(orderId);
        modelMap.addAttribute("order", orderDTO);
        List<GoodsDTO> goodsList = orderDTO.getGoodsList();
        modelMap.addAttribute("goodsList",goodsList);
        logger.info(goodsList.toString());
        return "user/pay";
    }

    @GetMapping("/information")
    public String information(ModelMap modelMap){
        UserVO userVO = userService.selectUserById();
        //获取用户的所有地址
        List<AddressVO> addressVOList = addressService.selectAddressByUserIdAndDeleted(StaticVariable.UNDELETE);
        logger.info(userVO.toString());
        modelMap.put("user", userVO);
        modelMap.put("addressList", addressVOList);
        return "user/information";
    }

    /**
     * @description 更新用户信息
     * @author 张成
     * @date 2019/9/30 1:45
     * @param
     * @return
     */
    @PostMapping("/updateUser")
    @ResponseBody
    public int updateUser(@RequestBody UserAO userAO){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userAO, userDTO);
        return userService.updateUserById(userDTO);
    }

    /**
     * @Description 更新用户头像的接口
     * @Author 张成
     * @Date 2019/10/13 14:51
     * @param userPortraitAO
     * @return result 如果更新成功则result.data为1
     */
    @PostMapping("/updatePortrait")
    @ResponseBody
    public Result<Integer> updatePortrait(@RequestBody UserPortraitAO userPortraitAO){
        logger.info(userPortraitAO.toString());
        UserPortraitDTO userPortraitDTO = new UserPortraitDTO();
        BeanUtils.copyProperties(userPortraitAO, userPortraitDTO);
        return userService.updatePortraitById(userPortraitDTO);
    }

    @GetMapping("/shoppingCart")
    public String shoppingCart(ModelMap modelMap){
        UserVO userVO = userService.getUser();
        modelMap.put("user", userVO);
        List<ShoppingCartVO> shoppingCartVOList = shoppingCartService.selectCartByUserId();
        logger.info(shoppingCartVOList.toString());
        modelMap.put("cartList", shoppingCartVOList);
        return "user/shoppingCart";
    }

    @GetMapping("/myOrder")
    public String getOrder(ModelMap modelMap){
        List<OrderDTO> orderDTOList = orderService.selectOrderByUserId();
        modelMap.put("orderList", orderDTOList);
        UserVO userVO = userService.getUser();
        modelMap.put("user", userVO);
        return "user/myOrder";
    }
}
