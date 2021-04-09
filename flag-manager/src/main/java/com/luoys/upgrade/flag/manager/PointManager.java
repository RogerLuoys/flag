package com.luoys.upgrade.flag.manager;

import com.luoys.common.annotation.NotNull;
import com.luoys.common.annotation.Nullable;
import com.luoys.upgrade.flag.api.bo.PointBO;
import com.luoys.upgrade.flag.api.bo.PointLogBO;

import java.util.List;

public interface PointManager {

    PointBO queryPointByOwnerId(@NotNull String ownerId);

    List<PointLogBO> queryPointLog(@NotNull String pointId, @Nullable Integer type);

    String newPointLog(@NotNull PointLogBO pointLogBO);
}
