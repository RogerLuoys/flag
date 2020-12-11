package com.luoys.upgrade.flag.manage.util;

import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.dao.po.TaskPO;

import java.util.ArrayList;
import java.util.List;

public class TransformTask {

    public static TaskPO transformTaskBO2PO(TaskBO bo) {
        if (bo == null) {
            return null;
        }
        TaskPO po = new TaskPO();
        po.setCreatorId(bo.getCreatorId());
        po.setCycle(bo.getCycle());
        po.setDescription(bo.getDescription());
        po.setFlagId(bo.getFlagId());
        po.setIsScanned(bo.getIsScanned());
        po.setPoint(bo.getPoint());
        po.setStatus(bo.getStatus());
        po.setTaskId(bo.getTaskId());
        po.setTaskName(bo.getTaskName());
        po.setType(bo.getType());
        return po;
    }

    public static TaskBO transformTaskPO2BO(TaskPO po) {
        if (po == null) {
            return null;
        }
        TaskBO bo = new TaskBO();
        bo.setCreatorId(po.getCreatorId());
        bo.setCycle(po.getCycle());
        bo.setDescription(po.getDescription());
        bo.setFlagId(po.getFlagId());
        bo.setIsScanned(po.getIsScanned());
        bo.setPoint(po.getPoint());
        bo.setStatus(po.getStatus());
        bo.setTaskId(po.getTaskId());
        bo.setTaskName(po.getTaskName());
        bo.setType(po.getType());
        return bo;
    }

    public static List<TaskBO> TransformTaskPO2BO(List<TaskPO> po) {
        List<TaskBO> bo = new ArrayList<>();
        for (TaskPO item : po) {
            bo.add(transformTaskPO2BO(item));
        }
        return bo;
    }

}
