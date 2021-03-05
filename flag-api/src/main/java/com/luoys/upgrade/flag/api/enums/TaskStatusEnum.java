package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum TaskStatusEnum {

    PAUSE(1, "暂停"),
    IN_PROGRESS(2, "进行中");

    private final Integer code;
    private final String description;

    TaskStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

}
