package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.FlagBindBO;
import com.luoys.upgrade.flag.dao.mapper.FlagBindMapper;
import com.luoys.upgrade.flag.manage.FlagBindManager;
import com.luoys.upgrade.flag.manage.util.Transform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        if (flagBindBO.getUserId() == null) {
            logger.error("=====>必填字段 userId 不能为空");
        }
        if (flagBindBO.getStatus() == null) {
            flagBindBO.setStatus(1);
        }
        if (flagBindBO.getType() == null) {
            flagBindBO.setType(1);
        }
        int result = flagBindMapper.insert(Transform.TransformFlagBindBO2PO(flagBindBO));
        return result == 1 ? flagBindBO : null;
    }
}
