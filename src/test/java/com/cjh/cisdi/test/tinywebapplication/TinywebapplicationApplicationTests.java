package com.cjh.cisdi.test.tinywebapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjh.cisdi.test.tinywebapplication.Service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TinywebapplicationApplicationTests {
	@Autowired
	UserServiceImpl userService;

	@Test
	public void contextLoads() {
		userService.addUser();
	}

}
