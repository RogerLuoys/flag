package com.luoys.upgrade.flag.manager;

import com.luoys.common.annotation.NotNull;
import com.luoys.upgrade.flag.api.bo.FlagBO;

public interface FlagManager {
//    List<FlagBO> queryFlags(String userId);

//    List<FlagPO> queryAllFlags();

    FlagBO queryFlagByFlagId(@NotNull String flagId);

    String newFlag(@NotNull FlagBO flagBO);

    Integer removeByFlagId(@NotNull String flagId);

    Integer modifyStatusByFlagId(@NotNull String flagId, @NotNull Integer status);

    Integer modifyFlagBasic(@NotNull FlagBO flagBO);
}
