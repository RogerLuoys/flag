package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.UserPO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int insert(UserPO userPO);

    int update(UserPO userPO);

    int checkUser(@Param("loginName") String loginName, @Param("passWord") String passWord);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserPO record);

    UserPO selectByLoginName(Integer id);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}