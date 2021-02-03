package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

@Data
public class UserBO {

    private String userId;

    /**
     * 登录名
     */
    private String loginName;

    private String password;

    /**
     * 用户号码，登录账号
     */
    private String phone;

    private String userName;

    /**
     * 1--管理员；2--普通账号
     */
    private Byte type;

    /**
     * 1-正常；
     */
    private Byte status;

}
