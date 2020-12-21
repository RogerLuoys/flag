package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.api.bo.TaskDailyDetailBO;

public interface TaskDailyService {
    Result<String> newTaskDaily(TaskDailyDetailBO taskDailyDetailBO);
}
