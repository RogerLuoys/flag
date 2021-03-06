package com.luoys.upgrade.flag.manager.impl;

import com.luoys.upgrade.flag.api.bo.PointBO;
import com.luoys.upgrade.flag.api.bo.PointLogBO;
import com.luoys.upgrade.flag.dao.mapper.PointLogMapper;
import com.luoys.upgrade.flag.dao.mapper.PointMapper;
import com.luoys.upgrade.flag.dao.po.PointLogPO;
import com.luoys.upgrade.flag.dao.po.PointPO;
import com.luoys.upgrade.flag.manager.PointManager;
import com.luoys.upgrade.flag.manager.transform.TransformPoint;
import com.luoys.upgrade.flag.manager.transform.TransformPointLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

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

    @Override
    public List<PointLogBO> queryPointLog(String pointId, Integer type) {
        if (pointId == null) {
            LOG.error("----》查询积分使用列表时，pointId不能为空");
            return null;
        }
        List<PointLogPO> pointLogPOList = pointLogMapper.listPointLog(pointId, type, null);
        return TransformPointLog.transformPO2BO(pointLogPOList);
    }

    @Override
    public String newPointLog(PointLogBO pointLogBO) {
        if (pointLogBO == null) {
            LOG.error("----》新增积分记录时，pointLogBO不能为空");
            return null;
        }
        if (pointLogBO.getPointId() == null) {
            LOG.error("----》新增积分记录时，pointId不能为空");
            return null;
        }
        if (pointLogBO.getRecordTime() == null) {
            pointLogBO.setRecordTime(new Date());
        }
        PointLogPO pointLogPO = TransformPointLog.transformBO2PO(pointLogBO);
        int isPointLogCreated = pointLogMapper.insert(pointLogPO);
        if (isPointLogCreated != 1) {
            LOG.error("----》新增积分记录时失败");
            return null;
        }
        int usablePoint = pointMapper.selectByPointId(pointLogBO.getPointId()).getUsablePoint();
        int isPointIncrease = pointMapper.updatePointByPointId(
                usablePoint + pointLogBO.getPoint(), null, pointLogBO.getPointId());
        return isPointIncrease == 1 ? pointLogPO.getPoint().toString() : null;
    }

}
