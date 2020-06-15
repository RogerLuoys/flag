package com.luoys.flag.dao.mapper;

import com.luoys.flag.dao.po.FlagPO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlagMapper {

    @Select("select id, flag_id,flag_name,description,status,priority,start_date,end_date,is_delete,gmt_created,gmt_modified from flag where is_delete=0 limit 10")
    List<FlagPO> listAllFlag();

}
