package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum TaskType {

    TEMPORARY(1, "临时任务"),
    WEEK(2, "按周循环"),
    MONTH(3, "按月循环"),
    YEAR(4, "按年循环");

    private final Integer type;
    private final String description;

    TaskType(Integer type, String description) {
        this.type = type;
        this.description = description;
    }
}
