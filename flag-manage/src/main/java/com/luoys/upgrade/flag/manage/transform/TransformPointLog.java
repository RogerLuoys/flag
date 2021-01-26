package com.luoys.upgrade.flag.manage.transform;

import com.luoys.upgrade.flag.api.bo.PointLogBO;
import com.luoys.upgrade.flag.dao.po.PointLogPO;

import java.util.ArrayList;
import java.util.List;

public class TransformPointLog {

    public static PointLogBO transformPO2BO(PointLogPO po) {
        if (po == null) {
            return null;
        }
        PointLogBO bo = new PointLogBO();
        bo.setPointId(po.getPointId());
        bo.setPoint(po.getPoint());
        bo.setType(po.getType());
        bo.setComment(po.getComment());
        bo.setDescription(po.getDescription());
        bo.setRecordTime(po.getRecordTime());
        bo.setTaskDailyId(po.getTaskDailyId());
        return bo;
    }

    public static List<PointLogBO> transformPO2BO(List<PointLogPO> po) {
        List<PointLogBO> bo = new ArrayList<>();
        for (PointLogPO item : po) {
            bo.add(transformPO2BO(item));
        }
        return bo;
    }


    public static PointLogPO transformBO2PO(PointLogBO bo) {
        if (bo == null) {
            return null;
        }
        PointLogPO po = new PointLogPO();
        po.setPoint(bo.getPoint());
        po.setDescription(bo.getDescription());
        po.setComment(bo.getComment());
        po.setPointId(bo.getPointId());
        po.setType(bo.getType());
        po.setRecordTime(bo.getRecordTime());
        po.setTaskDailyId(bo.getTaskDailyId());
        return po;
    }

}
