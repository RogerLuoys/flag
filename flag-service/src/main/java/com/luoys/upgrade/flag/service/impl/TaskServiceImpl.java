package com.luoys.upgrade.flag.service.impl;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.api.service.TaskService;
import com.luoys.upgrade.flag.manage.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Override
    @RequestMapping(value = "/queryTaskByTaskId", method = RequestMethod.GET)
    public Result<TaskBO> queryTaskByTaskId(@RequestParam("taskId") String taskId) {
        return Result.success(taskManager.queryTaskByTaskId(taskId));
    }

}
