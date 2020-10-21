package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.dao.po.FlagPO;

import java.util.List;

public interface FlagManager {
    List<FlagBO> page(String userId);

    List<FlagPO> pageAll();

    FlagPO insert(FlagBO flagBO);

    int update(FlagPO flagPO);
}
