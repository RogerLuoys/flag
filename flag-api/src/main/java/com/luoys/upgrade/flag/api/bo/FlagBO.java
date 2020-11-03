package com.luoys.upgrade.flag.api.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Date startDate;
    private Date endDate;
    private String createId;
    private Date gmtCreate;
    private Date gmtModify;

}
