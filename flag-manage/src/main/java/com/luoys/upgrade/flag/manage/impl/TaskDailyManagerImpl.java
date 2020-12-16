package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.dao.mapper.TaskDailyMapper;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import com.luoys.upgrade.flag.manage.TaskDailyManager;
import com.luoys.upgrade.flag.manage.util.TransformTaskDaily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskDailyManagerImpl implements TaskDailyManager {

    @Autowired
    private TaskDailyMapper taskDailyMapper;

    @Override
    public String newTaskDaily(TaskDailyBO taskDailyBO) {
        taskDailyBO.setTaskDailyId(NumberSender.createTaskDailyId());
        TaskDailyPO taskDailyPO = TransformTaskDaily.transformTaskDailyBO2PO(taskDailyBO);
        return taskDailyMapper.insert(taskDailyPO) == 1 ? taskDailyPO.getTaskDailyId() : null;
    }
}
