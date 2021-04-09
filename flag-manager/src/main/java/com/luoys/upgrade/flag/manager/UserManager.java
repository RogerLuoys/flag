package com.luoys.upgrade.flag.manager;

import com.luoys.common.annotation.NotNull;
import com.luoys.upgrade.flag.api.bo.UserBO;


public interface UserManager {
    Boolean modifyUser(@NotNull UserBO userBO);

    UserBO queryByLoginInfo(@NotNull String loginName, @NotNull String passWord);

    UserBO queryByUserId(@NotNull String userId);

//    Boolean checkUserExist(String loginName);

    Integer newUser(@NotNull UserBO userBO);
}
