package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum PointStatusEnum {

    NORMAL(1, "正常"),
    FREEZE(2, "冻结");

    private final Integer code;
    private final String description;

    PointStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

}
