package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagBindPO;
import org.springframework.stereotype.Repository;

@Repository
public interface FlagBindMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlagBindPO record);

    int insertSelective(FlagBindPO record);

    FlagBindPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlagBindPO record);

    int updateByPrimaryKey(FlagBindPO record);
}