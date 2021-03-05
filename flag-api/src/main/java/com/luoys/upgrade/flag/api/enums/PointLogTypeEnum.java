package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum PointLogTypeEnum {

    INCREASE(1, "增加"),
    DECREASE(2, "减少");

    private final Integer code;
    private final String description;

    PointLogTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

}
