package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.dao.mapper.FlagBindMapper;
import com.luoys.upgrade.flag.dao.mapper.FlagMapper;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.manage.FlagManager;
import com.luoys.upgrade.flag.manage.util.Transform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlagManagerImpl implements FlagManager {

    private static Logger logger = LoggerFactory.getLogger(FlagManagerImpl.class);

    private final Integer DEFAULT_FLAGTYPE = 1;
    private final Integer DEFAULT_PRIORITY = 1;
    private final String DEFAULT_CREATOR = "1";
    private final Integer ADD_FLAG_SUCCESS = 1;

    @Autowired
    FlagMapper flagMapper;
    @Autowired
    FlagBindMapper flagBindMapper;

    @Override
    public List<FlagPO> queryAllFlags() {

        List<FlagPO> allFlags = flagMapper.listAllFlag();
        logger.info(allFlags.get(0).toString());
        return allFlags;
//        return null;
    }

    @Override
    public List<FlagBO> queryFlags(String userId) {
        logger.info("=====>查询flag列表userId：{}", userId);
        List<FlagPO> myFlags = flagMapper.listByUserId(userId);
        List<FlagBO> bo = Transform.TransformFlagPO2BO(myFlags);
        return bo;
    }

    @Override
    public FlagBO addFlag(FlagBO flagBO) {
        // 填入业务Id
        flagBO.setFlagId(NumberSender.createFlagId());
        if (flagBO.getFlagName() == null) {
            logger.error("=====>必填字段 flagName 为空");
            return null;
        }
        if (flagBO.getType() == null) {
            flagBO.setType(DEFAULT_FLAGTYPE);
        }
        if (flagBO.getPriority() == null) {
            flagBO.setPriority(DEFAULT_PRIORITY);
        }
        if (flagBO.getCreateId() == null) {
            flagBO.setCreateId(DEFAULT_CREATOR);
        }
        logger.info("=====>flag创建，并填充默认值：{}", flagBO);
        int result = flagMapper.insert(Transform.TransformFlagBO2PO(flagBO));
        if (result == 1) {
            return flagBO;
        } else {
            return null;
        }
    }

    @Override
    public int modifyFlag(FlagPO flagPO) {
        return 0;
    }
}