package com.luoys.upgrade.flag.service.impl;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.FlagTemplateBO;
import com.luoys.upgrade.flag.api.bo.TaskTemplateBO;
import com.luoys.upgrade.flag.api.service.TemplateService;
import com.luoys.upgrade.flag.manage.TemplateManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/template")
public class TemplateServiceImpl implements TemplateService {

    private static final Logger LOG = LoggerFactory.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateManager templateManager;


    @Override
    @RequestMapping(value = "/queryFlagTemplateDetail", method = RequestMethod.GET)
    public Result<FlagTemplateBO> queryFlagTemplateDetail(@RequestParam("flagTemplateId") String flagTemplateId) {
        LOG.info("====>查询flag模板详情开始：flagTemplateId={}", flagTemplateId);
        return Result.success(templateManager.queryFlagTemplateByFlagTemplateId(flagTemplateId));
    }

    @Override
    @RequestMapping(value = "/queryFlagTemplateList", method = RequestMethod.GET)
    public Result<List<FlagTemplateBO>> queryFlagTemplateList(@RequestParam("ownerId") String ownerId,
                                                              @RequestParam(value = "flagName", required = false) String flagName){
        LOG.info("====>查询flag模板列表开始：ownerId={}, flagName={}", ownerId, flagName);
        return Result.success(templateManager.queryFlagTemplateList(ownerId, flagName));
    }

}
