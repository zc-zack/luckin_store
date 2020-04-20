package com.lucky.luckinstore.controller;

import com.lucky.luckinstore.constant.StaticVariable;
import com.lucky.luckinstore.pojo.vo.LabelVO;
import com.lucky.luckinstore.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/19
 * @description: 后台controller层
 */
@Controller
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private GoodsService goodsService;

    /**
     * @return 返回管理员页面首页
     * @description
     * @author 张成
     * @date 2019/9/19 21:41
     */
    @GetMapping("/home")
    public String home() {
        return "admin/home";
    }

    /**
     * @return string
     * @description 返回商品的页面
     * @author 张成
     * @date 2019/9/19 22:59
     */
    @GetMapping ("/goods")
    public String goods(ModelMap modelMap) {
        List<LabelVO> labelVOList = goodsService.selectAllLabelListByDeleted(StaticVariable.UNDELETE);
        modelMap.put("labelList", labelVOList);
        return "admin/goods/goods";
    }

    /**
     * @return String
     * @description 返回会员管理页面
     * @author 张成
     * @date 2019/9/20 9:52
     */
    @GetMapping("/deletedGoods")
    public String deletedGoods() {
        return "admin/goods/deletedGoods";
    }

    /**
     * @return String
     * @description 返回会员页面
     * @author 张成
     * @date 2019/9/20 9:54
     */
    @GetMapping("/member")
    public String member() {
        return "admin/member/member";
    }

    /**
     * @return String
     * @description 返回积分总览页面
     * @author 张成
     * @date 2019/9/21 13:25
     */
    @GetMapping("/score")
    public String score() {
        return "admin/score/score";
    }

    /**
     * @return String
     * @description 返回标签（分类）管理页面
     * @author 张成
     * @date 2019/9/21 13:26
     */
    @GetMapping("/label")
    public String label() {
        return "admin/goods/label";
    }

    /**
     * @return String
     * @description 返回添加标签（分类）页面
     * @author 张成
     * @date 2019/9/21 13:26
     */
    @GetMapping("/addLabel")
    public String addLabel() {
        return "admin/goods/addLabel";
    }

    /**
     * @description 返回订单页面
     * @author 张成
     * @date 2019/9/23 11:31
     * @return string
     */
    @GetMapping("/order")
    public String order(){
        return "admin/order/order";
    }

    /**
     * @description 返回商品下架页面
     * @author 张成
     * @date 2019/9/24 10:42
     * @return String
     */
    @GetMapping("/putGoods")
    public String putGoods(){
        return "admin/goods/putGoods";
    }
    
    /** 
     * @description 返回封禁用户页面
     * @author 张成
     * @date 2019/9/24 11:21
     * @return string
     */
    @GetMapping("/bannedMember")
    public String bannedMember(){
        return "admin/member/bannedMember";
    }

    /**
     * @description 返回完成订单页面
     * @author 张成
     * @date 2019/9/24 19:00
     * @return string
     */
    @GetMapping("/finishedOrder")
    public String finishedOrder(){
        return "admin/order/finishedOrder";
    }

    /**
     * @description 返回未完成订单页面
     * @author 张成
     * @date 2019/9/24 19:01
     * @return string
     */
    @GetMapping("/unfinishedOrder")
    public String unfinishedOrder(){
        return "admin/order/unfinishedOrder";
    }
}
