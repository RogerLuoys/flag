package com.luoys.upgrade.flag.manager.impl;

import com.luoys.common.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.api.enums.FlagPriorityEnum;
import com.luoys.upgrade.flag.api.enums.FlagStatusEnum;
import com.luoys.upgrade.flag.api.enums.FlagTypeEnum;
import com.luoys.upgrade.flag.api.enums.TaskStatusEnum;
import com.luoys.upgrade.flag.dao.mapper.FlagBindMapper;
import com.luoys.upgrade.flag.dao.mapper.FlagMapper;
import com.luoys.upgrade.flag.dao.mapper.TaskMapper;
import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.dao.po.TaskPO;
import com.luoys.upgrade.flag.manager.FlagManager;
import com.luoys.upgrade.flag.manager.transform.TransformFlag;
import com.luoys.upgrade.flag.manager.transform.TransformTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlagManagerImpl implements FlagManager {

    private static final Logger LOG = LoggerFactory.getLogger(FlagManagerImpl.class);

    private static final String DEFAULT_CREATOR = "1";


    @Autowired
    private FlagMapper flagMapper;
    @Autowired
    private FlagBindMapper flagBindMapper;
    @Autowired
    private TaskMapper taskMapper;

    // 查询flag详情
    @Override
    public FlagBO queryFlagByFlagId(String flagId) {
        // 查询flag基本信息
        FlagPO flagPO = flagMapper.selectByFlagId(flagId);
        FlagBO flagBO = TransformFlag.TransformPO2BO(flagPO);

        // 查询flag绑定关系
        FlagBindPO flagBindPO = flagBindMapper.selectByFlagId(flagId);
        if (flagBindPO == null) {
            LOG.error("====>未查询到flag与账户关联信息：{}", flagId);
            return null;
        }
        flagBO.setOwnerId(flagBindPO.getOwnerId());
        flagBO.setOwnerName(flagBindPO.getOwnerName());
        flagBO.setWitnessId(flagBindPO.getWitnessId());
        flagBO.setWitnessName(flagBindPO.getWitnessName());

        // 关联周期任务
        List<TaskPO> taskPOList = taskMapper.listByFlagId(flagId);
        List<TaskBO> taskBOList = TransformTask.TransformPO2BO(taskPOList);
        flagBO.setTaskList(taskBOList);
        flagBO.setTotalTask(taskBOList.size());
        return flagBO;
    }

    @Override
    public String newFlag(FlagBO flagBO) {
        // 填入业务Id
        flagBO.setFlagId(NumberSender.createFlagId());
        if (flagBO.getType() == null) {
            flagBO.setType(FlagTypeEnum.FLAG.getCode());
        }
        if (flagBO.getPriority() == null) {
            flagBO.setPriority(FlagPriorityEnum.GENERAL.getCode());
        }
        if (flagBO.getCreateId() == null) {
            flagBO.setCreateId(DEFAULT_CREATOR);
        }
        if (flagBO.getStatus() == null) {
            flagBO.setStatus(FlagStatusEnum.NOT_START.getCode());
        }
        FlagPO flagPO = TransformFlag.TransformBO2PO(flagBO);
        LOG.info("=====>flag创建，并填充默认值：{}", flagPO);
        flagMapper.insert(flagPO);
        FlagBindPO flagBindPO = new FlagBindPO();
        flagBindPO.setFlagId(flagBO.getFlagId());
        flagBindPO.setOwnerId(flagBO.getOwnerId());
        flagBindPO.setStatus(FlagStatusEnum.NOT_START.getCode());
        flagBindPO.setType(FlagTypeEnum.FLAG.getCode());
        flagBindMapper.insert(flagBindPO);
        // 无任务需要新增
        if (null == flagBO.getTaskList() || flagBO.getTaskList().size() == 0) {
            return flagBO.getFlagId();
        }
        for (TaskBO item : flagBO.getTaskList()) {
            TaskPO taskPO = TransformTask.transformBO2PO(item);
            taskPO.setTaskId(NumberSender.createTaskId());
            if (null == taskPO.getStatus()) {
                taskPO.setStatus(TaskStatusEnum.PAUSE.getCode());
            }
            if (null == taskPO.getFlagId()) {
                taskPO.setFlagId(flagBO.getFlagId());
            }
            LOG.info("=====>创建周期任务：{}", taskPO);
            taskMapper.insert(taskPO);
        }
        return flagBO.getFlagId();
    }

    @Override
    public Integer removeByFlagId(String flagId) {
        int isFlagDeleted = flagMapper.deleteByFlagId(flagId);
        int isFlagBindDeleted = flagBindMapper.deleteByFlagId(flagId);
        int isTaskDeleted = taskMapper.countTaskByFlagId(flagId) > 0 ? taskMapper.deleteByFlagId(flagId) : 2;

        if (isFlagBindDeleted == 1 && isFlagDeleted == 1 && isTaskDeleted == 1) {
            LOG.info("---->关联表删除成功，flagId：{}", flagId);
            return 1;
        } else if (isFlagBindDeleted == 1 && isFlagDeleted == 1 && isTaskDeleted == 2) {
            LOG.info("---->关联表无需删除，flagId：{}", flagId);
            return 1;
        } else {
            LOG.error("---->关联表未删除成功，flagId：{}", flagId);
            return null;
        }

    }

    @Override
    public Integer modifyStatusByFlagId(String flagId, Integer status) {
        if (flagId == null || status == null) {
            LOG.error("---->入参不能为空");
            return null;
        }
        int isFlagModified = flagMapper.updateStatusByFlagId(flagId, status);
        if (isFlagModified != 1) {
            LOG.error("---->更新Flag状态失败");
            return null;
        }
        if (taskMapper.countTaskByFlagId(flagId) == 0) {
            LOG.info("---->无要更新的周期任务，更新状态流程结束");
            return 1;
        }
        switch (FlagStatusEnum.fromCode(status)) {
            case IN_PROGRESS:
                return taskMapper.updateStatusByFlagId(flagId, TaskStatusEnum.IN_PROGRESS.getCode()) == 1 ? 1 : null;
            case COMPLETED:
                return taskMapper.updateStatusByFlagId(flagId, TaskStatusEnum.PAUSE.getCode()) == 1 ? 1 : null;
            default:
                LOG.info("====》无需更新周期任务状态");
                return 1;
        }
    }

    @Override
    public Integer modifyFlagBasic(FlagBO flagBO) {
        if (null == flagBO) {
            LOG.error("---->要修改的基本信息不能为空");
            return null;
        }
        FlagPO flagPO = TransformFlag.TransformBO2PO(flagBO);
        return flagMapper.update(flagPO);
    }
}