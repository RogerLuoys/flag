package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.dao.mapper.FlagBindMapper;
import com.luoys.upgrade.flag.dao.mapper.FlagMapper;
import com.luoys.upgrade.flag.dao.mapper.TaskMapper;
import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.dao.po.TaskPO;
import com.luoys.upgrade.flag.manage.FlagManager;
import com.luoys.upgrade.flag.manage.transform.TransformFlag;
import com.luoys.upgrade.flag.manage.transform.TransformTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlagManagerImpl implements FlagManager {

    private static final Logger LOG = LoggerFactory.getLogger(FlagManagerImpl.class);

    private final Integer DEFAULT_FLAG_TYPE = 1;
    private final Integer DEFAULT_PRIORITY = 1;
    private final String DEFAULT_CREATOR = "1";
    private final Integer ADD_FLAG_SUCCESS = 1;

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
            flagBO.setType(DEFAULT_FLAG_TYPE);
        }
        if (flagBO.getPriority() == null) {
            flagBO.setPriority(DEFAULT_PRIORITY);
        }
        if (flagBO.getCreateId() == null) {
            flagBO.setCreateId(DEFAULT_CREATOR);
        }
        if (flagBO.getStatus() == null) {
            flagBO.setStatus(1);
        }
        FlagPO flagPO = TransformFlag.TransformBO2PO(flagBO);
        LOG.info("=====>flag创建，并填充默认值：{}", flagPO);
        flagMapper.insert(flagPO);
        FlagBindPO flagBindPO = new FlagBindPO();
        flagBindPO.setFlagId(flagBO.getFlagId());
        flagBindPO.setOwnerId(flagBO.getOwnerId());
        flagBindPO.setStatus(1);
        flagBindPO.setType(1);
        flagBindMapper.insert(flagBindPO);
        if (flagBO.getTaskList().size() == 0) {
            // 无任务需要新增
            return flagBO.getFlagId();
        }
        for (TaskBO item : flagBO.getTaskList()) {
            TaskPO taskPO = TransformTask.transformBO2PO(item);
            taskPO.setTaskId(NumberSender.createTaskId());
            LOG.info("=====>创建周期任务：{}", taskPO);
            taskMapper.insert(TransformTask.transformBO2PO(item));
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
        int isFlagModified = flagMapper.updateStatusByFlagId(flagId, status);
        int isTaskModified = taskMapper.countTaskByFlagId(flagId) > 0 ? taskMapper.updateStatusByFlagId(flagId, 2) : 2;
        if (isFlagModified == 1 && isTaskModified == 1) {
            return 1;
        } else if (isFlagModified == 1 && isTaskModified == 2) {
            LOG.info("---->关联表无需更新，flagId：{}", flagId);
            return 1;
        } else {
            LOG.error("---->关联表未更新成功，flagId：{}", flagId);
            return null;
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