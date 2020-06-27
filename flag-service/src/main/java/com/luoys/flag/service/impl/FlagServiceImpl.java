package com.luoys.flag.service.impl;

import com.luoys.flag.dao.po.FlagPO;
import com.luoys.flag.manage.FlagManager;
import com.luoys.flag.service.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flag")
public class FlagServiceImpl {
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

}
