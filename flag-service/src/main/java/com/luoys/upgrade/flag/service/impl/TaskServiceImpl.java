package com.luoys.upgrade.flag.service.impl;

import com.alibaba.fastjson.JSON;
import com.luoys.common.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.api.service.TaskService;
import com.luoys.upgrade.flag.manager.TaskManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/task")
public class TaskServiceImpl implements TaskService {

    private static final Logger LOG = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskManager taskManager;

    @Override
    @RequestMapping(value = "/newTask", method = RequestMethod.POST)
    public Result<String> newTask(@RequestBody TaskBO taskBO) {
        LOG.info("=====》创建周期任务开始：{}", JSON.toJSONString(taskBO));
        if (taskBO.getTaskName() == null) {
            return Result.error("taskName不能为空");
        } else if (taskBO.getCycleList() == null && taskBO.getCycle() == null) {
            return Result.error("cycleList和cycle不能同时为空");
        } else if (taskBO.getFlagId() == null) {
            return Result.error("flagId不能为空");
        } else if (taskBO.getType() == null) {
            return Result.error("type不能为空");
        } else if (taskBO.getPoint() == null) {
            return Result.error("point不能为空");
        }
        return Result.ifSuccess(taskManager.newTask(taskBO));
    }

    @Override
    @RequestMapping(value = "/modifyTask", method = RequestMethod.PUT)
    public Result<String> modifyTask(@RequestBody TaskBO taskBO) {
        LOG.info("=====》修改周期任务开始：{}", JSON.toJSONString(taskBO));
        if (taskBO.getTaskId() == null) {
            return Result.error("taskId不能为空");
        }
        return Result.ifSuccess(taskManager.modifyTask(taskBO));
    }

    @Override
    @RequestMapping(value = "/queryTaskByTaskId", method = RequestMethod.GET)
    public Result<TaskBO> queryTaskByTaskId(@RequestParam("taskId") String taskId) {
        LOG.info("=====》查询周期任务开始：taskId={}", JSON.toJSONString(taskId));
        return Result.ifSuccess(taskManager.queryTaskByTaskId(taskId));
    }

}
