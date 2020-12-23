package com.luoys.upgrade.flag.api.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class TaskDailyDetailBO extends TaskDailyBO {

    // 每日任务 关联的账户信息
    private String ownerId;
    private String ownerName;
    private String witnessId;
    private String witnessName;

}
