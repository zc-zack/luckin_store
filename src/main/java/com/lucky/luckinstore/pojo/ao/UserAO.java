package com.lucky.luckinstore.pojo.ao;

import com.lucky.luckinstore.pojo.dto.UserDTO;
import com.lucky.luckinstore.pojo.entity.User;

/**
 * @author: 张成
 * @date: Create in 2019/9/21
 * @description:
 */
public class UserAO extends User {
    private String roleName;

    private String memberName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
