package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.FlagBO;

public interface FlagService {
    Result<FlagBO> queryFlagDetail(String flagId);

    Result<String> newFlag(FlagBO flagBO);

    Result<String> removeFlag(String flagId);

    Result<String> modifyFlagStatus(String flagId, Integer status);

    Result<String> modifyFlagBasic(FlagBO flagBO);

}
