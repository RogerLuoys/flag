package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagTemplatePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlagTemplateMapper {
    FlagTemplatePO selectByFlagTemplateId(String flagTemplateId);

    List<FlagTemplatePO> listFlagTemplate(@Param("ownerId") String ownerId, @Param("flagName") String flagName,
                                          @Param("startIndex") Integer startIndex);


    int deleteByPrimaryKey(Integer id);

    int insert(FlagTemplatePO record);

    int insertSelective(FlagTemplatePO record);

    FlagTemplatePO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlagTemplatePO record);

    int updateByPrimaryKey(FlagTemplatePO record);
}