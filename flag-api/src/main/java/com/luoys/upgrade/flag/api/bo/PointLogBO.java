package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import java.util.Date;

@Data
public class PointLogBO {

    private String pointId;

    private String taskDailyId;

    private Integer point;

    private String description;

    private String comment;

    /**
     * 1-增加；2-减少
     */
    private Integer type;

    private Date recordTime;

}
