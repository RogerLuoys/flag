package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class FlagDetailBO {
    // flag 信息
    private String flagId;
    @NotNull(message = "flag名不能为空")
    private String flagName;
    private String description;
    private String expected;
    private String actual;
    private Integer type;
    private Integer status;
    private Integer priority;
    private Date startDate;
    private Date endDate;
    private String createId;

    // flag 关联的任务信息
    private List<TaskBO> tasks;

    // flag 关联的账户信息
    private String ownerId;
    private String ownerName;
    private String witnessId;
    private String witnessName;


}
