package com.luoys.upgrade.flag.service.impl;

import com.alibaba.fastjson.JSON;
import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.api.service.TaskDailyService;
import com.luoys.upgrade.flag.manage.TaskDailyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/taskDaily")
public class TaskDailyServiceImpl implements TaskDailyService {

    private static final Logger LOG = LoggerFactory.getLogger(TaskDailyServiceImpl.class);

    @Autowired
    private TaskDailyManager taskDailyManager;

    @Override
    @RequestMapping(value = "/newTaskDaily", method = RequestMethod.POST)
    public Result<String> newTaskDaily(@RequestBody TaskDailyBO taskDailyBO) {
        LOG.info("=====》创建每日任务开始：{}", JSON.toJSONString(taskDailyBO));
        return Result.ifSuccess(taskDailyManager.newTaskDaily(taskDailyBO));
    }

    @Override
    @RequestMapping(value = "/modifyTaskDailyStatus", method = RequestMethod.PUT)
    public Result<String> modifyTaskDailyStatus(@RequestParam("taskDailyId") String taskDailyId, @RequestParam("status") Integer status) {
        LOG.info("====》修改每日任务状态开始：taskDailyId={}，status={}", taskDailyId, status);
        return Result.ifSuccess(taskDailyManager.modifyTaskDailyStatus(taskDailyId, status));
    }
}
