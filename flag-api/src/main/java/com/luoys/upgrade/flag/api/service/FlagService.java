package com.luoys.upgrade.flag.api.service;

import com.luoys.upgrade.flag.api.Result;
import com.luoys.upgrade.flag.api.bo.FlagBO;
import com.luoys.upgrade.flag.api.bo.FlagDetailBO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface FlagService {
    Result<FlagBO> queryFlagDetail(String flagId);

    Result<String> newFlag(FlagDetailBO flagDetailBO);

    Result<String> removeFlag(String flagId);

    Result<String> modifyFlagStatus(String flagId, Integer status);

    Result<String> modifyFlagBasic(FlagBO flagBO);

}
