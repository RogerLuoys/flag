package com.luoys.upgrade.flag.manager.transform;

import com.luoys.upgrade.flag.api.bo.UserBO;
import com.luoys.upgrade.flag.dao.po.UserPO;
import com.luoys.upgrade.uc.share.dto.UserDTO;

public class TransformUser {

    @Deprecated
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

    @Deprecated
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


    public static UserDTO transformBO2DTO(UserBO bo) {
        if (bo == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setStatus(bo.getStatus());
        dto.setUserId(bo.getUserId());
        dto.setLoginName(bo.getLoginName());
        dto.setType(bo.getType());
        dto.setPhone(bo.getPhone());
        dto.setUserName(bo.getUserName());
        dto.setPassword(bo.getPassword());
        return dto;
    }

    public static UserBO transformDTO2BO(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        UserBO bo = new UserBO();
        bo.setPassword(dto.getPassword());
        bo.setUserId(dto.getUserId());
        bo.setUserName(dto.getUserName());
        bo.setPhone(dto.getPhone());
        bo.setStatus(dto.getStatus());
        bo.setType(dto.getType());
        bo.setLoginName(dto.getLoginName());
        return bo;
    }
}
