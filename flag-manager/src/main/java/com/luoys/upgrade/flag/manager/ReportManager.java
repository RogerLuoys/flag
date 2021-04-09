package com.luoys.upgrade.flag.manager;

import com.luoys.common.annotation.NotNull;
import com.luoys.upgrade.flag.api.bo.ReportBO;

public interface ReportManager {

    ReportBO queryReportByFlagId(@NotNull String flagId);
}
