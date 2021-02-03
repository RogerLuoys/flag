package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.TaskBO;

public interface TaskManager {

    String newTask(TaskBO taskBO);

    Integer modifyTask(TaskBO taskBO);

    TaskBO queryTaskByTaskId(String taskId);

    Integer automaticConvertWeekTask();

}
