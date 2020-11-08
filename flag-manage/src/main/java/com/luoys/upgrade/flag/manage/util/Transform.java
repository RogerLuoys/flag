package com.luoys.upgrade.flag.manage.util;

import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.api.bo.FlagBindBO;
import com.luoys.upgrade.flag.api.bo.UserFlagBO;
import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.dao.po.UserFlagPO;

import java.util.ArrayList;
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
        List<FlagBO> bo = new ArrayList<>();
        for (FlagPO item : po) {
            bo.add(TransformFlagPO2BO(item));
        }
        return bo;
    }

    public static FlagBindPO TransformFlagBindBO2PO(FlagBindBO bo) {
        if (bo == null) {
            return null;
        }
        FlagBindPO po = new FlagBindPO();
        po.setFlagId(bo.getFlagId());
        po.setUserId(bo.getUserId());
        po.setStatus(bo.getStatus());
        po.setType(bo.getType());
        return po;
    }

    public static UserFlagBO TransformUserFlagPO2BO(UserFlagPO po) {
        if (po == null) {
            return null;
        }
        UserFlagBO bo = new UserFlagBO();
        bo.setActual(po.getActual());
        bo.setCreatorId(po.getCreatorId());
        bo.setDescription(po.getDescription());
        bo.setEndDate(po.getEndDate());
        bo.setExpected(po.getExpected());
        bo.setFlagId(po.getFlagId());
        bo.setFlagName(po.getFlagName());
        bo.setType(po.getFlagType());
        bo.setPriority(po.getPriority());
        bo.setStartDate(po.getStartDate());
        bo.setStatus(po.getStatus());
        bo.setUserId(po.getUserId());
        bo.setUserName(po.getUserName());
        bo.setUserType(po.getUserType());
        bo.setWitnessName(po.getWitnessName());
        bo.setWitnessId(po.getWitnessId());
        return bo;
    }

    public static List<UserFlagBO> TransformUserFlagPO2BO(List<UserFlagPO> po) {
        List<UserFlagBO> bo = new ArrayList<>();
        for (UserFlagPO item : po) {
            bo.add(TransformUserFlagPO2BO(item));
        }
        return bo;
    }
}
