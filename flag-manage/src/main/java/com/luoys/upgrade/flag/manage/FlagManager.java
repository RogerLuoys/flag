package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.FlagBO;

public interface FlagManager {
//    List<FlagBO> queryFlags(String userId);

//    List<FlagPO> queryAllFlags();

    FlagBO queryFlagByFlagId(String flagId);

    String newFlag(FlagBO flagBO);

    int removeByFlagId(String flagId);

    int modifyStatusByFlagId(String flagId,Integer status);

    int modifyFlagBasic(FlagBO flagBO);
}
