package com.luoys.upgrade.flag.service.impl;

import com.luoys.common.api.Result;
import com.luoys.upgrade.flag.api.bo.PointBO;
import com.luoys.upgrade.flag.api.bo.PointLogBO;
import com.luoys.upgrade.flag.api.service.PointService;
import com.luoys.upgrade.flag.manager.PointManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/point")
public class PointServiceImpl implements PointService {

    private static final Logger LOG = LoggerFactory.getLogger(PointServiceImpl.class);

    @Autowired
    private PointManager pointManager;

    @Override
    @RequestMapping(value = "/queryPointSummary", method = RequestMethod.GET)
    public Result<PointBO> queryPointSummary(@RequestParam("ownerId") String ownerId) {
        LOG.info("====》查询用户总积分开始：ownerId={}", ownerId);
        return Result.ifSuccess(pointManager.queryPointByOwnerId(ownerId));
    }

    @Override
    @RequestMapping(value = "/queryPointLogList", method = RequestMethod.GET)
    public Result<List<PointLogBO>> queryPointLogList(@RequestParam("pointId") String pointId, @RequestParam("type") Integer type) {
        LOG.info("====》查询用户积分记录列表开始：pointId={}， type={}", pointId, type);
        return Result.ifSuccess(pointManager.queryPointLog(pointId, type));
    }


    @Override
    @RequestMapping(value = "/newPointLog", method = RequestMethod.POST)
    public Result<String> newPointLog(@RequestBody PointLogBO pointLogBO) {
        LOG.info("====》新增用户积分记录开始：{}", pointLogBO);
        return Result.ifSuccess(pointManager.newPointLog(pointLogBO));
    }
}
