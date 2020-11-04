package com.luoys.upgrade.flag.api.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class FlagBO {
    private String flagId;
    @NotNull(message = "flag名不能为空")
    private String flagName;
    private String description;
    private String expected;
    private String actual;
    private Integer type;
    private Integer priority;
    private Date startDate;
    private Date endDate;
    private String createId;
    private Date gmtCreate;
    private Date gmtModify;

    private List<TaskBO> tasks;

    private String ownerId;
    private String ownerName;
    private String witnessId;
    private String witnessName;


}
