package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.PointPO;
import org.springframework.stereotype.Repository;

@Repository
public interface PointMapper {

    PointPO selectByOwnerId(String ownerId);


    int deleteByPrimaryKey(Integer id);

    int insert(PointPO record);

    int insertSelective(PointPO record);

    PointPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PointPO record);

    int updateByPrimaryKey(PointPO record);
}