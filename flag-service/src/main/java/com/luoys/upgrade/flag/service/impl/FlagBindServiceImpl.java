package com.luoys.upgrade.flag.service.impl;

import com.alibaba.fastjson.JSON;
import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.FlagBindBO;
import com.luoys.upgrade.flag.api.bo.FlagQueryBO;
import com.luoys.upgrade.flag.api.bo.UserFlagBO;
import com.luoys.upgrade.flag.api.service.FlagBindService;
import com.luoys.upgrade.flag.manage.FlagBindManager;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// flag相关的列表查询都在这
@RestController
@RequestMapping(value = "/flagBind")
public class FlagBindServiceImpl implements FlagBindService {

    private static final Logger LOG  = LoggerFactory.getLogger(FlagBindServiceImpl.class);

    @Autowired
    private FlagBindManager flagBindManager;

    // 弃用
//    @Override
//    @RequestMapping(value = "/queryUserFlag", method = RequestMethod.GET)
//    public Result<List<UserFlagBO>> queryUserFlag(@RequestParam String userId,
//                                                  @RequestParam(required = false) Integer userType,
//                                                  @RequestParam(required = false) Integer flagType,
//                                                  @RequestParam(required = false) Integer flagStatus) {
//        if (userId == null) {
//            return Result.error("用户ID不能为空");
//        }
//        return null;
//    }

    @Override
    @RequestMapping(value = "/queryFlagList", method = RequestMethod.POST)
    public Result<List<UserFlagBO>> queryFlagList(@RequestBody FlagQueryBO flagQueryBO) {
        if (flagQueryBO.getOwnerId() == null && flagQueryBO.getWitnessId() == null) {
            return Result.error("所有者ID和见证人ID不能同时为空");
        }
        if (flagQueryBO.getPageIndex() == null) {
            flagQueryBO.setPageIndex(1);
        }
        LOG.info("====>查询入参：{}", JSON.toJSONString(flagQueryBO));
        return Result.success(flagBindManager.queryUserFlag(flagQueryBO));
    }

    @Override
    @RequestMapping(value = "/modifyWitness", method = RequestMethod.PUT)
    public Result<String> modifyWitness(@RequestBody FlagBindBO flagBindBO) {
        LOG.info("====>修改见证人：{}", JSON.toJSONString(flagBindBO));
        return Result.success(flagBindManager.modifyWitness(flagBindBO));
    }
}
