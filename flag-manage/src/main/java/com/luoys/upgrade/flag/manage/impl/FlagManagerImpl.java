package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.FlagBO;
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

//    private static final int  = 472;
    private static Logger logger = LoggerFactory.getLogger(FlagManagerImpl.class);

    private final Integer FLAGTYPE = 1;

    @Autowired
    FlagMapper flagMapper;

    @Override
    public List<FlagPO> pageAll() {

        List<FlagPO> allFlags = flagMapper.listAllFlag();
        logger.info(allFlags.get(0).toString());
        return allFlags;
//        return null;
    }

    @Override
    public List<FlagBO> page(String userId) {

        List<FlagPO> myFlags = flagMapper.selectByUserID(userId);
        List<FlagBO> bo = Transform.TransformFlagPO2BO(myFlags);
        logger.info(myFlags.get(0).toString());
        return bo;
    }

    @Override
    public FlagPO insert(FlagBO flagBO) {
        // 填入业务ID
        flagBO.setFlagId(NumberSender.createFlagID());
        if (flagBO.getType()==null) {
            flagBO.setType(FLAGTYPE);
        }
        if (flagBO.getPriority()==null) {
            flagBO.setPriority(1);
        }
//        if (flagBO.getStatus()==null) {
//            flagBO.setStatus(1);
//        }

        FlagPO po = Transform.TransformFlagBO2PO(flagBO);
        logger.info("=====>flag创建填充后param：{}", po);
        flagMapper.insert(po);
        return po;
    }

    @Override
    public int update(FlagPO flagPO) {
        return 0;
    }
}