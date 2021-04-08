package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

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


    private static final Map<Integer, FlagStatusEnum> CODE_MAP = new HashMap<>();

    static {
        for (FlagStatusEnum e : FlagStatusEnum.values()) {
            CODE_MAP.put(e.getCode(), e);
        }
    }

    public static FlagStatusEnum fromCode(Integer code) {
        return code == null ? null : CODE_MAP.get(code);
    }


}
