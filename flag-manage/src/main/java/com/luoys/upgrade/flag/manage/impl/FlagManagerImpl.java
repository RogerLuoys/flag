package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.api.bo.FlagDetailBO;
import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.dao.mapper.FlagBindMapper;
import com.luoys.upgrade.flag.dao.mapper.FlagMapper;
import com.luoys.upgrade.flag.dao.mapper.TaskMapper;
import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.dao.po.TaskPO;
import com.luoys.upgrade.flag.manage.FlagManager;
import com.luoys.upgrade.flag.manage.util.TransformFlag;
import com.luoys.upgrade.flag.manage.util.TransformTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlagManagerImpl implements FlagManager {

    private static Logger LOG = LoggerFactory.getLogger(FlagManagerImpl.class);

    private final Integer DEFAULT_FLAGTYPE = 1;
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
    public FlagDetailBO queryFlagByFlagId(String flagId) {
        FlagPO flagPO = flagMapper.selectByFlagId(flagId);
        FlagBindPO flagBindPO = flagBindMapper.selectByFlagId(flagId);
        FlagDetailBO flagDetailBO = TransformFlag.TransformFlagPO2BO(flagPO);
        if (flagBindPO == null) {
            LOG.error("====>未查询到flag与账户关联信息：{}", flagId);
            return null;
        }
        flagBO.setOwnerId(flagBindPO.getOwnerId());
        flagBO.setOwnerName(flagBindPO.getOwnerName());
        flagBO.setWitnessId(flagBindPO.getWitnessId());
        flagBO.setWitnessName(flagBindPO.getWitnessName());

        // 关联任务
        List<TaskPO> taskPOList = taskMapper.listByFlagId(flagId);
        List<TaskBO> taskBOList = TransformTask.TransformTaskPO2BO(taskPOList);
        flagBO.setTasks(taskBOList);
        return flagBO;
    }

    @Override
    public String newFlag(FlagDetailBO flagDetailBO) {
        // 填入业务Id
        flagDetailBO.setFlagId(NumberSender.createFlagId());
//        if (flagBO.getFlagName() == null) {
//            LOG.error("=====>必填字段 flagName 为空");
//            return null;
//        }
        if (flagDetailBO.getType() == null) {
            flagDetailBO.setType(DEFAULT_FLAGTYPE);
        }
        if (flagDetailBO.getPriority() == null) {
            flagDetailBO.setPriority(DEFAULT_PRIORITY);
        }
        if (flagDetailBO.getCreateId() == null) {
            flagDetailBO.setCreateId(DEFAULT_CREATOR);
        }
        if (flagDetailBO.getStatus() == null) {
            flagDetailBO.setStatus(1);
        }
        FlagPO flagPO = TransformFlag.TransformFlagBO2PO(flagDetailBO);
        LOG.info("=====>flag创建，并填充默认值：{}", flagPO);
        flagMapper.insert(flagPO);
        FlagBindPO flagBindPO = new FlagBindPO();
        flagBindPO.setFlagId(flagDetailBO.getFlagId());
        flagBindPO.setOwnerId(flagDetailBO.getOwnerId());
        flagBindPO.setStatus(1);
        flagBindPO.setType(1);
        flagBindMapper.insert(flagBindPO);
        return flagDetailBO.getFlagId();

    }

    @Override
    public int removeByFlagId(String flagId) {
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
            return 0;
        }

    }

    @Override
    public int modifyStatusByFlagId(String flagId, Integer status) {
        int isFlagModified = flagMapper.updateStatusByFlagId(flagId, status);
        int isTaskModified = taskMapper.countTaskByFlagId(flagId) > 0 ? taskMapper.updateStatusByFlagId(flagId, 2) : 2;
        if (isFlagModified == 1 && isTaskModified == 1) {
            return 1;
        } else if (isFlagModified == 1 && isTaskModified == 2) {
            LOG.info("---->关联表无需更新，flagId：{}", flagId);
            return 1;
        } else {
            LOG.error("---->关联表未更新成功，flagId：{}", flagId);
            return 0;
        }

    }

    @Override
    public int modifyFlagBasic(FlagBO flagBO) {
        FlagPO flagPO = TransformFlag.TransformFlagBO2PO(flagBO);
        return flagMapper.update(flagPO);
    }
}