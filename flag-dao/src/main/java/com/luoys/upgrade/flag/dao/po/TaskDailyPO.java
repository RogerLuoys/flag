package com.luoys.upgrade.flag.dao.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * task_daily
 * @author 
 */
@Data
public class TaskDailyPO implements Serializable {
    private Integer id;

    private String taskDailyId;

    private String flagId;

    private String taskId;

    private String taskName;

    private String description;

    private String comment;

    private Integer point;

    /**
     * 未使用
     */
    private Integer type;

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

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}