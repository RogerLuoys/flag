package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.dao.mapper.TaskDailyMapper;
import com.luoys.upgrade.flag.dao.mapper.TaskMapper;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import com.luoys.upgrade.flag.dao.po.TaskPO;
import com.luoys.upgrade.flag.manage.TaskManager;
import com.luoys.upgrade.flag.manage.util.TransformTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TaskManagerImpl implements TaskManager {

    private static Logger LOG = LoggerFactory.getLogger(TaskManagerImpl.class);
    private final Integer WEEKLY_CYCLE = 2;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private TaskDailyMapper taskDailyMapper;

    @Override
    public String newTask(TaskBO taskBO) {
        TaskPO taskPO = TransformTask.transformBO2PO(taskBO);
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
    public TaskBO queryTaskByTaskId(String taskId) {
        if (taskId == null) {
            LOG.error("---->taskId不能为空");
            return null;
        }
        return TransformTask.transformPO2BO(taskMapper.selectByTaskId(taskId));
    }


    @Override
    public int modifyTask(TaskBO taskBO) {
        TaskPO taskPO = TransformTask.transformBO2PO(taskBO);
        if (taskPO == null) {
            LOG.error("---->要插入的任务不能为空");
            return 0;
        }
        return taskMapper.update(taskPO);
    }


    @Override
    public int convertWeekTask() {
        List<TaskPO> taskPOList = taskMapper.listByType(WEEKLY_CYCLE);
        TaskDailyPO taskDailyPO = new TaskDailyPO();
        for (TaskPO item : taskPOList) {
            taskDailyPO = null;
            String[] cycles = item.getCycle().split(",");
            taskDailyPO.setTaskId(item.getTaskId());
            taskDailyPO.setDescription(item.getDescription());
            taskDailyPO.setFlagId(item.getFlagId());
            taskDailyPO.setTaskDailyName(item.getTaskName());
            taskDailyPO.setPoint(item.getPoint());
            for (int i = 0; i < cycles.length; i++) {
                // todo 需计算日期
                taskDailyPO.setStartTime(new Date());
                taskDailyPO.setEndTime(new Date());
                taskDailyMapper.insert(taskDailyPO);
            }
        }
        return 1;
    }
}
