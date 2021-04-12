package com.luoys.upgrade.flag.manager.transform;

import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.dao.po.TaskPO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformTask {

    public static TaskPO transformBO2PO(TaskBO bo) {
        if (bo == null) {
            return null;
        }
        TaskPO po = new TaskPO();
        po.setCreatorId(bo.getCreatorId());
        po.setDescription(bo.getDescription());
        po.setFlagId(bo.getFlagId());
        po.setScanTime(bo.getScanTime());
        po.setPoint(bo.getPoint());
        po.setStatus(bo.getStatus());
        po.setTaskId(bo.getTaskId());
        po.setTaskName(bo.getTaskName());
        po.setType(bo.getType());
        // 如果任务周期字符串有值，则直接使用；否则将任务周期列表转为字符串（逗号分隔）
        if (null != bo.getCycle()) {
            po.setCycle(bo.getCycle());
        } else if (null != bo.getCycleList()) {
            StringBuilder cycles = new StringBuilder();
            for (String cycle : bo.getCycleList()) {
                cycles.append(cycle);
                cycles.append(",");
            }
            cycles.delete(cycles.length() - 1, cycles.length());
            po.setCycle(cycles.toString());
        } else {
            po.setCycle(null);
        }
        return po;
    }

    public static TaskBO transformPO2BO(TaskPO po) {
        if (po == null) {
            return null;
        }
        TaskBO bo = new TaskBO();
        bo.setCreatorId(po.getCreatorId());
        bo.setCycle(po.getCycle());
        bo.setDescription(po.getDescription());
        bo.setFlagId(po.getFlagId());
        bo.setScanTime(po.getScanTime());
        bo.setPoint(po.getPoint());
        bo.setStatus(po.getStatus());
        bo.setTaskId(po.getTaskId());
        bo.setTaskName(po.getTaskName());
        bo.setType(po.getType());
        // 周期转换成List格式
        String[] cycles = po.getCycle().split(",");
        bo.setCycleList(new ArrayList<>(Arrays.asList(cycles)));
        return bo;
    }

    public static List<TaskBO> TransformPO2BO(List<TaskPO> po) {
        List<TaskBO> bo = new ArrayList<>();
        for (TaskPO item : po) {
            bo.add(transformPO2BO(item));
        }
        return bo;
    }

}
