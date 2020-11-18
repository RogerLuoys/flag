package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.UserFlagPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlagBindMapper {

    // 多个入参需要通过param注解映射
    List<UserFlagPO> listOurFlags(
            @Param("ownerId") String ownerId, @Param("witnessId") String witnessId, @Param("flagType") Integer flagType,
            @Param("flagStatus") Integer flagStatus, @Param("flagName") String flagName, @Param("pageIndex") Integer pageIndex);

    FlagBindPO selectByFlagId(String flagId);

    int deleteByFlagId(String flagId);

    int insert(FlagBindPO record);
//
//    int insertSelective(FlagBindPO record);
//
//    FlagBindPO selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(FlagBindPO record);
//
//    int updateByPrimaryKey(FlagBindPO record);
}