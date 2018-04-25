package com.cjh.cisdi.test.tinywebapplication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cjh.cisdi.test.tinywebapplication.Mapper")
public class TinywebapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinywebapplicationApplication.class, args);
	}
}
