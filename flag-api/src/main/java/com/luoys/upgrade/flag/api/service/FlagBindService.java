package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.FlagBindBO;
import com.luoys.upgrade.flag.api.bo.FlagQueryBO;
import com.luoys.upgrade.flag.api.bo.UserFlagBO;

import java.util.List;

public interface FlagBindService {

//    Result<List<UserFlagBO>> queryUserFlag(String userId, Integer userType, Integer flagType, Integer flagStatus);

    Result<List<UserFlagBO>> queryUserFlags(FlagQueryBO flagQueryBO);

    Result<String> modifyWitness(FlagBindBO flagBindBO);

}
