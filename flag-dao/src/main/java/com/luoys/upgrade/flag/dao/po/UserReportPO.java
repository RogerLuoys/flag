package com.luoys.upgrade.flag.dao.po;

import lombok.Data;

import java.util.Date;

@Data
public class UserReportPO {

    private String flagId;

    private String flagName;

    private Integer totalPoint;

    private Integer totalTaskDaily;

    private Date startTime;

    private Date endTime;
}
