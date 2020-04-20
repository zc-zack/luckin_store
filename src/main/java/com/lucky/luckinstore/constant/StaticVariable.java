package com.lucky.luckinstore.constant;

/**
 * @author: 张成
 * @date: Create in 2019/10/11
 * @description:
 */
public class StaticVariable {
    /**
     * 点击商品时的权重
     */
    public final static Integer CLICK = 1;

    /**
     * 收藏商品时的权重
     */
    public final static Integer COLLECTION = 2;

    /**
     * 加入购物车时的权重
     */
    public final static Integer ADD_CART = 3;

    /**
     * 付款时的权重
     */
    public final static Integer PAYMENT = 4;

    /**
     * 商品状态
     */
    public final static Integer GOODS_STATUS_SELL = 1;

    /**
     * 分割UUID的开始下标
     */
    public final static int START = 0;

    /**
     * 分割UUID的开始下标
     */
    public final static int END = 4;

    /**
     * 状态为空
     */
    public final static Integer STATUS_NULL = null;

    /**
     * 商品已评价
     */
    public final static Integer STATUS_COMMENTED = 2;

    /**
     *  成功时的数值
     */
    public final static Integer OK = 1;

    /**
     * 失败时的数值
     */
    public final static Integer ERROR = 0;

    /**
     * 未删除
     */
    public final static Boolean UNDELETE = false;
    /**
     * 已删除
     */
    public final static Boolean DELETED = true;
}
