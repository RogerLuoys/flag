package com.luoys.upgrade.flag.service.impl;

import com.alibaba.fastjson.JSON;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.manage.FlagManager;
import com.luoys.upgrade.flag.api.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flag")
public class FlagServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(FlagServiceImpl.class);

    @Autowired
    FlagManager flagManager;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Result<String> hello(@CookieValue("testCookie") String userID) {
        LOG.info("hello"+userID);
        return Result.success("Hello"+ userID +", it is a big big flag! good luck.");
//        return "Hello, it is my flag!";
    }

    @RequestMapping(value = "/allFlag", method = RequestMethod.GET)
    public Result<List<FlagPO>> allFlag() {
        return Result.success(flagManager.pageAll());
    }

    @RequestMapping(value = "/Flag", method = RequestMethod.GET)
    public Result<List<FlagPO>> listFlag(String UserID) {
        return Result.success(flagManager.page(UserID));
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Result<FlagPO> insertFlag(@RequestBody FlagBO flagBO) {
        LOG.info("=====>flag创建param：{}", JSON.toJSONString(flagBO));
        return Result.success(flagManager.insert(flagBO));
    }

}