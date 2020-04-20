package com.lucky.luckinstore.pojo.dto;

import com.lucky.luckinstore.pojo.entity.Address;

/**
 * @author: 张成
 * @date: Create in 2019/9/27
 * @description:
 */
public class AddressDTO {
    /**
     * 地址id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 电话号码
     */
    private String tele;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 是否被删除0未被删除 1被删除
     */
    private Boolean deleted;
    /**
     * 性别1 为男生 0为女生
     */
    private Integer sex;
    /**
     * 收货人
     */
    private String receiveName;

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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", tele='" + tele + '\'' +
                ", address='" + address + '\'' +
                ", deleted=" + deleted +
                ", sex=" + sex +
                ", receiveName='" + receiveName + '\'' +
                '}';
    }
}
