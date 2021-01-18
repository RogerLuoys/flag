package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.bo.PointBO;
import com.luoys.upgrade.flag.dao.mapper.PointLogMapper;
import com.luoys.upgrade.flag.dao.mapper.PointMapper;
import com.luoys.upgrade.flag.dao.po.PointPO;
import com.luoys.upgrade.flag.manage.PointManager;
import com.luoys.upgrade.flag.manage.util.TransformPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PointManagerImpl implements PointManager {

    private static final Logger LOG = LoggerFactory.getLogger(PointManagerImpl.class);

    @Autowired
    private PointMapper pointMapper;

    @Autowired
    private PointLogMapper pointLogMapper;

    @Override
    public PointBO queryPointByOwnerId(String ownerId) {
        if (ownerId == null) {
            LOG.error("----》查询总积分时，ownerId不能为空");
            return null;
        }
        PointPO pointPO = pointMapper.selectByOwnerId(ownerId);
        return TransformPoint.transformPO2BO(pointPO);
    }

}
