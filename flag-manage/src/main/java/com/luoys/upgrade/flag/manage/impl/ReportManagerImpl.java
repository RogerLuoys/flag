package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.bo.ReportBO;
import com.luoys.upgrade.flag.dao.mapper.FlagBindMapper;
import com.luoys.upgrade.flag.dao.mapper.FlagMapper;
import com.luoys.upgrade.flag.dao.mapper.TaskDailyMapper;
import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.FlagPO;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import com.luoys.upgrade.flag.manage.ReportManager;
import com.luoys.upgrade.flag.manage.util.TransformReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportManagerImpl implements ReportManager {
    private static Logger LOG = LoggerFactory.getLogger(ReportManagerImpl.class);

    @Autowired
    private FlagMapper flagMapper;
    @Autowired
    private FlagBindMapper flagBindMapper;
    @Autowired
    private TaskDailyMapper taskDailyMapper;

    @Override
    public ReportBO queryReportByFlagId(String flagId) {
        if (flagId == null || flagId == "") {
            LOG.error("----》查询报告详情时，flagId不能为空");
            return null;
        }

        FlagPO flagPO = flagMapper.selectByFlagId(flagId);
        if (flagPO == null) {
            LOG.error("----》查询报告详情时，根据flagId：{} 未查到flag", flagId);
            return null;
        }
        FlagBindPO flagBindPO = flagBindMapper.selectByFlagId(flagId);
        if (flagBindPO == null) {
            LOG.error("----》查询报告详情时，根据flagId：{} 未查到绑定信息", flagId);
            return null;
        }
        List<TaskDailyPO> taskDailyPOList = taskDailyMapper.listByFlagId(flagId);
        ReportBO reportDetailBO = new ReportBO();
        reportDetailBO.setActual(flagPO.getActual());
        reportDetailBO.setDescription(flagPO.getDescription());
        reportDetailBO.setExpected(flagPO.getExpected());
        reportDetailBO.setFlagId(flagPO.getFlagId());
        reportDetailBO.setFlagName(flagPO.getFlagName());
        reportDetailBO.setWitnessId(flagBindPO.getWitnessId());
        reportDetailBO.setWitnessName(flagBindPO.getWitnessName());
        reportDetailBO.setReportLogList(TransformReport.TransformPO2BO(taskDailyPOList));
        return reportDetailBO;
    }


}
