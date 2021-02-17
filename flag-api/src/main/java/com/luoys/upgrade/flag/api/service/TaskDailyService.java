package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import org.springframework.web.bind.annotation.RequestParam;

public interface TaskDailyService {
    Result<String> newTaskDaily(TaskDailyBO taskDailyBO);

    Result<Integer> modifyTaskDailyStatus(String taskDailyId, Integer status, String pointId);

    Result<String> modifyTaskDailyComment(String taskDailyId, String comment);

}
