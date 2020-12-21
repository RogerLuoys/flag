package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDailyDetailBO extends TaskDailyBO {

    // 每日任务 关联的账户信息
    private String ownerId;
    private String ownerName;
    private String witnessId;
    private String witnessName;

}
