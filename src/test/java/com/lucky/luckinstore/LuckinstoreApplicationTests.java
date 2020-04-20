package com.lucky.luckinstore;

import com.github.pagehelper.PageHelper;
import com.lucky.luckinstore.mapper.*;
import com.lucky.luckinstore.pojo.dto.*;
import com.lucky.luckinstore.pojo.entity.Goods;
import com.lucky.luckinstore.service.LoginService;
import com.lucky.luckinstore.service.OrderService;
import com.lucky.luckinstore.service.QiniuService;
import com.lucky.luckinstore.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckinstoreApplicationTests {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private QiniuService qiniuService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private BehaviorMapper behaviorMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Test
    public void contextLoads() {
//        loginService.checkLogin("admin");
//       s
//        System.out.println(goodsMapper.selectGoodsByNameAndStatus("", 1));

        SearchGoodsDTO searchGoodsDTO = new SearchGoodsDTO();
        searchGoodsDTO.setStatus(1);
        searchGoodsDTO.setGoodsName("");
        Integer pageNum = 1;
        Integer pageSize = 5;

        System.out.println(userMapper.selectUserById(6));
    }

}
