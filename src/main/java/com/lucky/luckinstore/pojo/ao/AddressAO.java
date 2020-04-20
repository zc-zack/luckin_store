package com.lucky.luckinstore.pojo.ao;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author: 张成
 * @date: Create in 2019/9/27
 * @description:
 */
public class AddressAO {
    /**
     * 购物车id
     */
    @NotEmpty
    private Integer id;
    /**
     * 电话号码
     */
    @NotEmpty
    private String tele;
    /**
     * 地址
     */
    @NotEmpty
    private String address;
    /**
     *
     */
    @NotEmpty
    private Integer sex;
    /**
     * 收件人
     */
    @NotEmpty
    private String receiveName;

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

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }
}
