package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import org.springframework.web.bind.annotation.RequestParam;

public interface TaskDailyService {
    Result<String> newTaskDaily(TaskDailyBO taskDailyBO);

    Result<String> modifyTaskDailyStatus(@RequestParam("taskDailyId") String taskDailyId, @RequestParam("status") Integer status);

    Result<String> modifyTaskDailyComment(@RequestParam("taskDailyId") String taskDailyId, @RequestParam("comment") String comment);

}
