package com.luoys.upgrade.flag.service.impl;

import com.alibaba.fastjson.JSON;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.api.service.FlagService;
import com.luoys.upgrade.flag.manage.FlagBindManager;
import com.luoys.upgrade.flag.manage.FlagManager;
import com.luoys.upgrade.flag.api.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flag")
public class FlagServiceImpl implements FlagService {
    private static final Logger LOG = LoggerFactory.getLogger(FlagServiceImpl.class);

    @Autowired
    private FlagManager flagManager;
    @Autowired
    private FlagBindManager flagBindManager;

    @Override
    @RequestMapping(value = "/queryFlagDetail", method = RequestMethod.GET)
    public Result<FlagBO> queryFlagDetail(@RequestParam("flagId") String flagId) {
        LOG.info("=====》查询flag详情开始：flagId={}", flagId);
        return Result.ifSuccess(flagManager.queryFlagByFlagId(flagId));
    }

    @Override
    @RequestMapping(value = "/newFlag", method = RequestMethod.POST)
    public Result<String> newFlag(@RequestBody FlagBO flagBO) {
        LOG.info("=====》创建flag开始：{}", JSON.toJSONString(flagBO));
        return Result.ifSuccess(flagManager.newFlag(flagBO));
    }

    @Override
    @RequestMapping(value = "/removeFlag", method = RequestMethod.DELETE)
    public Result<String> removeFlag(@RequestParam("flagId") String flagId) {
        LOG.info("====》删除flag开始：flagId={}", flagId);
        return Result.ifSuccess(flagManager.removeByFlagId(flagId));
    }

    @Override
    @RequestMapping(value = "/modifyFlagStatus", method = RequestMethod.PUT)
    public Result<String> modifyFlagStatus(@RequestParam("flagId") String flagId, @RequestParam("status") Integer status) {
        LOG.info("====》修改flag状态开始：flagId={}，status={}", flagId, status);
        return Result.ifSuccess(flagManager.modifyStatusByFlagId(flagId, status));
    }

    @Override
    @RequestMapping(value = "/modifyFlagBasic", method = RequestMethod.PUT)
    public Result<String> modifyFlagBasic(@RequestBody FlagBO flagBO) {
        LOG.info("====》修改flag基本信息开始：{}", JSON.toJSONString(flagBO));
        return Result.ifSuccess(flagManager.modifyFlagBasic(flagBO));
    }

}