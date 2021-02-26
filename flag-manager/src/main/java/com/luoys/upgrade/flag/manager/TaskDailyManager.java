package com.luoys.upgrade.flag.manager;

import com.luoys.upgrade.flag.api.bo.TaskDailyBO;

public interface TaskDailyManager {

    String newTaskDaily(TaskDailyBO taskDailyBO);

    Integer modifyTaskDailyStatus(String taskDailyId, Integer status, String pointId);

    Integer modifyTaskDailyComment(String taskDailyId, String comment);
}
