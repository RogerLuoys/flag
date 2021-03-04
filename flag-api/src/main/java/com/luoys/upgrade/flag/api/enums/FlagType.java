package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum FlagType {

    FLAG(1, "通常Flag"),
    HABIT(2, "习惯或长期Flag"),
    // 创建临时任务流程中创建的Flag为临时Flag
    TEMPORARY(3, "临时Flag");


    private final Integer type;
    private final String description;

    FlagType(Integer type, String description) {
        this.type = type;
        this.description = description;
    }
}
