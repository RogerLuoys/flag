package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.api.bo.TaskDailyDetailBO;

public interface TaskDailyManager {

    String newTaskDaily(TaskDailyDetailBO taskDailyDetailBO);
}
