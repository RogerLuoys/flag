package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.PointLogPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointLogMapper {

    int insert(PointLogPO pointLogPO);

    List<PointLogPO> listPointLog(@Param("pointId") String pointId, @Param("type") Integer type, @Param("startIndex") Integer startIndex);


    int deleteByPrimaryKey(Integer id);

    int insertSelective(PointLogPO record);

    PointLogPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PointLogPO record);

    int updateByPrimaryKey(PointLogPO record);
}