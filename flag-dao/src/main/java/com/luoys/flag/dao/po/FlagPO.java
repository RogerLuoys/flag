package com.luoys.flag.dao.po;

import lombok.Data;

import java.util.Date;

@Data
public class FlagPO {

    private Integer id;
    private String flagId;
    private String flagName;
    private String description;
    private Integer status;
    private Integer priority;
    private Date startDate;
    private Date endDate;
    private boolean isDelete;
    private Date gmtCreated;
    private Date gmtModified;
}
