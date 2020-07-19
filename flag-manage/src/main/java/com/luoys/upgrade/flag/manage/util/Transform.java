package com.luoys.upgrade.flag.manage.util;

import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.dao.po.FlagPO;

public class Transform {

    public static FlagPO TransformFlagBO2PO(FlagBO bo) {
        if (bo == null) {
            return null;
        }
        FlagPO po = new FlagPO();
        po.setFlagId(bo.getFlagId());
        po.setFlagName(bo.getFlagName());
        po.setDescription(bo.getDescription());
        po.setStatus(bo.getStatus());
        po.setPriority(bo.getPriority());
        po.setStartDate(bo.getStartDate());
        po.setEndDate(bo.getEndDate());
        po.setDeleted(bo.getDeleted());
        return po;
    }
}
