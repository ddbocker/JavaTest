package com.cjh.cisdi.test.tinywebapplication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author cjh
 *
 */
@SpringBootApplication
@MapperScan("com.cjh.cisdi.test.tinywebapplication.mapper")
public class TinywebapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinywebapplicationApplication.class, args);
	}
}
