package com.luoys.upgrade.flag.manager;

import com.luoys.common.annotation.NotNull;
import com.luoys.upgrade.flag.api.bo.*;

import java.util.List;

public interface FlagBindManager {
    FlagBindBO addFlagBind(FlagBindBO flagBindBO);

    List<UserFlagBO> queryUserFlag(@NotNull FlagQueryBO flagQueryBO);

    Integer countUserFlag(FlagQueryBO flagQueryBO);

    List<TaskDailyBO> queryUserTaskDaily(TaskDailyQueryBO taskDailyQueryBO);

    List<UserReportBO> queryUserReport(String ownerId, Integer status);

    Integer modifyWitness(FlagBindBO flagBindBO);
}
