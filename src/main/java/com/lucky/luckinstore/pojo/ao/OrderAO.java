package com.lucky.luckinstore.pojo.ao;

import java.util.List;

/**
 * @author: 张成
 * @date: Create in 2019/9/23
 * @description: 订单的AO
 */
public class OrderAO {
    /**
     * 订单id
     */
    private Integer id;
    /**
     * 地址id
     */
    private Integer addressId;
    /**
     * 备注
     */
    private String message;
    /**
     * 商品 list
     */
    private List<GoodsAO> goodsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<GoodsAO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsAO> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "OrderAO{" +
                "id=" + id +
                ", addressId=" + addressId +
                ", message='" + message + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
