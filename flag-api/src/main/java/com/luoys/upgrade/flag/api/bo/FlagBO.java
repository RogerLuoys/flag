package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import java.util.Date;

@Data
public class FlagBO {
    private String flagId;
    private String flagName;
    private String description;
    private String expected;
    private String actual;
    private Integer type;
    private Integer priority;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    private Date endDate;
    private String createId;
    private Date gmtCreate;
    private Date gmtModify;

}
