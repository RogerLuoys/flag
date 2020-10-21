package com.luoys.upgrade.flag.manage.util;

import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.dao.po.FlagPO;

import java.util.List;

public class Transform {

    public static FlagPO TransformFlagBO2PO(FlagBO bo) {
        if (bo == null) {
            return null;
        }
        FlagPO po = new FlagPO();
        po.setFlagId(bo.getFlagId());
        po.setFlagName(bo.getFlagName());
        po.setDescription(bo.getDescription());
        po.setExpected(bo.getExpected());
        po.setActual(bo.getActual());
        po.setType(bo.getType());
        po.setPriority(bo.getPriority());
        po.setStartDate(bo.getStartDate());
        po.setEndDate(bo.getEndDate());
        po.setCreatorId(bo.getCreateId());
        return po;
    }

    public static FlagBO TransformFlagPO2BO(FlagPO po) {
        if (po == null) {
            return null;
        }
        FlagBO bo = new FlagBO();
        bo.setFlagId(po.getFlagId());
        bo.setFlagName(po.getFlagName());
        bo.setDescription(po.getDescription());
        bo.setExpected(po.getExpected());
        bo.setActual(po.getActual());
        bo.setType(po.getType());
        bo.setPriority(po.getPriority());
        bo.setStartDate(po.getStartDate());
        bo.setEndDate(po.getEndDate());
        bo.setCreateId(po.getCreatorId());
        return bo;
    }

    public static List<FlagBO> TransformFlagPO2BO(List<FlagPO> po) {
//        for (FlagPO item in po) {
//
//        }
        return null;
    }
}
