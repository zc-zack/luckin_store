package com.lucky.luckinstore.pojo.dto;

import java.util.Date;

/**
 * @author: 张成
 * @date: Create in 2019/10/10
 * @description: 后台获取订单的DTO
 */
public class OrderAdminDTO {
    //订单号
    private Integer id;
    //收货人手机号
    private String tele;
    //收货人地址
    private String address;
    //性别
    private Integer sex;
    //卖家留言
    private String message;
    //收货人
    private String receiveName;
    //下单时间
    private Date orderTime;
    //付款时间
    private Date payTime;
    //订单id
    private Integer goodsId;
    //商品单价
    private Double price;
    //商品名
    private String goodsName;
    //购买数量
    private Integer num;
    //商品总价
    private Double total;
    //订单总价
    private Double orderTotal;
    //状态
    private Integer status;
    //订单号
    private String orderNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
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

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        return "OrderAdminDTO{" +
                "id=" + id +
                ", tele='" + tele + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", message='" + message + '\'' +
                ", receiveName='" + receiveName + '\'' +
                ", orderTime=" + orderTime +
                ", payTime=" + payTime +
                ", goodsId=" + goodsId +
                ", price=" + price +
                ", goodsName='" + goodsName + '\'' +
                ", num=" + num +
                ", total=" + total +
                ", orderTotal=" + orderTotal +
                ", status=" + status +
                '}';
    }
}
