package com.lucky.luckinstore.pojo.dto;

import com.lucky.luckinstore.pojo.entity.User;

import java.util.Date;

/**
 * @author: 张成
 * @date: Create in 2019/9/21
 * @description: 用户的DTO
 */
public class UserDTO {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色
     */
    private Integer role;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 等级id
     */
    private Integer memberId;
    /**
     * 积分id
     */
    private Integer scoreId;
    /**
     * 电话号码
     */
    private String tele;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 会员等级相应的名字
     */
    private String memberName;
    /**
     * 用户积分
     */
    private Integer score;
    /**
     * 用户头像
     */
    private String portrait;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
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

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", memberId=" + memberId +
                ", scoreId=" + scoreId +
                ", tele='" + tele + '\'' +
                ", sex=" + sex +
                ", memberName='" + memberName + '\'' +
                ", score=" + score +
                ", portrait='" + portrait + '\'' +
                '}';
    }
}
