package com.luoys.upgrade.flag.service.impl;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.PointBO;
import com.luoys.upgrade.flag.api.service.PointService;
import com.luoys.upgrade.flag.manage.PointManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/point")
public class PointServiceImpl implements PointService {

    private static final Logger LOG = LoggerFactory.getLogger(PointServiceImpl.class);

    @Autowired
    private PointManager pointManager;

    @Override
    @RequestMapping(value = "/queryPointSummary", method = RequestMethod.GET)
    public Result<PointBO> queryPointSummary(@RequestParam("ownerId") String ownerId) {
        LOG.info("====》查询用户总积分开始，ownerId={}", ownerId);
        return Result.success(pointManager.queryPointByOwnerId(ownerId));
    }
}
