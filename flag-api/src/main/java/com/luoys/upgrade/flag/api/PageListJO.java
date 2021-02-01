package com.luoys.upgrade.flag.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageListJO<T> {

    private List<T> list;

    private Integer total;

    public PageListJO(List<T> list, Integer total) {
        this.list = list;
        this.total = total;
    }

    public PageListJO() {
        this.list = new ArrayList<>();
        this.total = 0;
    }

}
