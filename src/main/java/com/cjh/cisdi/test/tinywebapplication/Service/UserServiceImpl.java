package com.cjh.cisdi.test.tinywebapplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cjh.cisdi.test.tinywebapplication.Dao.User;
import com.cjh.cisdi.test.tinywebapplication.Mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	
	public Integer addUser() {
		User user = new User();
		user.setName("spring boot");
		user.setPassword("password");
		return userMapper.insert(user);
	}
}
