package com.luoys.upgrade.flag.manage.util;

import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.dao.po.TaskPO;

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

}
