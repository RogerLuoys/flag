package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum TaskStatus {

    PAUSE(1, "暂停"),
    IN_PROGRESS(2, "进行中");

    private final Integer status;
    private final String description;

    TaskStatus(Integer status, String description) {
        this.status = status;
        this.description = description;
    }
}
