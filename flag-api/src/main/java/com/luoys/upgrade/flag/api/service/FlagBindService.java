package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.*;

import java.util.List;

public interface FlagBindService {

//    Result<List<UserFlagBO>> queryUserFlag(String userId, Integer userType, Integer flagType, Integer flagStatus);

    Result<List<UserFlagBO>> queryFlagList(FlagQueryBO flagQueryBO);

    Result<List<UserReportBO>> queryReportList(String ownerId);

    Result<String> modifyWitness(FlagBindBO flagBindBO);

    Result<List<TaskDailyBO>> queryTaskDailyList(TaskDailyQueryBO taskDailyQueryBO);

}
