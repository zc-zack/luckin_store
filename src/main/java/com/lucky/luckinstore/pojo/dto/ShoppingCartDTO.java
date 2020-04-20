package com.lucky.luckinstore.pojo.dto;

import com.lucky.luckinstore.pojo.entity.ShoppingCart;

import javax.validation.constraints.NotEmpty;

/**
 * @author: 张成
 * @date: Create in 2019/9/26
 * @description:
 */
public class ShoppingCartDTO extends ShoppingCart {

    //商品名称
    @NotEmpty
    private String goodsName;

    //商品图片
    private String image;

    //商品价格
    private Double price;


    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }




    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
                ", goodsName='" + goodsName + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
}
