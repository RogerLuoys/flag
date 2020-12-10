package com.luoys.upgrade.flag.service.impl;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.api.service.TaskService;
import com.luoys.upgrade.flag.manage.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskManager taskManager;

    @Override
    @RequestMapping(value = "/newTask", method = RequestMethod.POST)
    public Result<String> newTask(@RequestBody TaskBO taskBO) {
        return Result.success(taskManager.newTask(taskBO));
    }

    @Override
    @RequestMapping(value = "/modifyTask", method = RequestMethod.PUT)
    public Result<String> modifyTask(@RequestBody TaskBO taskBO) {
        return Result.success(taskManager.newTask(taskBO));
    }
}
