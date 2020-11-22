package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskBO;

public interface TaskService {
    Result<String> newTask(TaskBO taskBO);

    Result<String> modifyTask(TaskBO taskBO);

}
