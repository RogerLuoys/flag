package com.luoys.upgrade.flag.manage.transform;

import com.luoys.upgrade.flag.api.bo.TaskDailyBO;
import com.luoys.upgrade.flag.api.bo.UserBO;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
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
        po.setPassWord(bo.getPassWord());
        return po;
    }
}
