package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum TemplateTypeEnum {

    SYSTEM(1, "系统模板"),
    PERSONAL(2, "个人模板");

    private final Integer code;
    private final String description;

    TemplateTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

}
