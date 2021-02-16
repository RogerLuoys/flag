package com.luoys.upgrade.flag.service.impl;

import com.alibaba.fastjson.JSON;
import com.luoys.upgrade.flag.api.PageListJO;
import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.*;
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

    @Override
    @RequestMapping(value = "/queryFlagList", method = RequestMethod.POST)
    public Result<PageListJO<UserFlagBO>> queryFlagList(@RequestBody FlagQueryBO flagQueryBO) {
        LOG.info("====》按用户查询flag列表开始：{}", JSON.toJSONString(flagQueryBO));
        if (flagQueryBO.getOwnerId() == null && flagQueryBO.getWitnessId() == null) {
            return Result.error("---->所有者ID和见证人ID不能同时为空");
        }
        if (flagQueryBO.getPageIndex() == null) {
            flagQueryBO.setPageIndex(1);
        }
        PageListJO<UserFlagBO> pageListJO = new PageListJO<>();
        pageListJO.setList(flagBindManager.queryUserFlag(flagQueryBO));
        pageListJO.setTotal(flagBindManager.countUserFlag(flagQueryBO));
        return Result.ifSuccess(pageListJO);
    }

    @Override
    @RequestMapping(value = "/queryReportList", method = RequestMethod.GET)
    public Result<List<UserReportBO>> queryReportList(
            @RequestParam("ownerId") String ownerId, @RequestParam(value = "status", required = false) Integer status) {
        LOG.info("====》按用户查询报告开始：ownerId={}", ownerId);
        if (ownerId == null || ownerId == "") {
            return Result.error("----》所有者不能为空");
        }
        return Result.ifSuccess(flagBindManager.queryUserReport(ownerId, status));
    }

    @Override
    @RequestMapping(value = "/modifyWitness", method = RequestMethod.PUT)
    public Result<String> modifyWitness(@RequestBody FlagBindBO flagBindBO) {
        LOG.info("====》修改见证人开始：{}", JSON.toJSONString(flagBindBO));
        return Result.ifSuccess(flagBindManager.modifyWitness(flagBindBO));
    }

    @Override
    @RequestMapping(value = "/queryTaskDailyList", method = RequestMethod.POST)
    public Result<List<TaskDailyBO>> queryTaskDailyList(@RequestBody TaskDailyQueryBO taskDailyQueryBO) {
        LOG.info("====》按用户查询每日任务列表开始：{}", JSON.toJSONString(taskDailyQueryBO));
        return Result.ifSuccess(flagBindManager.queryUserTaskDaily(taskDailyQueryBO));
    }
}
