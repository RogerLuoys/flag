package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.bo.UserBO;
import com.luoys.upgrade.flag.dao.mapper.UserMapper;
import com.luoys.upgrade.flag.manage.UserManager;
import com.luoys.upgrade.flag.manage.transform.TransformUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserManagerImpl implements UserManager {

    private static Logger LOG = LoggerFactory.getLogger(UserManagerImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public int modifyUser(UserBO userBO){
        if (userBO == null) {
            return 0;
        }
        return userMapper.update(TransformUser.transformBO2PO(userBO));
    }

    @Override
    public int checkUser(String loginName, String passWord){
        if (loginName == null || passWord == null) {
            return 0;
        }
        return userMapper.checkUser(loginName, passWord);
    }

    @Override
    public int newUser(UserBO userBO){
        if (userBO == null) {
            return 0;
        }
        return userMapper.insert(TransformUser.transformBO2PO(userBO));
    }
}
