package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.dao.mapper.FlagBindMapper;
import com.luoys.upgrade.flag.dao.mapper.FlagMapper;
import com.luoys.upgrade.flag.dao.mapper.TaskDailyMapper;
import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import com.luoys.upgrade.flag.manage.TaskDailyManager;
import com.luoys.upgrade.flag.manage.transform.TransformTaskDaily;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskDailyManagerImpl implements TaskDailyManager {

    private static final Logger LOG = LoggerFactory.getLogger(TaskDailyManagerImpl.class);

    @Autowired
    private TaskDailyMapper taskDailyMapper;

    @Autowired
    private FlagMapper flagMapper;

    @Autowired
    private FlagBindMapper flagBindMapper;

    @Override
    public String newTaskDaily(TaskDailyBO taskDailyBO) {
        if (taskDailyBO.getFlagId() == null || taskDailyBO.getFlagId() == "") {
            taskDailyBO.setFlagId(NumberSender.createFlagId());
        }
        FlagPO flagPO = new FlagPO();
        flagPO.setFlagId(taskDailyBO.getFlagId());
        flagPO.setFlagName(taskDailyBO.getTaskDailyName());
        flagPO.setType(3);
        flagPO.setStatus(3);
        int isFlagCreated = flagMapper.insert(flagPO);
        if (isFlagCreated == 0) {
            return null;
        }
        FlagBindPO flagBindPO = new FlagBindPO();
        flagBindPO.setFlagId(taskDailyBO.getFlagId());
        flagBindPO.setOwnerId(taskDailyBO.getOwnerId());
        flagBindPO.setStatus(1);
        flagBindPO.setType(1);
        int isFlagBindCreated = flagBindMapper.insert(flagBindPO);
        if (isFlagBindCreated == 0) {
            return null;
        }
        taskDailyBO.setTaskDailyId(NumberSender.createTaskDailyId());
        taskDailyBO.setFlagId(flagPO.getFlagId());
        taskDailyBO.setStatus(1);
        TaskDailyPO taskDailyPO = TransformTaskDaily.transformBO2PO(taskDailyBO);
        return taskDailyMapper.insert(taskDailyPO) == 1 ? taskDailyPO.getTaskDailyId() : null;
    }


    @Override
    public Integer modifyTaskDailyStatus(String taskDailyId, Integer status) {
        if (taskDailyId == null || status == null) {
            LOG.error("----》入参不能为空，修改状态失败");
            return null;
        }
        return taskDailyMapper.updateStatusByTaskDailyId(taskDailyId, status);
    }

    @Override
    public Integer modifyTaskDailyComment(String taskDailyId, String comment) {
        if (taskDailyId == null || comment == null) {
            LOG.error("----》入参不能为空，修改备注失败");
            return null;
        }
        return taskDailyMapper.updateCommentByTaskDailyId(taskDailyId, comment);
    }
}
