package com.lucky.luckinstore.pojo.vo;

import java.util.Date;
import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/29
 * @description:
 */
public class OrderVO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 订单id
     */
    private Integer id;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 收件人
     */
    private String receiveName;
    /**
     * 电话
     */
    private String tele;
    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 付款时间
     */
    private Date payTime;
    /**
     * 订单的创建者
     */
    private Integer creator;
    /**
     * 订单的修改者
     */
    private Integer modifier;
    /**
     * 地址id
     */
    private Integer addressId;
    /**
     * 用户留言
     */
    private String message;
    /**
     * 下单用户的id
     */
    private Integer userId;
    /**
     * 收件人姓名
     */
    private Integer sex;
    /**
     * 订单总价
     */
    private Double orderTotal;
    /**
     * 商品列表
     */
    private List<GoodsVO> goodsList;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 订单号
     */
    private String orderNumber;
    //商品列表
    private List<GoodsVO> goodsVOList;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public List<GoodsVO> getGoodsVOList() {
        return goodsVOList;
    }

    public void setGoodsVOList(List<GoodsVO> goodsVOList) {
        this.goodsVOList = goodsVOList;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", orderTime=" + orderTime +
                ", payTime=" + payTime +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                ", username='" + username + '\'' +
                ", receiveName='" + receiveName + '\'' +
                ", sex=" + sex +
                ", orderNumber=" + orderNumber +
                ", goodsVOList=" + goodsVOList +
                '}';
    }
}
