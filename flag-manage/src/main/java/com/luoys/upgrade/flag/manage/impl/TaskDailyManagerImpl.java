package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.api.bo.TaskDailyDetailBO;
import com.luoys.upgrade.flag.dao.mapper.FlagBindMapper;
import com.luoys.upgrade.flag.dao.mapper.FlagMapper;
import com.luoys.upgrade.flag.dao.mapper.TaskDailyMapper;
import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import com.luoys.upgrade.flag.manage.FlagBindManager;
import com.luoys.upgrade.flag.manage.TaskDailyManager;
import com.luoys.upgrade.flag.manage.util.TransformTaskDaily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskDailyManagerImpl implements TaskDailyManager {

    @Autowired
    private TaskDailyMapper taskDailyMapper;

    @Autowired
    private FlagMapper flagMapper;

    @Autowired
    private FlagBindMapper flagBindMapper;

    @Override
    public String newTaskDaily(TaskDailyDetailBO taskDailyDetailBO) {
        if (taskDailyDetailBO.getFlagId() == null || taskDailyDetailBO.getFlagId() == "") {
            taskDailyDetailBO.setFlagId(NumberSender.createFlagId());
        }
        FlagPO flagPO = new FlagPO();
        flagPO.setFlagId(taskDailyDetailBO.getFlagId());
        flagPO.setFlagName(taskDailyDetailBO.getTaskDailyName());
        flagPO.setType(3);
        flagPO.setStatus(3);
        int isFlagCreated = flagMapper.insert(flagPO);
        if (isFlagCreated == 0) {
            return null;
        }
        FlagBindPO flagBindPO = new FlagBindPO();
        flagBindPO.setFlagId(taskDailyDetailBO.getFlagId());
        flagBindPO.setOwnerId(taskDailyDetailBO.getOwnerId());
        flagBindPO.setStatus(1);
        flagBindPO.setType(1);
        int isFlagBindCreated = flagBindMapper.insert(flagBindPO);
        if (isFlagBindCreated == 0) {
            return null;
        }
        taskDailyDetailBO.setTaskDailyId(NumberSender.createTaskDailyId());
        taskDailyDetailBO.setFlagId(flagPO.getFlagId());
        taskDailyDetailBO.setStatus(1);
        TaskDailyPO taskDailyPO = TransformTaskDaily.transformBO2PO(taskDailyDetailBO);
        return taskDailyMapper.insert(taskDailyPO) == 1 ? taskDailyPO.getTaskDailyId() : null;
    }
}
