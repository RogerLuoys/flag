package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import java.util.Date;

@Data
public class UserFlagBO {


    private String flagId;

    private String flagName;

    private String description;

    private String expected;

    private String actual;

    private Integer type;

    private Integer priority;

    private Date startDate;

    private Date endDate;

    private String creatorId;

    private String userId;

    private String userName;

    /**
     * 1-所有者；2-见证人
     */
    private Integer userType;

    /**
     * 1-未开始; 2-进行中; 3-暂停; 4-已结束; 5-已达成
     */
    private Integer status;

    private String witnessId;

    private String witnessName;

}
