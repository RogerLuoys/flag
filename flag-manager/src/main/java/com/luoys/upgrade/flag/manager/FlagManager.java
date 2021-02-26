package com.luoys.upgrade.flag.manager;

import com.luoys.upgrade.flag.api.bo.FlagBO;

public interface FlagManager {
//    List<FlagBO> queryFlags(String userId);

//    List<FlagPO> queryAllFlags();

    FlagBO queryFlagByFlagId(String flagId);

    String newFlag(FlagBO flagBO);

    Integer removeByFlagId(String flagId);

    Integer modifyStatusByFlagId(String flagId,Integer status);

    Integer modifyFlagBasic(FlagBO flagBO);
}
