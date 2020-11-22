package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlagMapper {

    int insert(FlagPO flagPO);

    int deleteByFlagId(String flagId);

    int update(FlagPO flagPO);

    int updateStatusByFlagId(@Param("flagId") String flagId, @Param("status") Integer status);

    FlagPO selectByFlagId(String flagId);

    List<FlagPO> listByUserId(String userId);

}