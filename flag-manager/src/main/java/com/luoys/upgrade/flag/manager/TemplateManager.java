package com.luoys.upgrade.flag.manager;

import com.luoys.common.annotation.NotNull;
import com.luoys.common.annotation.Nullable;
import com.luoys.upgrade.flag.api.bo.FlagTemplateBO;
import com.luoys.upgrade.flag.api.bo.TaskTemplateBO;

import java.util.List;

public interface TemplateManager {

    FlagTemplateBO queryFlagTemplateByFlagTemplateId(@NotNull String flagTemplateId);

    List<FlagTemplateBO> queryFlagTemplateList(@NotNull String ownerId, @Nullable String flagName);

    List<TaskTemplateBO> queryTaskTemplateList(@NotNull String flagTemplateId);
}