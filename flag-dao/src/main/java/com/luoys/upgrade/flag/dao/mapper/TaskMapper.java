package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.TaskPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskMapper {

    int updateStatusByFlagId(@Param("flagId") String flagId, @Param("status") Integer status);

    int deleteByFlagId(String flagId);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskPO record);

    int insertSelective(TaskPO record);

    TaskPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskPO record);

    int updateByPrimaryKey(TaskPO record);
}