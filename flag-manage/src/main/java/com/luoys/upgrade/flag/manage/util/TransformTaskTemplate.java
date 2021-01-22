package com.luoys.upgrade.flag.manage.util;

import com.luoys.upgrade.flag.api.bo.FlagTemplateBO;
import com.luoys.upgrade.flag.api.bo.TaskTemplateBO;
import com.luoys.upgrade.flag.dao.po.FlagTemplatePO;
import com.luoys.upgrade.flag.dao.po.TaskTemplatePO;

import java.util.ArrayList;
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
        bo.setCycle(po.getCycle());
        return bo;
    }

    public static List<TaskTemplateBO> transformPO2BO(List<TaskTemplatePO> po) {
        List<TaskTemplateBO> bo = new ArrayList<>();
        for (TaskTemplatePO item : po) {
            bo.add(transformPO2BO(item));
        }
        return bo;
    }
}
