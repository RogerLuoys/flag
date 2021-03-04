package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum PointLogType {

    INCREASE(1, "增加"),
    DECREASE(2, "减少");

    private final Integer type;
    private final String description;

    PointLogType(Integer type, String description) {
        this.type = type;
        this.description = description;
    }
}
