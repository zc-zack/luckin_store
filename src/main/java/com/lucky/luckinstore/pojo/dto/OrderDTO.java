package com.lucky.luckinstore.pojo.dto;

import java.util.Date;
import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/23
 * @description:
 */
public class OrderDTO {
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
    private List<GoodsDTO> goodsList;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 订单号
     */
    private String orderNumber;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
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

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<GoodsDTO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsDTO> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", address='" + address + '\'' +
                ", receiveName='" + receiveName + '\'' +
                ", tele='" + tele + '\'' +
                ", orderTime=" + orderTime +
                ", payTime=" + payTime +
                ", creator=" + creator +
                ", modifier=" + modifier +
                ", addressId=" + addressId +
                ", message='" + message + '\'' +
                ", userId=" + userId +
                ", sex=" + sex +
                ", orderTotal=" + orderTotal +
                ", status=" + status +
                ", orderNumber=" + orderNumber +
                ", goodsList=" + goodsList +
                '}';
    }
}
