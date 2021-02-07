package com.luoys.upgrade.flag.dao.mapper;

import com.luoys.upgrade.flag.dao.po.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int insert(UserPO userPO);

    int update(UserPO userPO);

    UserPO selectByLoginInfo(@Param("loginName") String loginName, @Param("password") String password);

    UserPO selectByLoginName(String loginName);

    UserPO selectByUserId(String userId);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserPO record);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}