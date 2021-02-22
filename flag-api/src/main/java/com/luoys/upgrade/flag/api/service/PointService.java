package com.luoys.upgrade.flag.api.service;

import com.luoys.common.api.Result;
import com.luoys.upgrade.flag.api.bo.PointBO;
import com.luoys.upgrade.flag.api.bo.PointLogBO;

import java.util.List;

public interface PointService {

    Result<PointBO> queryPointSummary(String ownerId);

    Result<List<PointLogBO>> queryPointLogList(String pointId, Integer type);

    Result<String> newPointLog(PointLogBO pointLogBO);
}
