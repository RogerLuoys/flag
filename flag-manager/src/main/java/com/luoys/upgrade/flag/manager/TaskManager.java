package com.luoys.upgrade.flag.manager;

import com.luoys.common.annotation.NotNull;
import com.luoys.upgrade.flag.api.bo.TaskBO;

public interface TaskManager {

    String newTask(@NotNull TaskBO taskBO);

    Integer modifyTask(@NotNull TaskBO taskBO);

    TaskBO queryTaskByTaskId(@NotNull String taskId);

    Integer automaticConvertWeekTask();

}
