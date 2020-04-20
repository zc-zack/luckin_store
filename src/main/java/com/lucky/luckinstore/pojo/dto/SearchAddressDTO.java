package com.lucky.luckinstore.pojo.dto;

/**
 * @author: 张成
 * @date: Create in 2019/9/27
 * @description: 查询所有地址
 */
public class SearchAddressDTO {
    private Boolean deleted;

    private Integer userId;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
