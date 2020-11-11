package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import com.luoys.upgrade.flag.dao.po.UserFlagPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlagBindMapper {

    List<UserFlagPO> listOurFlags(String userId, Integer userType, Integer flagType, Integer flagStatus);

    List<FlagBindPO> selectByFlagId(String flagId);

//    int deleteByPrimaryKey(Integer id);

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