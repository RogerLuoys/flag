package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.NumberSender;
import com.luoys.upgrade.flag.api.bo.UserBO;
import com.luoys.upgrade.flag.dao.mapper.PointMapper;
import com.luoys.upgrade.flag.dao.mapper.UserMapper;
import com.luoys.upgrade.flag.dao.po.PointPO;
import com.luoys.upgrade.flag.manage.UserManager;
import com.luoys.upgrade.flag.manage.transform.TransformUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagerImpl implements UserManager {

    private final static Logger LOG = LoggerFactory.getLogger(UserManagerImpl.class);
    private final static String DEFAULT_USER_NAME = "新干旗人";
    private final static int DEFAULT_TYPE = 2;
    private final static int DEFAULT_STATUS = 1;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PointMapper pointMapper;

    @Override
    public Integer modifyUser(UserBO userBO) {
        if (userBO == null) {
            return null;
        }
        return userMapper.update(TransformUser.transformBO2PO(userBO));
    }

    @Override
    public UserBO queryByLoginInfo(String loginName, String passWord) {
        if (loginName == null || passWord == null) {
            return null;
        }
        return TransformUser.transformPO2BO(userMapper.selectByLoginInfo(loginName, passWord));
    }

    @Override
    public UserBO queryByUserId(String userId) {
        if (null == userId) {
            return null;
        }
        return TransformUser.transformPO2BO(userMapper.selectByUserId(userId));
    }

    @Override
    public Boolean checkUserExist(String loginName) {
        if (loginName == null) {
            LOG.error("----》入参为空");
            return null;
        }
        return null == userMapper.selectByLoginName(loginName) ? false : true;
    }

    @Override
    public Integer newUser(UserBO userBO) {
        if (userBO == null || userBO.getLoginName() == null || userBO.getPassword() == null) {
            LOG.error("----》入参为空");
            return null;
        }
        if (userBO.getUserName() == null) {
            userBO.setUserName(DEFAULT_USER_NAME);
        }
        if (userBO.getType() == null) {
            userBO.setType(DEFAULT_TYPE);
        }
        if (userBO.getStatus() == null) {
            userBO.setStatus(DEFAULT_STATUS);
        }
        userBO.setUserId(NumberSender.createUserId());
        LOG.info("====》新增用户：{}", userBO);
        int insertUserResult = userMapper.insert(TransformUser.transformBO2PO(userBO));
        PointPO pointPO = new PointPO();
        pointPO.setUsablePoint(0);
        pointPO.setExpendPoint(0);
        pointPO.setStatus(1);
        pointPO.setOwnerId(userBO.getUserId());
        pointPO.setPointId(NumberSender.createPointId());
        LOG.info("====》新增积分账号：{}", pointPO);
        int insertPointResult = pointMapper.insert(pointPO);
        return (insertUserResult == 1 && insertPointResult == 1) ? 1 : null;
    }
}
