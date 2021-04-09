package com.luoys.upgrade.flag.manager;

import com.luoys.common.annotation.NotNull;
import com.luoys.common.annotation.Nullable;
import com.luoys.upgrade.flag.api.bo.*;

import java.util.List;

public interface FlagBindManager {
    FlagBindBO addFlagBind(@NotNull FlagBindBO flagBindBO);

    List<UserFlagBO> queryUserFlag(@NotNull FlagQueryBO flagQueryBO);

    Integer countUserFlag(@NotNull FlagQueryBO flagQueryBO);

    List<TaskDailyBO> queryUserTaskDaily(@NotNull TaskDailyQueryBO taskDailyQueryBO);

    List<UserReportBO> queryUserReport(@NotNull String ownerId, @Nullable Integer status);

    Integer modifyWitness(@NotNull FlagBindBO flagBindBO);
}
