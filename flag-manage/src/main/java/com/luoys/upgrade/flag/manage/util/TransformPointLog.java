package com.luoys.upgrade.flag.manage.util;

import com.luoys.upgrade.flag.api.bo.PointBO;
import com.luoys.upgrade.flag.api.bo.PointLogBO;
import com.luoys.upgrade.flag.dao.po.PointLogPO;
import com.luoys.upgrade.flag.dao.po.PointPO;

public class TransformPointLog {

    public static PointLogBOBO transformPO2BO(PointLogPOPO po) {
        if (po == null) {
            return null;
        }
        PointLogPOBO bo = new PointBO();
        bo.setTotalPoint();
        return bo;
    }
}
