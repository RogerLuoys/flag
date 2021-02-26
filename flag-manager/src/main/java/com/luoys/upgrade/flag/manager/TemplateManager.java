package com.luoys.upgrade.flag.manager;

import com.luoys.upgrade.flag.api.bo.FlagTemplateBO;
import com.luoys.upgrade.flag.api.bo.TaskTemplateBO;

import java.util.List;

public interface TemplateManager {

    FlagTemplateBO queryFlagTemplateByFlagTemplateId(String flagTemplateId);

    List<FlagTemplateBO> queryFlagTemplateList(String ownerId, String flagName);

    List<TaskTemplateBO> queryTaskTemplateList(String flagTemplateId);
}