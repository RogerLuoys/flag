package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.UserBO;


public interface UserManager {
    Integer modifyUser(UserBO userBO);

    UserBO queryByLoginInfo(String loginName, String passWord);

    Boolean checkUserExist(String loginName);

    Integer newUser(UserBO userBO);
}
