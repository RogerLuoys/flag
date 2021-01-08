package com.luoys.upgrade.flag.api.bo;

import lombok.Data;

import java.util.List;

@Data
public class ReportBO {

    private String flagId;
    private String flagName;
    private String description;
    private String expected;
    private String actual;

    private String witnessId;
    private String witnessName;

    private List<ReportLogBO> reportLogList;

}
