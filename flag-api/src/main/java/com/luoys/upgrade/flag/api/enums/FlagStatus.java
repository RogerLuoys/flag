package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum FlagStatus {

    NOT_START(1, "未开始"),
    IN_PROGRESS(2, "进行中"),
    COMPLETED(3, "已完成"),
    CHECK_PENDING(4, "待审核"),
    PAUSE(5, "暂停"),
    GIVE_UP(6, "放弃");

    private final Integer status;
    private final String description;

    FlagStatus(Integer status, String description) {
        this.status = status;
        this.description = description;
    }
}
