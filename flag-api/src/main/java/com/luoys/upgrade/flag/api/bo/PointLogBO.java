package com.luoys.upgrade.flag.api.bo;

import java.util.Date;

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

    private Integer status;

    private Date recordTime;

}
