package com.luoys.upgrade.flag.manager.impl;

import com.luoys.common.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.api.enums.FlagStatusEnum;
import com.luoys.upgrade.flag.api.enums.FlagTypeEnum;
import com.luoys.upgrade.flag.api.enums.PointLogTypeEnum;
import com.luoys.upgrade.flag.api.enums.TaskDailyStatusEnum;
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
        // 未关联flagId，则需要新增flag相关数据
        if (taskDailyBO.getFlagId() == null || taskDailyBO.getFlagId() == "") {
            taskDailyBO.setFlagId(NumberSender.createFlagId());
            FlagPO flagPO = new FlagPO();
            flagPO.setFlagId(taskDailyBO.getFlagId());
            flagPO.setFlagName(taskDailyBO.getTaskDailyName());
            flagPO.setType(FlagTypeEnum.TEMPORARY.getCode());
            flagPO.setStatus(FlagStatusEnum.COMPLETED.getCode());
            int isFlagCreated = flagMapper.insert(flagPO);
            if (isFlagCreated == 0) {
                LOG.error("----》新增Flag失败");
                return null;
            }
            FlagBindPO flagBindPO = new FlagBindPO();
            flagBindPO.setFlagId(taskDailyBO.getFlagId());
            flagBindPO.setOwnerId(taskDailyBO.getOwnerId());
//            flagBindPO.setStatus(1);
//            flagBindPO.setType(1);
            int isFlagBindCreated = flagBindMapper.insert(flagBindPO);
            if (isFlagBindCreated == 0) {
                LOG.error("----》新增FlagBind失败");
                return null;
            }
        }
        // 如果关联了FlagId，则直接插入FlagId
        taskDailyBO.setTaskDailyId(NumberSender.createTaskDailyId());
        taskDailyBO.setFlagId(taskDailyBO.getFlagId());
        taskDailyBO.setStatus(TaskDailyStatusEnum.IN_PROGRESS.getCode());
        TaskDailyPO taskDailyPO = TransformTaskDaily.transformBO2PO(taskDailyBO);
        return taskDailyMapper.insert(taskDailyPO) == 1 ? taskDailyPO.getTaskDailyId() : null;
    }


    @Override
    public Integer modifyTaskDailyStatus(String taskDailyId, Integer status, String pointId) {
        if (taskDailyId == null || status == null || pointId == null) {
            LOG.error("----》入参不能为空，修改状态失败");
            return null;
        }
        if (status == TaskDailyStatusEnum.COMPLETED.getCode()) {
            TaskDailyPO taskDailyPO = taskDailyMapper.selectByTaskDailyId(taskDailyId);
            PointLogPO pointLogPO = new PointLogPO();
            pointLogPO.setPointId(pointId);
            pointLogPO.setDescription("完成每日任务获得");
            pointLogPO.setComment(taskDailyPO.getTaskDailyName());
            pointLogPO.setPoint(taskDailyPO.getPoint());
            pointLogPO.setRecordTime(new Date());
            pointLogPO.setType(PointLogTypeEnum.INCREASE.getCode());
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
