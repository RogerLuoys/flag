package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.PointLogPO;
import org.springframework.stereotype.Repository;

@Repository
public interface PointLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PointLogPO record);

    int insertSelective(PointLogPO record);

    PointLogPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PointLogPO record);

    int updateByPrimaryKey(PointLogPO record);
}