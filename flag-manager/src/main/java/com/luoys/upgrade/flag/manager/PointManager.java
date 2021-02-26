package com.luoys.upgrade.flag.manager;

import com.luoys.upgrade.flag.api.bo.PointBO;
import com.luoys.upgrade.flag.api.bo.PointLogBO;

import java.util.List;

public interface PointManager {

    PointBO queryPointByOwnerId(String ownerId);

    List<PointLogBO> queryPointLog(String pointId, Integer type);

    String newPointLog(PointLogBO pointLogBO);
}