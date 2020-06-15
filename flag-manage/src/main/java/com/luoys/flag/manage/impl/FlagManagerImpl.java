package com.luoys.flag.manage.impl;

import com.luoys.flag.dao.mapper.FlagMapper;
import com.luoys.flag.dao.po.FlagPO;
import com.luoys.flag.manage.FlagManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlagManagerImpl implements FlagManager {

    private static Logger logger = LoggerFactory.getLogger(FlagManagerImpl.class);

    @Autowired
    FlagMapper flagMapper;

    @Override
    public List<FlagPO> page() {
        List<FlagPO> allFlags = flagMapper.listAllFlag();
        logger.info(allFlags.get(0).toString());
        return allFlags;
//        return null;
    }
}
