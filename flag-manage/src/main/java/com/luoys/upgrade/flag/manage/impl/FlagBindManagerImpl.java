package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.bo.*;
import com.luoys.upgrade.flag.dao.mapper.FlagBindMapper;
import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import com.luoys.upgrade.flag.dao.po.UserFlagPO;
import com.luoys.upgrade.flag.dao.po.UserReportPO;
import com.luoys.upgrade.flag.manage.FlagBindManager;
import com.luoys.upgrade.flag.manage.transform.TransformFlagBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlagBindManagerImpl implements FlagBindManager {

    private static Logger LOG = LoggerFactory.getLogger(FlagBindManager.class);


    @Autowired
    FlagBindMapper flagBindMapper;

    @Override
    public FlagBindBO addFlagBind(FlagBindBO flagBindBO) {
        LOG.info("=====>添加 flag 绑定关系");
        if (flagBindBO.getFlagId() == null) {
            LOG.error("=====>必填字段 flagId 不能为空");
            return null;
        }
        if (flagBindBO.getOwnerId() == null) {
            LOG.error("=====>必填字段 userId 不能为空");
        }
        if (flagBindBO.getStatus() == null) {
            flagBindBO.setStatus(1);
        }
        if (flagBindBO.getType() == null) {
            flagBindBO.setType(1);
        }
        flagBindMapper.insert(TransformFlagBind.TransformFlagBindBO2PO(flagBindBO));
        return flagBindBO;
    }

    @Override
    public List<UserFlagBO> queryUserFlag(FlagQueryBO flagQueryBO) {
        int startIndex = (flagQueryBO.getPageIndex() - 1) * 10;
        List<UserFlagPO> pos = flagBindMapper.listUserFlag(
                flagQueryBO.getOwnerId(), flagQueryBO.getWitnessId(), flagQueryBO.getType(),
                flagQueryBO.getStatus(), flagQueryBO.getFlagName(), startIndex);
        return TransformFlagBind.TransformUserFlagPO2BO(pos);
    }

    @Override
    public int modifyWitness(FlagBindBO flagBindBO) {
        FlagBindPO flagBindPO = TransformFlagBind.TransformFlagBindBO2PO(flagBindBO);
        return flagBindMapper.update(flagBindPO);
    }


    @Override
    public List<TaskDailyBO> queryUserTaskDaily(TaskDailyQueryBO taskDailyQueryBO) {
        if ( taskDailyQueryBO.getOwnerId() == null && taskDailyQueryBO.getWitnessId() == null) {
            LOG.error("----》所有者和见证人不能同时为空");
            return null;
        }
        List<TaskDailyPO> poList = flagBindMapper.listUserTaskDaily(
                taskDailyQueryBO.getOwnerId(), taskDailyQueryBO.getWitnessId(), taskDailyQueryBO.getStartTime(), taskDailyQueryBO.getEndTime());
        return TransformFlagBind.TransformUserTaskDailyPO2BO(poList);
    }



    @Override
    public List<UserReportBO> queryUserReport(String ownerId) {
        List<UserReportPO> poList = flagBindMapper.listUserReport(ownerId, null, null);
        return TransformFlagBind.TransformUserReportPO2BO(poList);
    }

}
