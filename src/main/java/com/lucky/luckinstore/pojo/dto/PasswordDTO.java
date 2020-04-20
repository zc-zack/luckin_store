package com.lucky.luckinstore.pojo.dto;

/**
 * @author: 张成
 * @date: Create in 2019/9/23
 * @description:
 */
public class PasswordDTO {
    private String password;

    private Integer userId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
