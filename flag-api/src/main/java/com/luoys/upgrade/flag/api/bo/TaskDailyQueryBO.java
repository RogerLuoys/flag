package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDailyQueryBO {

    String ownerId;

    String witnessId;

    Date startTime;

    Date endTime;
}
