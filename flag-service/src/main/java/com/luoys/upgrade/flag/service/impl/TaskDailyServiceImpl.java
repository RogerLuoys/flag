package com.luoys.upgrade.flag.service.impl;

import com.alibaba.fastjson.JSON;
import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.api.bo.TaskDailyDetailBO;
import com.luoys.upgrade.flag.api.service.TaskDailyService;
import com.luoys.upgrade.flag.manage.TaskDailyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/taskDaily")
public class TaskDailyServiceImpl implements TaskDailyService {

    private static final Logger LOG = LoggerFactory.getLogger(TaskDailyServiceImpl.class);

    @Autowired
    private TaskDailyManager taskDailyManager;

    @Override
    @RequestMapping(value = "/newTaskDaily", method = RequestMethod.POST)
    public Result<String> newTaskDaily(@RequestBody TaskDailyDetailBO taskDailyDetailBO) {
        LOG.info("=====>创建每日任务：{}", JSON.toJSONString(taskDailyDetailBO));
        return Result.success(taskDailyManager.newTaskDaily(taskDailyDetailBO));
    }
}
