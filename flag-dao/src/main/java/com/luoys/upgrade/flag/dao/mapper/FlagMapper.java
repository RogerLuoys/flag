package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlagMapper {

    List<FlagPO> listAllFlag();

    int deleteByFlagId(Integer id);

    int insert(FlagPO record);

//    int insertSelective(FlagPO record);

    FlagPO selectByFlagId(Integer id);

    List<FlagPO> listByUserId(String userId);

    int updateByFlagId(FlagPO record);

//    int updateByPrimaryKey(FlagPO record);
}