package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.UserBO;


public interface UserManager {
    Integer modifyUser(UserBO userBO);

    UserBO checkUser(String loginName, String passWord);

    Integer newUser(UserBO userBO);
}
