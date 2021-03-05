package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum TemplateStatusEnum {

    PUBLIC(1, "公开"),
    PRIVATE(2, "私有");

    private final Integer code;
    private final String description;

    TemplateStatusEnum(Integer code, String description){
        this.code = code;
        this.description = description;
    }

}
