package com.lucky.luckinstore.pojo.ao;

/**
 * @author: 张成
 * @date: Create in 2019/10/9
 * @description: 购物车商品的DTO
 */
public class CartGoodsAO {
    /**
     * 购物车id
     */
    private Integer id;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品数量
     */
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CartGoodsDTO{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", num=" + num +
                '}';
    }
}
