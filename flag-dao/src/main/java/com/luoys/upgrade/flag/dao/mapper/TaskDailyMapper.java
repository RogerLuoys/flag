package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDailyMapper {

    int insert(TaskDailyPO taskDailyPO);

    int updateStatusByTaskDailyId(@Param("taskDailyId") String taskDailyId, @Param("status") Integer status);

    int updateCommentByTaskDailyId(@Param("taskDailyId") String taskDailyId, @Param("comment") String comment);

    int deleteByTaskDailyId(@Param("taskDailyId") String taskDailyId);

    List<TaskDailyPO> listByFlagId(@Param("flagId") String flagId);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(TaskDailyPO record);

    TaskDailyPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskDailyPO record);

    int updateByPrimaryKey(TaskDailyPO record);
}