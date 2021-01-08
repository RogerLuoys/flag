package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import java.util.Date;

@Data
public class ReportLogBO {

    private String taskDailyId;
    private String taskDailyName;
    private String comment;
    private Date startTime;
    private Date endTime;

}
