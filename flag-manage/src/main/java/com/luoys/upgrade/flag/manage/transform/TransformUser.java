package com.luoys.upgrade.flag.manage.transform;

import com.luoys.upgrade.flag.api.bo.UserBO;
import com.luoys.upgrade.flag.dao.po.UserPO;

public class TransformUser {

    public static UserPO transformBO2PO(UserBO bo) {
        if (bo == null) {
            return null;
        }
        UserPO po = new UserPO();
        po.setStatus(bo.getStatus());
        po.setUserId(bo.getUserId());
        po.setLoginName(bo.getLoginName());
        po.setType(bo.getType());
        po.setPhone(bo.getPhone());
        po.setUserName(bo.getUserName());
        po.setPassword(bo.getPassword());
        return po;
    }

    public static UserBO transformPO2BO(UserPO po) {
        if (po == null) {
            return null;
        }
        UserBO bo = new UserBO();
        bo.setPassword(po.getPassword());
        bo.setUserId(po.getUserId());
        bo.setUserName(po.getUserName());
        bo.setPhone(po.getPhone());
        bo.setStatus(po.getStatus());
        bo.setType(po.getType());
        bo.setLoginName(po.getLoginName());
        return bo;
    }
}
