package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.PointPO;
import org.springframework.stereotype.Repository;

@Repository
public interface PointMapper {

    int insert(PointPO pointPO);

    int update(PointPO pointPO);

    PointPO selectByOwnerId(String ownerId);

    PointPO selectByPointId(String pointId);


    int deleteByPrimaryKey(Integer id);

    int insertSelective(PointPO record);

    PointPO selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(PointPO record);
}