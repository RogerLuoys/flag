package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum TemplateType {

    SYSTEM(1, "系统模板"),
    PERSONAL(2, "个人模板");

    private final Integer type;
    private final String description;

    TemplateType(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

}
