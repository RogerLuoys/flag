package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.UserBO;
import com.luoys.upgrade.flag.dao.po.UserPO;


public interface UserManager {
    int modifyUser(UserBO userBO);

    int checkUser(String loginName, String passWord);

    int newUser(UserBO userBO);
}
