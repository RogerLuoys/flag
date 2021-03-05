package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum FlagTypeEnum {

    FLAG(1, "通常Flag"),
    HABIT(2, "习惯或长期Flag"),
    // 创建临时任务流程中创建的Flag为临时Flag
    TEMPORARY(3, "临时Flag");


    private final Integer code;
    private final String description;

    FlagTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

}
