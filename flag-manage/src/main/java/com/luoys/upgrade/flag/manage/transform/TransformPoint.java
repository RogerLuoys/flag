package com.luoys.upgrade.flag.manage.transform;

import com.luoys.upgrade.flag.api.bo.PointBO;
import com.luoys.upgrade.flag.dao.po.PointPO;

public class TransformPoint {

    public static PointBO transformPO2BO(PointPO po) {
        if (po == null) {
            return null;
        }
        PointBO bo = new PointBO();
        bo.setStatus(po.getStatus());
        bo.setType(po.getType());
        bo.setOwnerId(po.getOwnerId());
        bo.setExpendPoint(po.getExpendPoint());
        bo.setPointId(po.getPointId());
        bo.setUsablePoint(po.getUsablePoint());
        bo.setTotalPoint(po.getExpendPoint() + po.getUsablePoint());
        return bo;
    }
}
