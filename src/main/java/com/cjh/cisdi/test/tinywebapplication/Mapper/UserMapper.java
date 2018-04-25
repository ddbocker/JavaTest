package com.cjh.cisdi.test.tinywebapplication.Mapper;

import java.util.List;

import com.cjh.cisdi.test.tinywebapplication.Dao.User;
import com.cjh.cisdi.test.tinywebapplication.Dao.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}