package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.dao.po.FlagPO;

import java.util.List;

public interface FlagManager {
    List<FlagBO> queryFlags(String userId);

    List<FlagPO> queryAllFlags();

    FlagBO queryFlagByFlagId(String flagId);

    FlagBO addFlag(FlagBO flagBO);

    int deleteByFlagId(String flagId);

    int modifyFlag(FlagPO flagPO);
}
