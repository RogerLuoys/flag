package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.FlagBindBO;
import com.luoys.upgrade.flag.api.bo.UserFlagBO;

import java.util.List;

public interface FlagBindManager {
    FlagBindBO addFlagBind(FlagBindBO flagBindBO);

    List<UserFlagBO> queryUserFlag(String userId, Integer userType, Integer flagType, Integer flagStatus);
}
