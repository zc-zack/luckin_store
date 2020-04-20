package com.lucky.luckinstore.pojo.vo;

/**
 * @author: 张成
 * @date: Create in 2019/9/29
 * @description:
 */
public class UserVO {
    /**
     * 用户角色
     */
    private Integer role;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户性别
     */
    private Integer sex;
    /**
     * 用户手机
     */
    private String tele;
    /**
     * 用户积分
     */
    private Integer score;
    /**
     * 用户等级
     */
    private String memberName;

    /**
     * 用户头像
     */
    private String portrait;

    /**
     * 状态
     */
    private Integer status;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "role=" + role +
                ", roleName='" + roleName + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", tele='" + tele + '\'' +
                ", score=" + score +
                ", memberName='" + memberName + '\'' +
                ", portrait='" + portrait + '\'' +
                ", status=" + status +
                '}';
    }
}
