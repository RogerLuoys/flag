package com.luoys.flag.dao.mapper;

import com.luoys.flag.dao.po.FlagPO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlagMapper {

    @Select("select id, flag_id as flagId,flag_name as flagName,description,`status`,priority,start_date as startDate,end_date as endDate,is_delete as isDelete,gmt_created as gmtCreated,gmt_modified as gmtModified from flag where is_delete=0 limit 10;")
    List<FlagPO> listAllFlag();

}
