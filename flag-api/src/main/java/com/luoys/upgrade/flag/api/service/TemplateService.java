package com.luoys.upgrade.flag.api.service;

import com.luoys.common.api.Result;
import com.luoys.upgrade.flag.api.bo.FlagTemplateBO;

import java.util.List;

public interface TemplateService {

    Result<FlagTemplateBO> queryFlagTemplateDetail(String flagTemplateId);

    Result<List<FlagTemplateBO>> queryFlagTemplateList(String ownerId, String flagName);

    Result<String> useFlagTemplate(FlagTemplateBO flagTemplateBO);
}
