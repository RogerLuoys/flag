package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.FlagBindBO;
import com.luoys.upgrade.flag.api.bo.FlagQueryBO;
import com.luoys.upgrade.flag.api.bo.UserFlagBO;
import com.luoys.upgrade.flag.dao.mapper.FlagBindMapper;
import com.luoys.upgrade.flag.dao.po.UserFlagPO;
import com.luoys.upgrade.flag.manage.FlagBindManager;
import com.luoys.upgrade.flag.manage.util.TransformFlagBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlagBindManagerImpl implements FlagBindManager {

    private static Logger logger = LoggerFactory.getLogger(FlagBindManager.class);


    @Autowired
    FlagBindMapper flagBindMapper;

    @Override
    public FlagBindBO addFlagBind(FlagBindBO flagBindBO) {
        logger.info("=====>添加 flag 绑定关系");
        if (flagBindBO.getFlagId() == null) {
            logger.error("=====>必填字段 flagId 不能为空");
            return null;
        }
        if (flagBindBO.getOwnerId() == null) {
            logger.error("=====>必填字段 userId 不能为空");
        }
        if (flagBindBO.getStatus() == null) {
            flagBindBO.setStatus(1);
        }
        if (flagBindBO.getType() == null) {
            flagBindBO.setType(1);
        }
        flagBindMapper.insert(TransformFlagBind.TransformFlagBindBO2PO(flagBindBO));
        return flagBindBO;
    }

    @Override
    public List<UserFlagBO> queryUserFlag(FlagQueryBO flagQueryBO) {
        logger.info("====>按用户查询flag列表");
        List<UserFlagPO> pos = flagBindMapper.listOurFlags(
                flagQueryBO.getOwnerId(), flagQueryBO.getWitnessId(), flagQueryBO.getType(),
                flagQueryBO.getStatus(), flagQueryBO.getFlagName(), flagQueryBO.getPageIndex());
        return TransformFlagBind.TransformUserFlagPO2BO(pos);
    }
}
