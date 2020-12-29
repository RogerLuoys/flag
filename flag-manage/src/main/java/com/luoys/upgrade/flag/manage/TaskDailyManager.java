package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.TaskDailyBO;

public interface TaskDailyManager {

    String newTaskDaily(TaskDailyBO taskDailyBO);

    int modifyTaskDailyStatus(String taskDailyId, Integer status);
}
