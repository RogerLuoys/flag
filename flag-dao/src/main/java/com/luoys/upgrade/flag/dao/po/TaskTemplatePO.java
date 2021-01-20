package com.luoys.upgrade.flag.dao.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * task_template
 * @author 
 */
@Data
public class TaskTemplatePO implements Serializable {
    private Integer id;

    private String taskTemplateId;

    private String flagTemplateId;

    private String taskName;

    private String description;

    private Integer point;

    /**
     * 1系统模板；2个人模板
     */
    private Byte type;

    /**
     * 1-按周循环，2-按月循环，3-按年循环，4-按节假日循环
     */
    private Byte taskType;

    /**
     * 1-临时任务：20200101；2-按周循环：Mon=周一；3-按月循环：01=每月1号；4-按年循环：0101=每年一月一日；5-NewYear=新年
     */
    private String cycle;

    private String ownerId;

    private String creatorId;

    private Byte isDelete;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}