package com.luoys.upgrade.flag.service.impl;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.api.service.TaskDailyService;
import com.luoys.upgrade.flag.manage.TaskDailyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/taskDaily")
public class TaskDailyServiceImpl implements TaskDailyService {

    @Autowired
    private TaskDailyManager taskDailyManager;

    @Override
    @RequestMapping(value = "/newTaskDaily", method = RequestMethod.POST)
    public Result<String> newTaskDaily(@RequestBody TaskDailyBO taskDailyBO) {

        return Result.success(taskDailyManager.newTaskDaily(taskDailyBO));
    }
}
