package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.TaskDailyPO;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDailyMapper {

    int insert(TaskDailyPO taskDailyPO);


    int deleteByPrimaryKey(Integer id);

    int insertSelective(TaskDailyPO record);

    TaskDailyPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskDailyPO record);

    int updateByPrimaryKey(TaskDailyPO record);
}