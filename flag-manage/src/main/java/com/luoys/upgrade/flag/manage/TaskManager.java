package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.TaskBO;

public interface TaskManager {

    String newTask(TaskBO taskBO);

    int modifyTask(TaskBO taskBO);

}
