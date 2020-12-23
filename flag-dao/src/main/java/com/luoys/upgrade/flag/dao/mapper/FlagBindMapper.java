package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import com.luoys.upgrade.flag.dao.po.TaskPO;
import com.luoys.upgrade.flag.dao.po.UserFlagPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlagBindMapper {

    int insert(FlagBindPO flagBindPO);

    int update(FlagBindPO flagBindPO);

    int deleteByFlagId(String flagId);

    // 多个入参需要通过param注解映射
    List<UserFlagPO> listUserFlag(
            @Param("ownerId") String ownerId, @Param("witnessId") String witnessId, @Param("flagType") Integer flagType,
            @Param("flagStatus") Integer flagStatus, @Param("flagName") String flagName, @Param("startIndex") Integer startIndex);

    List<TaskDailyPO> listUserTaskDaily(@Param("ownerId") String ownerId, @Param("witnessId") String witnessId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    FlagBindPO selectByFlagId(String flagId);

//
//    int insertSelective(FlagBindPO record);
//
//    FlagBindPO selectByPrimaryKey(Integer id);
//
//
//
//    int updateByPrimaryKey(FlagBindPO record);
}