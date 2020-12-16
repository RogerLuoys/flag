package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;

public interface TaskDailyService {
    Result<String> newTaskDaily(TaskDailyBO taskDailyBO);
}
