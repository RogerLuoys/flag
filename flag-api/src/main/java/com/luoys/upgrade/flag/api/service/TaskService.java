package com.luoys.upgrade.flag.api.service;

import com.luoys.common.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskBO;

public interface TaskService {
    Result<String> newTask(TaskBO taskBO);

    Result<String> modifyTask(TaskBO taskBO);

    Result<TaskBO> queryTaskByTaskId(String taskId);

}
