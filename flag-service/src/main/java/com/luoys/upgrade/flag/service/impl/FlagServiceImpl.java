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
    FlagManager flagManager;
    @Autowired
    FlagBindManager flagBindManager;

//    @RequestMapping(value = "/queryAllFlags", method = RequestMethod.GET)
//    public Result<List<FlagPO>> queryAllFlags() {
//        return Result.success(flagManager.queryAllFlags());
//    }
//
//    @RequestMapping(value = "/queryFlags", method = RequestMethod.GET)
//    public Result<List<FlagPO>> queryFlags(@RequestParam String userId) {
//        return Result.success(flagManager.queryFlags(userId));
//    }

    @Override
    @RequestMapping(value = "/queryFlagDetail", method = RequestMethod.GET)
    public Result<FlagBO> queryFlagDetail(@RequestParam String flagId) {
        return Result.success(flagManager.queryFlagByFlagId(flagId));
    }

    @Override
    @RequestMapping(value = "/addFlag", method = RequestMethod.POST)
    public Result<String> addFlag(@RequestBody FlagBO flagBO) {
        LOG.info("=====>flag创建param：{}", JSON.toJSONString(flagBO));
        FlagBO resultBO = flagManager.addFlag(flagBO);

        return Result.success("创建成功：" + resultBO.getFlagId());

    }

}