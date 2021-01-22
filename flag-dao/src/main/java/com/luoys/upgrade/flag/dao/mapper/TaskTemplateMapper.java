package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.TaskTemplatePO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskTemplateMapper {
    List<TaskTemplatePO> listByFlagTemplateId(String flagTemplateId);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskTemplatePO record);

    int insertSelective(TaskTemplatePO record);

    TaskTemplatePO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskTemplatePO record);

    int updateByPrimaryKey(TaskTemplatePO record);
}