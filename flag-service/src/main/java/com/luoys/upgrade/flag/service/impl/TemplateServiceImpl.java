package com.luoys.upgrade.flag.service.impl;

import com.luoys.common.api.Result;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.api.bo.FlagTemplateBO;
import com.luoys.upgrade.flag.api.service.TemplateService;
import com.luoys.upgrade.flag.manager.FlagManager;
import com.luoys.upgrade.flag.manager.TemplateManager;
import com.luoys.upgrade.flag.manager.transform.TransformFlagTemplate;
import com.luoys.upgrade.flag.manager.transform.TransformTaskTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/template")
public class TemplateServiceImpl implements TemplateService {

    private static final Logger LOG = LoggerFactory.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateManager templateManager;

    @Autowired
    private FlagManager flagManager;

    @Override
    @RequestMapping(value = "/queryFlagTemplateDetail", method = RequestMethod.GET)
    public Result<FlagTemplateBO> queryFlagTemplateDetail(@RequestParam("flagTemplateId") String flagTemplateId) {
        LOG.info("====》查询模板详情开始：flagTemplateId={}", flagTemplateId);
        return Result.ifSuccess(templateManager.queryFlagTemplateByFlagTemplateId(flagTemplateId));
    }

    @Override
    @RequestMapping(value = "/queryFlagTemplateList", method = RequestMethod.GET)
    public Result<List<FlagTemplateBO>> queryFlagTemplateList(@RequestParam("ownerId") String ownerId,
                                                              @RequestParam(value = "flagName", required = false) String flagName){
        LOG.info("====》查询模板列表开始：ownerId={}, flagName={}", ownerId, flagName);
        return Result.ifSuccess(templateManager.queryFlagTemplateList(ownerId, flagName));
    }

    @Override
    @RequestMapping(value = "/useFlagTemplate", method = RequestMethod.POST)
    public Result<String> useFlagTemplate(@RequestBody FlagTemplateBO flagTemplateBO) {
        LOG.info("====》使用模板开始：{}", flagTemplateBO);
        if (flagTemplateBO.getOwnerId() == null) {
            Result.error("ownerId不能为空");
        } else if (flagTemplateBO.getFlagName() == null) {
            Result.error("flagName不能为空");
        }
        FlagBO flagBO = TransformFlagTemplate.transformTemplateBO2FlagBO(flagTemplateBO);
        if (flagTemplateBO.getTaskTemplateList() != null) {
            flagBO.setTaskList(TransformTaskTemplate.transformTaskTemplateBO2TaskBO(flagTemplateBO.getTaskTemplateList()));
        }
        LOG.info("====》模板转换成功，新建flag：{}", flagBO);
        return Result.ifSuccess(flagManager.newFlag(flagBO));
    }

}
