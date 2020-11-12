package com.luoys.upgrade.flag.service.impl;

import com.luoys.upgrade.flag.api.Result;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloTestImpl {


    @RequestMapping(value = "/t1", method = RequestMethod.GET)
    public Result<String> hello() {
        return Result.success("Hello, it is a big big flag! good luck.");
//        return "Hello, it is my flag!";
    }


    @RequestMapping(value = "/t2", method = RequestMethod.GET)
    public Result<String> hello2(@CookieValue("testCookie") String userId) {
//        LOG.info("hello"+userId);
        return Result.success("Hello"+ userId +", it is a big big flag! good luck.");
//        return "Hello, it is my flag!";
    }

}
