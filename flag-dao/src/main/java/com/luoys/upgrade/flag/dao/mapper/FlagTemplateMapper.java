package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagTemplatePO;

public interface FlagTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlagTemplatePO record);

    int insertSelective(FlagTemplatePO record);

    FlagTemplatePO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlagTemplatePO record);

    int updateByPrimaryKey(FlagTemplatePO record);
}