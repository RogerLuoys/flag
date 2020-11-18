package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface FlagService {
    Result<FlagBO> queryFlagDetail(String flagId);

    Result<String> addFlag(FlagBO flagBO);

    Result<String> removeFlag(String flagId);
}
