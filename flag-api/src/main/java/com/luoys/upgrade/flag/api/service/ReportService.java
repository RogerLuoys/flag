package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.ReportBO;

public interface ReportService {

    Result<ReportBO> queryReportDetail(String flagId);

}
