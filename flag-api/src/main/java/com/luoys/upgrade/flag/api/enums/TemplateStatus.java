package com.luoys.upgrade.flag.api.enums;

import lombok.Getter;

@Getter
public enum TemplateStatus {

    PUBLIC(1, "公开"),
    PRIVATE(2, "私有");

    private final Integer status;
    private final String description;

    TemplateStatus(Integer status, String description){
        this.status = status;
        this.description = description;
    }
}
