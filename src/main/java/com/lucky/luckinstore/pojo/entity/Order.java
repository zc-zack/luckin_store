package com.lucky.luckinstore.pojo.entity;

import java.util.Date;

public class Order {
    //订单id
    private Integer id;
    //用户id
    private Integer userId;
    //地址id
    private Integer addressId;
    //下单时间
    private Date orderTime;
    //付款时间
    private Date payTime;
    //订单状态
    private Integer status;
    //创建者
    private Integer creator;
    //创建时间
    private Date createTime;
    //修改者
    private Integer modifier;
    //修改时间
    private Date modifyTime;
    //地址
    private String address;
    //电话
    private String tele;
    //性别
    private Integer sex;
    //收货人
    private String receiveName;
    //留言
    private String message;
    //订单总价
    private Double total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", addressId=" + addressId +
                ", orderTime=" + orderTime +
                ", payTime=" + payTime +
                ", status=" + status +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", modifier=" + modifier +
                ", modifyTime=" + modifyTime +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                ", sex=" + sex +
                ", receiveName='" + receiveName + '\'' +
                ", message='" + message + '\'' +
                ", total=" + total +
                '}';
    }
}
