package com.luoys.upgrade.flag.service.impl;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.UserFlagBO;
import com.luoys.upgrade.flag.api.service.FlagBindService;
import com.luoys.upgrade.flag.manage.FlagBindManager;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/flagBind")
public class FlagBindServiceImpl implements FlagBindService {

    @Autowired
    FlagBindManager flagBindManager;

    @Override
    @RequestMapping(value = "/queryUserFlag", method = RequestMethod.GET)
    public Result<List<UserFlagBO>> queryUserFlag(@RequestParam String userId,
                                                  @RequestParam(required = false) Integer userType,
                                                  @RequestParam(required = false) Integer flagType,
                                                  @RequestParam(required = false) Integer flagStatus) {
        if (userId == null) {
            return Result.error("用户ID不能为空");
        }
        return Result.success(flagBindManager.queryUserFlag(userId, userType, flagType, flagStatus));
    }
}
