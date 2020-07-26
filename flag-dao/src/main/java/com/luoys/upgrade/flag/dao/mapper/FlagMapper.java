package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.FlagPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlagMapper {

    @Select("select id, flag_id as flagId,flag_name as flagName,description,`status`,priority,start_date as startDate,end_date as endDate,is_delete as deleted,gmt_created as gmtCreated,gmt_modified as gmtModified from flag where is_delete=0 limit 10;")
    List<FlagPO> listAllFlag();

    @Insert("insert into flag (flag_id, flag_name, description, `status`, priority, start_date, end_date, is_delete, gmt_created, gmt_modified) values (#{flagId},#{flagName},#{description},#{status},#{priority},#{startDate},#{endDate},#{deleted},#{gmtCreated},#{gmtModified});")
    int insert(FlagPO flagPO);

    @Update("")
    int update(FlagPO flagPO);
}
