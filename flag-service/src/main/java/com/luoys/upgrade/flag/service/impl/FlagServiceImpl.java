package com.luoys.upgrade.flag.service.impl;

import com.alibaba.fastjson.JSON;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.api.bo.FlagBindBO;
import com.luoys.upgrade.flag.api.service.FlagService;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.manage.FlagBindManager;
import com.luoys.upgrade.flag.manage.FlagManager;
import com.luoys.upgrade.flag.api.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flag")
public class FlagServiceImpl implements FlagService {
    private static final Logger LOG = LoggerFactory.getLogger(FlagServiceImpl.class);

    @Autowired
    private FlagManager flagManager;
    @Autowired
    private FlagBindManager flagBindManager;

    @Override
    @RequestMapping(value = "/queryDetail", method = RequestMethod.GET)
    public Result<FlagBO> queryFlagDetail(@RequestParam String flagId) {
        return Result.success(flagManager.queryFlagByFlagId(flagId));
    }

    @Override
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Result<String> newFlag(@RequestBody FlagBO flagBO) {
        LOG.info("=====>flag创建param：{}", JSON.toJSONString(flagBO));
        FlagBO resultBO = flagManager.newFlag(flagBO);
        return Result.success("创建成功：" + resultBO.getFlagId());
    }

    @Override
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public Result<String> removeFlag(@RequestParam String flagId) {
        LOG.info("====>删除flag，flagId：{}", flagId);
//        if (flagId == null) {
//            return Result.error("flagId不能为空");
//        }
        return Result.success(flagManager.removeByFlagId(flagId));
    }

    @Override
    @RequestMapping(value = "/modifyStatus", method = RequestMethod.PUT)
    public Result<String> modifyFlagStatus(@RequestParam("flagId") String flagId, @RequestParam("status") Integer status) {
        LOG.info("====>修改flag状态，flagId：{}，status：{}", flagId, status);
        return Result.success(flagManager.modifyStatusByFlagId(flagId, status));
    }

    @Override
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public Result<String> modifyFlag(@RequestBody FlagBO flagBO) {
        LOG.info("====>修改flag状态：{}", JSON.toJSONString(flagBO));
        return Result.success(flagManager.modifyFlag(flagBO));
    }

}