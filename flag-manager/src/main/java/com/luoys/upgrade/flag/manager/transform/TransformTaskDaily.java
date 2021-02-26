package com.luoys.upgrade.flag.manager.transform;

import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;

public class TransformTaskDaily {

    public static TaskDailyPO transformBO2PO(TaskDailyBO bo) {
        if (bo == null) {
            return null;
        }
        TaskDailyPO po = new TaskDailyPO();
        po.setComment(bo.getComment());
        po.setDescription(bo.getDescription());
        po.setEndTime(bo.getEndTime());
        po.setFlagId(bo.getFlagId());
        po.setPoint(bo.getPoint());
        po.setStartTime(bo.getStartTime());
        po.setStatus(bo.getStatus());
        po.setTaskDailyId(bo.getTaskDailyId());
        po.setTaskDailyName(bo.getTaskDailyName());
        po.setTaskId(bo.getTaskId());
        return po;
    }

//    public static TaskDailyPO transformTaskDailyBO2PO(TaskDailyDetailBO bo) {
//        if (bo == null) {
//            return null;
//        }
//        TaskDailyPO po = new TaskDailyPO();
//        po.setComment(bo.getComment());
//        po.setDescription(bo.getDescription());
//        po.setEndTime(bo.getEndTime());
//        po.setFlagId(bo.getFlagId());
//        po.setPoint(bo.getPoint());
//        po.setStartTime(bo.getStartTime());
//        po.setStatus(bo.getStatus());
//        po.setTaskDailyId(bo.getTaskDailyId());
//        po.setTaskDailyName(bo.getTaskDailyName());
//        po.setTaskId(bo.getTaskId());
//        return po;
//    }
}
