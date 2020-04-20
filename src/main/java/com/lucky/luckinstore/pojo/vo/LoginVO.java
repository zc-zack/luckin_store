package com.lucky.luckinstore.pojo.vo;

/**
 * @author: 张成
 * @date: Create in 2019/9/19
 * @description: 接收视图层传过来的数据
 */
public class LoginVO {

    //账号
    private String username;

    //密码
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
