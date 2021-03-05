package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum FlagPriorityEnum {

    GENERAL(1, "一般"),
    IMPORTANT(2, "重要"),
    VERY_IMPORTANT(3, "非常重要");

    private final Integer code;
    private final String description;

    FlagPriorityEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
