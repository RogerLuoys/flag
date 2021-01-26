package com.luoys.upgrade.flag.manage.transform;

import com.luoys.upgrade.flag.api.bo.ReportLogBO;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;

import java.util.ArrayList;
import java.util.List;

public class TransformReport {


    public static ReportLogBO transformPO2BO(TaskDailyPO po) {
        if (po == null) {
            return null;
        }
        ReportLogBO bo = new ReportLogBO();
        bo.setComment(po.getComment());
        bo.setEndTime(po.getEndTime());
        bo.setStartTime(po.getStartTime());
        bo.setTaskDailyId(po.getTaskDailyId());
        bo.setTaskDailyName(po.getTaskDailyName());
        return bo;
    }


    public static List<ReportLogBO> TransformPO2BO(List<TaskDailyPO> po) {
        List<ReportLogBO> bo = new ArrayList<>();
        for (TaskDailyPO item : po) {
            bo.add(transformPO2BO(item));
        }
        return bo;
    }


}
