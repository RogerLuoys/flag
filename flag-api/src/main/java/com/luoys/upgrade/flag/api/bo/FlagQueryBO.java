package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

@Data
public class FlagQueryBO {
    private String flagName;
    private String ownerId;
    private String witnessId;
    private Integer type;
    private Integer priority;
    private Integer status;
}
