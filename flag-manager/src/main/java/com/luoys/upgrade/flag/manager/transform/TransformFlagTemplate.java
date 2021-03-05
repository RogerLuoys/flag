package com.luoys.upgrade.flag.manager.transform;

import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.api.bo.FlagTemplateBO;
import com.luoys.upgrade.flag.api.bo.PointLogBO;
import com.luoys.upgrade.flag.api.enums.FlagStatusEnum;
import com.luoys.upgrade.flag.dao.po.FlagTemplatePO;
import com.luoys.upgrade.flag.dao.po.PointLogPO;

import java.util.ArrayList;
import java.util.List;

public class TransformFlagTemplate {


    public static FlagTemplateBO transformPO2BO(FlagTemplatePO po) {
        if (po == null) {
            return null;
        }
        FlagTemplateBO bo = new FlagTemplateBO();
        bo.setDescription(po.getDescription());
        bo.setType(po.getType());
        bo.setFlagTemplateId(po.getFlagTemplateId());
        bo.setStatus(po.getStatus());
        bo.setOwnerId(po.getOwnerId());
        bo.setFlagName(po.getFlagName());
        bo.setFlagType(po.getFlagType());
        bo.setExpected(po.getExpected());
        bo.setUseCount(po.getUseCount());
        return bo;
    }

    public static List<FlagTemplateBO> transformPO2BO(List<FlagTemplatePO> po) {
        List<FlagTemplateBO> bo = new ArrayList<>();
        for (FlagTemplatePO item : po) {
            bo.add(transformPO2BO(item));
        }
        return bo;
    }


    public static FlagBO transformTemplateBO2FlagBO(FlagTemplateBO flagTemplateBO) {
        if (flagTemplateBO == null) {
            return null;
        }
        FlagBO flagBO = new FlagBO();
        flagBO.setOwnerId(flagTemplateBO.getOwnerId());
        flagBO.setFlagName(flagTemplateBO.getFlagName());
        flagBO.setExpected(flagTemplateBO.getExpected());
        flagBO.setDescription(flagTemplateBO.getDescription());
        flagBO.setType(flagTemplateBO.getFlagType());
        flagBO.setStatus(FlagStatusEnum.NOT_START.getCode());
        return flagBO;
    }

}
