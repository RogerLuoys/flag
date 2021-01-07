package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import java.util.Date;

@Data
public class UserReportBO {

    private String flagId;

    private String flagName;

    private Integer totalPoint;

    private Integer totalTaskDaily;

    private Date startTime;

    private Date endTime;
}
