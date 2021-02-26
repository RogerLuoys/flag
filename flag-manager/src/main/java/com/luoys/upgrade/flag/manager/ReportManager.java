package com.luoys.upgrade.flag.manager;

import com.luoys.upgrade.flag.api.bo.ReportBO;

public interface ReportManager {

    ReportBO queryReportByFlagId(String flagId);
}
