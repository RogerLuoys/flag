package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlagMapper {

    List<FlagPO> listAllFlag();

    int deleteByFlagID(Integer id);

    int insert(FlagPO record);

//    int insertSelective(FlagPO record);

    FlagPO selectByFlagID(Integer id);

    List<FlagPO> selectByUserID(String userID);

    int updateByFlagID(FlagPO record);

//    int updateByPrimaryKey(FlagPO record);
}