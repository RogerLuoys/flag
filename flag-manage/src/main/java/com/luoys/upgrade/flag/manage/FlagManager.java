package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.dao.po.FlagPO;

import java.util.List;

public interface FlagManager {
    List<FlagBO> queryFlags(String userId);

    List<FlagPO> queryAllFlags();

    int addFlag(FlagBO flagBO);

    int modifyFlag(FlagPO flagPO);
}
