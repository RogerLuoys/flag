package com.luoys.upgrade.flag.manager;

import com.luoys.common.annotation.NotNull;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;

public interface TaskDailyManager {

    String newTaskDaily(@NotNull TaskDailyBO taskDailyBO);

    Integer modifyTaskDailyStatus(@NotNull String taskDailyId, @NotNull Integer status, @NotNull String pointId);

    Integer modifyTaskDailyComment(@NotNull String taskDailyId, @NotNull String comment);
}
