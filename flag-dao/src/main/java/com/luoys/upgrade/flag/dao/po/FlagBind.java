package com.luoys.upgrade.flag.dao.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * flag_bind
 * @author 
 */
@Data
public class FlagBind implements Serializable {
    private Integer id;

    private String userId;

    private String flagId;

    /**
     * 1-所有者；2-见证人
     */
    private Byte type;

    /**
     * 1-未开始; 2-进行中; 3-暂停; 4-已结束; 5-已达成
     */
    private Byte status;

    private Byte isDelete;

    private Date gmtCreate;

    private Date gmtModify;

    private static final long serialVersionUID = 1L;
}