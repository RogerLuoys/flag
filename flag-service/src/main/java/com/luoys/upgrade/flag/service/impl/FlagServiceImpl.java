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
    public Result<String> hello() {
        return Result.success("Hello, it is a big big flag! good luck.");
//        return "Hello, it is my flag!";
    }


    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public Result<String> hello2(@CookieValue("testCookie") String userId) {
        LOG.info("hello"+userId);
        return Result.success("Hello"+ userId +", it is a big big flag! good luck.");
//        return "Hello, it is my flag!";
    }

    @RequestMapping(value = "/queryAllFlags", method = RequestMethod.GET)
    public Result<List<FlagPO>> queryAllFlags() {
        return Result.success(flagManager.queryAllFlags());
    }

    @RequestMapping(value = "/queryFlags", method = RequestMethod.GET)
    public Result<List<FlagPO>> queryFlags(@RequestParam String userId) {
        return Result.success(flagManager.queryFlags(userId));
    }


    @RequestMapping(value = "/addFlag", method = RequestMethod.POST)
    public Result<String> addFlag(@RequestBody FlagBO flagBO) {
        LOG.info("=====>flag创建param：{}", JSON.toJSONString(flagBO));
        int result = flagManager.addFlag(flagBO);
        if (result == 1) {
            return Result.success("Flag创建成功");
        }else if (result == 0) {
            return Result.error("Flag创建失败");
        } else {
            return Result.error("执行异常");
        }

    }

}