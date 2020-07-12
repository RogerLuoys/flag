package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.dao.po.FlagPO;

import java.util.List;

public interface FlagManager {
    List<FlagPO> page();

    int insert(FlagPO flagPO);

    int update(FlagPO flagPO);
}
