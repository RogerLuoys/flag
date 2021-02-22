package com.luoys.upgrade.flag.api.service;

import com.luoys.common.api.Result;
import com.luoys.upgrade.flag.api.bo.UserBO;

public interface UserService {
    Result<UserBO> login(String loginName, String password);

    Result<UserBO> queryByUserId(String userId);

    Result<Integer> register(UserBO userBO);

    Result<Integer> modifyUser(UserBO userBO);
}
