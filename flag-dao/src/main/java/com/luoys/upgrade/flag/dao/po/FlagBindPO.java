package com.luoys.upgrade.flag.dao.po;

import lombok.Data;
import java.util.Date;

/**
 * flag_bind
 * @author
 */
@Data
public class FlagBindPO {
    private Integer id;

    private String userId;

    private String userName;

    private String witnessId;

    private String witnessName;

    private String flagId;

    /**
     * 1-所有者；2-见证人
     */
    private Integer type;

    /**
     * 1-未开始; 2-进行中; 3-暂停; 4-已结束; 5-已达成
     */
    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;
}
