package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface FlagService {
    Result<FlagBO> queryFlagDetail(@RequestParam String flagId);

    Result<String> addFlag(@RequestBody FlagBO flagBO);
}
