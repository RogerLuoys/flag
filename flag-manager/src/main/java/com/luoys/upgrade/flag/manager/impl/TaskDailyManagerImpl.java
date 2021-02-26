package com.luoys.upgrade.flag.manager.impl;

import com.luoys.common.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.dao.mapper.*;
import com.luoys.upgrade.flag.dao.po.*;
import com.luoys.upgrade.flag.manager.TaskDailyManager;
import com.luoys.upgrade.flag.manager.transform.TransformTaskDaily;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskDailyManagerImpl implements TaskDailyManager {

    private static final Logger LOG = LoggerFactory.getLogger(TaskDailyManagerImpl.class);
    private static final Integer COMPLETED = 2;

    @Autowired
    private TaskDailyMapper taskDailyMapper;

    @Autowired
    private FlagMapper flagMapper;

    @Autowired
    private FlagBindMapper flagBindMapper;

    @Autowired
    private PointLogMapper pointLogMapper;

    @Autowired
    private PointMapper pointMapper;

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
    public Integer modifyTaskDailyStatus(String taskDailyId, Integer status, String pointId) {
        if (taskDailyId == null || status == null || pointId == null) {
            LOG.error("----》入参不能为空，修改状态失败");
            return null;
        }
        if (status == COMPLETED) {
            TaskDailyPO taskDailyPO = taskDailyMapper.selectByTaskDailyId(taskDailyId);
            PointLogPO pointLogPO = new PointLogPO();
            pointLogPO.setPointId(pointId);
            pointLogPO.setDescription("完成每日任务获得");
            pointLogPO.setComment(taskDailyPO.getTaskDailyName());
            pointLogPO.setPoint(taskDailyPO.getPoint());
            pointLogPO.setRecordTime(new Date());
            pointLogPO.setType(1);
            LOG.info("====》增加积分记录：{}", pointLogPO);
            int pointLogResult = pointLogMapper.insert(pointLogPO);
            PointPO pointPO = pointMapper.selectByPointId(pointId);
            int usablePoint = pointPO.getUsablePoint() + taskDailyPO.getPoint();
            pointPO.setUsablePoint(usablePoint);
            LOG.info("====》增加账号可用积分：{}", pointPO);
            int pointIncrementResult = pointMapper.update(pointPO);
            int updateTaskDailyResult = taskDailyMapper.updateStatusByTaskDailyId(taskDailyId, status);
            return (pointIncrementResult == 1 && pointLogResult == 1 && updateTaskDailyResult == 1) ? 1 : null;
        } else {
            return taskDailyMapper.updateStatusByTaskDailyId(taskDailyId, status);
        }
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
