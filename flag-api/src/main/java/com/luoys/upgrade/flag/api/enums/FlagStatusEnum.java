package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum FlagStatusEnum {

    NOT_START(1, "未开始"),
    IN_PROGRESS(2, "进行中"),
    COMPLETED(3, "已完成"),
    CHECK_PENDING(4, "待审核"),
    PAUSE(5, "暂停"),
    GIVE_UP(6, "放弃");

    private final Integer code;
    private final String description;

    FlagStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

}
