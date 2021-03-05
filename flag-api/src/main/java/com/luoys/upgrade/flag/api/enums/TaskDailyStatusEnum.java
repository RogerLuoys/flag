package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum TaskDailyStatusEnum {

    IN_PROGRESS(1, "进行中"),
    COMPLETED(2, "已完成"),
    // 逾期未完成任务，系统自动改为撤销状态
    UNDONE(3, "已撤销");

    private final Integer code;
    private final String description;

    TaskDailyStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

}
