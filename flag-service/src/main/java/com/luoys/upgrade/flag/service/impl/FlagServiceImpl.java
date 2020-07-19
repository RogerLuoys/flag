package com.luoys.upgrade.flag.service.impl;

import com.alibaba.fastjson.JSON;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.manage.FlagManager;
import com.luoys.upgrade.flag.api.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping("/flag")
public class FlagServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(FlagServiceImpl.class);

    @Autowired
    FlagManager flagManager;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Result<String> hello() {
        return Result.success("Hello, it is a big big flag! good luck.");
//        return "Hello, it is my flag!";
    }

    @RequestMapping(value = "/allFlag", method = RequestMethod.GET)
    public Result<List<FlagPO>> allFlag() {
        return Result.success(flagManager.page());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Result<FlagPO> insertFlag(@RequestBody FlagBO flagBO) {
        LOG.info("=====>flag创建param：{}", JSON.toJSONString(flagBO));
        return Result.success(flagManager.insert(flagBO));
    }

}