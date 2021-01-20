package com.luoys.upgrade.flag.dao.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * flag_template
 * @author 
 */
@Data
public class FlagTemplatePO implements Serializable {
    private Integer id;

    private String flagTemplateId;

    private String flagName;

    private String description;

    /**
     * 期望结果
     */
    private String expected;

    /**
     * 1系统模板；2个人模板
     */
    private Byte type;

    /**
     * 1-flag；2-习惯；3临时任务
     */
    private Byte flagType;

    /**
     * 1公开；2私有
     */
    private Byte status;

    private Integer useCount;

    private String ownerId;

    private String creatorId;

    private Byte isDelete;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}