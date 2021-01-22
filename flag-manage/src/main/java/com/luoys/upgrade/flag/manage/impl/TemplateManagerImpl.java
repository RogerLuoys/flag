package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.bo.FlagTemplateBO;
import com.luoys.upgrade.flag.api.bo.TaskTemplateBO;
import com.luoys.upgrade.flag.dao.mapper.FlagTemplateMapper;
import com.luoys.upgrade.flag.dao.mapper.TaskTemplateMapper;
import com.luoys.upgrade.flag.dao.po.FlagTemplatePO;
import com.luoys.upgrade.flag.dao.po.TaskTemplatePO;
import com.luoys.upgrade.flag.manage.TaskManager;
import com.luoys.upgrade.flag.manage.TemplateManager;
import com.luoys.upgrade.flag.manage.util.TransformFlagTemplate;
import com.luoys.upgrade.flag.manage.util.TransformTaskTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemplateManagerImpl implements TemplateManager {

    private static Logger LOG = LoggerFactory.getLogger(TemplateManagerImpl.class);

    @Autowired
    private FlagTemplateMapper flagTemplateMapper;

    @Autowired
    private TaskTemplateMapper taskTemplateMapper;

    @Override
    public FlagTemplateBO queryFlagTemplateByFlagTemplateId(String flagTemplateId) {
        if (flagTemplateId == null) {
            LOG.error("----》查询flag模板时，flagTemplateId不能为空");
            return null;
        }
        FlagTemplatePO flagTemplatePO = flagTemplateMapper.selectByFlagTemplateId(flagTemplateId);
        FlagTemplateBO flagTemplateBO = TransformFlagTemplate.transformPO2BO(flagTemplatePO);
        // 查询flag模板关联的任务模板列表
        List<TaskTemplatePO> taskTemplatePOList = taskTemplateMapper.listByFlagTemplateId(flagTemplateId);
        if (taskTemplatePOList != null && taskTemplatePOList.size() != 0) {
            flagTemplateBO.setTaskTemplateList(TransformTaskTemplate.transformPO2BO(taskTemplatePOList));
        }
        return flagTemplateBO;
    }

    @Override
    public List<FlagTemplateBO> queryFlagTemplateList(String ownerId, String flagName) {
        if (ownerId == null) {
            LOG.error("----》查询flag模板时，ownerId不能为空");
            return null;
        }
        List<FlagTemplatePO> flagTemplatePOList = flagTemplateMapper.listFlagTemplate(ownerId, flagName, null);
        return TransformFlagTemplate.transformPO2BO(flagTemplatePOList);
    }

    @Override
    public List<TaskTemplateBO> queryTaskTemplateList(String flagTemplateId) {
        if (flagTemplateId == null) {
            LOG.error("----》查询任务模板时，flagTemplateId不能为空");
            return null;
        }
        List<TaskTemplatePO> taskTemplatePOList = taskTemplateMapper.listByFlagTemplateId(flagTemplateId);
        return TransformTaskTemplate.transformPO2BO(taskTemplatePOList);
    }

}
