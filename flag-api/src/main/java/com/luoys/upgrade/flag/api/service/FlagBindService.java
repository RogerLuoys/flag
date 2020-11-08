package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.UserFlagBO;

import java.util.List;

public interface FlagBindService {

    Result<List<UserFlagBO>> queryUserFlag(String userId, Integer userType, Integer flagType, Integer flagStatus);

}
