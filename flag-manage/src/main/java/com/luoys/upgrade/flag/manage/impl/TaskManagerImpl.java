package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.dao.mapper.TaskDailyMapper;
import com.luoys.upgrade.flag.dao.mapper.TaskMapper;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import com.luoys.upgrade.flag.dao.po.TaskPO;
import com.luoys.upgrade.flag.manage.TaskManager;
import com.luoys.upgrade.flag.manage.util.TimeUtil;
import com.luoys.upgrade.flag.manage.transform.TransformTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskManagerImpl implements TaskManager {

    private static Logger LOG = LoggerFactory.getLogger(TaskManagerImpl.class);
    private final Integer WEEKLY_CYCLE = 2;
    private final Integer SCAN_SUCCESS = 1;

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
    public Integer modifyTask(TaskBO taskBO) {
        TaskPO taskPO = TransformTask.transformBO2PO(taskBO);
        if (taskPO == null) {
            LOG.error("---->要插入的任务不能为空");
            return null;
        }
        LOG.info("====》修改任务：{}", taskPO);
        return taskMapper.update(taskPO);
    }

    @Override
    public Integer automaticConvertWeekTask() {
        List<TaskPO> taskPOList = taskMapper.listByType(WEEKLY_CYCLE);
        if (taskPOList.size() == 0) {
            LOG.error("----》未发现需要转换的周任务");
            return null;
        }
        LOG.info("====》需要转换的周任务数为：{}", taskPOList.size());
        int successNumber = 0;
        for (TaskPO item : taskPOList) {
            TaskDailyPO taskDailyPO = new TaskDailyPO();
            String[] cycles = item.getCycle().split(",");
            taskDailyPO.setTaskId(item.getTaskId());
            taskDailyPO.setDescription(item.getDescription());
            taskDailyPO.setFlagId(item.getFlagId());
            taskDailyPO.setTaskDailyName(item.getTaskName());
            taskDailyPO.setPoint(item.getPoint());
            for (int i = 0; i < cycles.length; i++) {
                taskDailyPO.setStartTime(TimeUtil.getWeekCycleStartTime(cycles[i]));
                taskDailyPO.setEndTime(TimeUtil.getWeekCycleEndTime(cycles[i]));
                taskDailyMapper.insert(taskDailyPO);
                successNumber++;
            }
            // todo 改成lastScanTime
            taskMapper.updateScanStatusByTaskId(taskDailyPO.getTaskId(), SCAN_SUCCESS);
        }
        LOG.info("====》转换成功的周任务数为：{}", successNumber);
        return successNumber;
    }
}
