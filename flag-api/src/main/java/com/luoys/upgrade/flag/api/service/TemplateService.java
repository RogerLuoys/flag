package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.FlagTemplateBO;
import com.luoys.upgrade.flag.api.bo.TaskTemplateBO;

import java.util.List;

public interface TemplateService {

    Result<FlagTemplateBO> queryFlagTemplateDetail(String flagTemplateId);

    Result<List<FlagTemplateBO>> queryFlagTemplateList(String ownerId, String flagName);

    Result<String> useFlagTemplate(FlagTemplateBO flagTemplateBO);
}
