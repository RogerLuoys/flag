package com.luoys.upgrade.flag.manager.transform;

import com.luoys.upgrade.flag.api.bo.FlagTemplateBO;
import com.luoys.upgrade.flag.api.bo.TaskBO;
import com.luoys.upgrade.flag.api.bo.TaskTemplateBO;
import com.luoys.upgrade.flag.api.enums.TaskStatusEnum;
import com.luoys.upgrade.flag.dao.po.FlagTemplatePO;
import com.luoys.upgrade.flag.dao.po.TaskTemplatePO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformTaskTemplate {

    public static TaskTemplateBO transformPO2BO(TaskTemplatePO po) {
        if (po == null) {
            return null;
        }
        TaskTemplateBO bo = new TaskTemplateBO();
        bo.setDescription(po.getDescription());
        bo.setType(po.getType());
        bo.setPoint(po.getPoint());
        bo.setTaskTemplateId(po.getTaskTemplateId());
        bo.setFlagTemplateId(po.getFlagTemplateId());
        bo.setTaskType(po.getTaskType());
        bo.setTaskName(po.getTaskName());
        bo.setOwnerId(po.getOwnerId());
//        bo.setCycle(po.getCycle());
        // 周期转换成List格式
        String[] cycles = po.getCycle().split(",");
        bo.setCycleList(new ArrayList<>(Arrays.asList(cycles)));
        return bo;
    }

    public static List<TaskTemplateBO> transformPO2BO(List<TaskTemplatePO> po) {
        List<TaskTemplateBO> bo = new ArrayList<>();
        for (TaskTemplatePO item : po) {
            bo.add(transformPO2BO(item));
        }
        return bo;
    }


    public static TaskBO transformTaskTemplateBO2TaskBO(TaskTemplateBO taskTemplateBO) {
        if (taskTemplateBO == null) {
            return null;
        }
        TaskBO taskBO = new TaskBO();
        taskBO.setDescription(taskTemplateBO.getDescription());
        taskBO.setType(taskTemplateBO.getTaskType());
        taskBO.setPoint(taskTemplateBO.getPoint());
        taskBO.setTaskName(taskTemplateBO.getTaskName());
        taskBO.setCycleList(taskTemplateBO.getCycleList());
        taskBO.setStatus(TaskStatusEnum.PAUSE.getCode());
        return taskBO;
    }


    public static List<TaskBO> transformTaskTemplateBO2TaskBO(List<TaskTemplateBO> taskTemplateBOList) {
        List<TaskBO> taskBOList = new ArrayList<>();
        for (TaskTemplateBO item : taskTemplateBOList) {
            taskBOList.add(transformTaskTemplateBO2TaskBO(item));
        }
        return taskBOList;
    }

}
