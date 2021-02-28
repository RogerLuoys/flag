package com.luoys.upgrade.flag.manager;

import com.luoys.upgrade.flag.api.bo.UserBO;


public interface UserManager {
    Boolean modifyUser(UserBO userBO);

    UserBO queryByLoginInfo(String loginName, String passWord);

    UserBO queryByUserId(String userId);

//    Boolean checkUserExist(String loginName);

    Integer newUser(UserBO userBO);
}
