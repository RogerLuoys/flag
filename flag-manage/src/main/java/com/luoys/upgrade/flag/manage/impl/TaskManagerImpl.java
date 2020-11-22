package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.dao.mapper.TaskMapper;
import com.luoys.upgrade.flag.dao.po.TaskPO;
import com.luoys.upgrade.flag.manage.TaskManager;
import com.luoys.upgrade.flag.manage.util.TransformTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskManagerImpl implements TaskManager {

    private static Logger LOG = LoggerFactory.getLogger(TaskManagerImpl.class);

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public String newTask(TaskBO taskBO) {
        TaskPO taskPO = TransformTask.transformTaskBO2PO(taskBO);
        if (taskPO == null) {
            LOG.error("---->要插入的任务不能为空");
            return null;
        }
        taskPO.setTaskId(NumberSender.createTaskId());
        if (taskPO.getStatus() == null) {
            taskPO.setStatus(1);
        }
        return taskMapper.insert(taskPO) == 1 ? taskPO.getTaskId() : null;
    }

    @Override
    public int modifyTask(TaskBO taskBO) {
        TaskPO taskPO = TransformTask.transformTaskBO2PO(taskBO);
        if (taskPO == null) {
            LOG.error("---->要插入的任务不能为空");
            return 0;
        }
        return taskMapper.update(taskPO);
    }
}
