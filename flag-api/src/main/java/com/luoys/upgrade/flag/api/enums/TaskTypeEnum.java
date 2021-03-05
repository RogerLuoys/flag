package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum TaskTypeEnum {

    TEMPORARY(1, "临时任务"),
    WEEK(2, "按周循环"),
    MONTH(3, "按月循环"),
    YEAR(4, "按年循环");

    private final Integer code;
    private final String description;

    TaskTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

}
