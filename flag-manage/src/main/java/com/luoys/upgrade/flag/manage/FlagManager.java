package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.dao.po.FlagPO;

import java.util.List;

public interface FlagManager {
//    List<FlagBO> queryFlags(String userId);

//    List<FlagPO> queryAllFlags();

    FlagBO queryFlagByFlagId(String flagId);

    FlagBO newFlag(FlagBO flagBO);

    int removeByFlagId(String flagId);

    int modifyStatusByFlagId(String flagId,Integer status);

    int modifyFlag(FlagPO flagPO);
}
