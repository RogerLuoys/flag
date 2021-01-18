package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.PointBO;
import org.springframework.web.bind.annotation.RequestParam;

public interface PointService {

    Result<PointBO> queryPointSummary(String ownerId);

}
