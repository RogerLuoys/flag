package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.TaskPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {

    int insert(TaskPO record);

    int updateStatusByFlagId(@Param("flagId") String flagId, @Param("status") Integer status);

    int deleteByFlagId(String flagId);

    int update(TaskPO taskPO);

    List<TaskPO> listByFlagId(String flagId);

    int countTaskByFlagId(String flagId);

    TaskPO selectByTaskId(String taskId);

    List<TaskPO> listByType(Integer type);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(TaskPO record);

    int updateByPrimaryKey(TaskPO record);
}