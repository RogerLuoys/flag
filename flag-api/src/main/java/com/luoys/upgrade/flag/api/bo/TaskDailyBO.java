package com.luoys.upgrade.flag.api.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TaskDailyBO {

    private String taskDailyId;

    private String flagId;

    private String taskId;

    @NotNull(message = "每日任务名不能为空")
    private String taskDailyName;

    private String description;

    private String comment;

    private Integer point;

    /**
     * 1-任务所有者；2-任务见证人
     */
    private Integer bindType;

    /**
     * 1-进行中；2-已完成；3-撤销
     */
    private Integer status;

    /**
     * 任务开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 任务结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;


    // 每日任务 关联的账户信息
    private String ownerId;
    private String ownerName;
    private String witnessId;
    private String witnessName;

}
