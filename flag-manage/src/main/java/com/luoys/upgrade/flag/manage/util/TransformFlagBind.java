package com.luoys.upgrade.flag.manage.util;

import com.luoys.upgrade.flag.api.bo.FlagBindBO;
import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.api.bo.UserFlagBO;
import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import com.luoys.upgrade.flag.dao.po.UserFlagPO;

import java.util.ArrayList;
import java.util.List;

public class TransformFlagBind {
    public static FlagBindPO TransformFlagBindBO2PO(FlagBindBO bo) {
        if (bo == null) {
            return null;
        }
        FlagBindPO po = new FlagBindPO();
        po.setFlagId(bo.getFlagId());
        po.setOwnerId(bo.getOwnerId());
        po.setStatus(bo.getStatus());
        po.setType(bo.getType());
        return po;
    }

    public static UserFlagBO TransformUserFlagPO2BO(UserFlagPO po) {
        if (po == null) {
            return null;
        }
        UserFlagBO bo = new UserFlagBO();
        bo.setActual(po.getActual());
        bo.setCreatorId(po.getCreatorId());
        bo.setDescription(po.getDescription());
        bo.setEndDate(po.getEndDate());
        bo.setExpected(po.getExpected());
        bo.setFlagId(po.getFlagId());
        bo.setFlagName(po.getFlagName());
        bo.setType(po.getFlagType());
        bo.setPriority(po.getPriority());
        bo.setStartDate(po.getStartDate());
        bo.setStatus(po.getStatus());
        bo.setOwnerId(po.getOwnerId());
        bo.setOwnerName(po.getOwnerName());
        bo.setWitnessName(po.getWitnessName());
        bo.setWitnessId(po.getWitnessId());
        return bo;
    }

    public static List<UserFlagBO> TransformUserFlagPO2BO(List<UserFlagPO> po) {
        List<UserFlagBO> bo = new ArrayList<>();
        for (UserFlagPO item : po) {
            bo.add(TransformUserFlagPO2BO(item));
        }
        return bo;
    }


    public static TaskDailyBO TransformUserTaskDailyPO2BO(TaskDailyPO po) {
        if (po == null) {
            return null;
        }
        TaskDailyBO bo = new TaskDailyBO();
        bo.setStatus(po.getStatus());
        bo.setFlagId(po.getFlagId());
        bo.setTaskDailyId(po.getTaskDailyId());
        bo.setComment(po.getComment());
        bo.setDescription(po.getDescription());
        bo.setEndTime(po.getEndTime());
        bo.setPoint(po.getPoint());
        bo.setStartTime(po.getStartTime());
        bo.setTaskDailyName(po.getTaskDailyName());
        bo.setTaskId(po.getTaskId());
        return bo;
    }

    public static List<TaskDailyBO> TransformUserTaskDailyPO2BO(List<TaskDailyPO> po) {
        List<TaskDailyBO> bo = new ArrayList<>();
        for (TaskDailyPO item : po) {
            bo.add(TransformUserTaskDailyPO2BO(item));
        }
        return bo;
    }
}
