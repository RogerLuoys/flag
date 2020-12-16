package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDailyBO {

    private String taskDailyId;

    private String flagId;

    private String taskId;

    private String taskName;

    private String description;

    private String comment;

    private Integer point;

    /**
     * 1-已完成；2-未完成
     */
    private Integer status;

    /**
     * 任务开始时间
     */
    private Date startTime;

    /**
     * 任务结束时间
     */
    private Date endTime;

}
