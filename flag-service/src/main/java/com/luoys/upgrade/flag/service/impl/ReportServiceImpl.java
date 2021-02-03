package com.luoys.upgrade.flag.service.impl;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.ReportBO;
import com.luoys.upgrade.flag.api.service.ReportService;
import com.luoys.upgrade.flag.manage.ReportManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/report")
public class ReportServiceImpl implements ReportService {
    private static final Logger LOG = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private ReportManager reportManager;

    @Override
    @RequestMapping(value = "/queryReportDetail", method = RequestMethod.GET)
    public Result<ReportBO> queryReportDetail(@RequestParam("flagId") String flagId) {
        LOG.info("=====》查询flag报告详情开始：flagId={}", flagId);
        return Result.ifSuccess(reportManager.queryReportByFlagId(flagId));
    }

}
