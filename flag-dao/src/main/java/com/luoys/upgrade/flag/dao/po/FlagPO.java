package com.luoys.upgrade.flag.dao.po;

import java.util.Date;
import lombok.Data;

/**
 * flag
 * @author luoys
 */
@Data
public class FlagPO {
    private Integer id;

    private String flagId;

    private String flagName;

    private String description;

    private String expected;

    private String actual;

    private Integer type;

    private Integer status;

    private Integer priority;

    private Date startTime;

    private Date endTime;

    private String creatorId;

    private Date gmtCreate;

    private Date gmtModified;

}