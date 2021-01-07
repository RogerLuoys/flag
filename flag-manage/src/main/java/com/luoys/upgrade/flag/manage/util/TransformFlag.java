package com.luoys.upgrade.flag.manage.util;

import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.dao.po.FlagPO;

import java.util.ArrayList;
import java.util.List;

public class TransformFlag {

    public static FlagPO TransformBO2PO(FlagBO bo) {
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
        po.setStatus(bo.getStatus());
        po.setPriority(bo.getPriority());
        po.setStartTime(bo.getStartDate());
        po.setEndTime(bo.getEndDate());
        po.setCreatorId(bo.getCreateId());
        return po;
    }

    public static FlagBO TransformPO2BO(FlagPO po) {
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
        bo.setStatus(po.getStatus());
        bo.setPriority(po.getPriority());
        bo.setStartDate(po.getStartTime());
        bo.setEndDate(po.getEndTime());
        bo.setCreateId(po.getCreatorId());
        return bo;
    }

    public static List<FlagBO> TransformPO2BO(List<FlagPO> po) {
        List<FlagBO> bo = new ArrayList<>();
        for (FlagPO item : po) {
            bo.add(TransformPO2BO(item));
        }
        return bo;
    }

}
