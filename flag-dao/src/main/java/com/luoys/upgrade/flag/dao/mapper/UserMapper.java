package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int insert(UserPO userPO);

    int update(UserPO userPO);

    UserPO checkUser(@Param("loginName") String loginName, @Param("password") String password);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserPO record);

    UserPO selectByLoginName(Integer id);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}