package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlagMapper {

    List<FlagPO> listAllFlag();

    int deleteByFlagID(Integer id);

    int insert(FlagPO record);

    int insertSelective(FlagPO record);

    FlagPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlagPO record);

    int updateByPrimaryKey(FlagPO record);
}