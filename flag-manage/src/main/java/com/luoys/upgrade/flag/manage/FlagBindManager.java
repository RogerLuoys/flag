package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.*;

import java.util.List;

public interface FlagBindManager {
    FlagBindBO addFlagBind(FlagBindBO flagBindBO);

    List<UserFlagBO> queryUserFlag(FlagQueryBO flagQueryBO);

    int countUserFlag(FlagQueryBO flagQueryBO);

    List<TaskDailyBO> queryUserTaskDaily(TaskDailyQueryBO taskDailyQueryBO);

    List<UserReportBO> queryUserReport(String ownerId);

    int modifyWitness(FlagBindBO flagBindBO);
}
