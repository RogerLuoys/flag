package com.luoys.upgrade.flag.dao.po;

import java.util.Date;
import lombok.Data;

/**
 * flag
 * @luoys
 */
@Data
public class FlagPO {
    private Integer id;

    private String flagId;

    private String flagName;

    private String description;

    private Integer status;

    private Integer priority;

    private Date startDate;

    private Date endDate;

    private String creatorId;

    private Date gmtCreated;

    private Date gmtModified;

}