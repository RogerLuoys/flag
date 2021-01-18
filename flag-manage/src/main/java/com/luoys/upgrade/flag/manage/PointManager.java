package com.luoys.upgrade.flag.manage;

import com.luoys.upgrade.flag.api.bo.PointBO;

public interface PointManager {

    PointBO queryPointByOwnerId(String ownerId);
}
