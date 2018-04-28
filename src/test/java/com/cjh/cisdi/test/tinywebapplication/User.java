package com.cjh.cisdi.test.tinywebapplication;

import java.io.IOException;

import org.mybatis.generator.api.ShellRunner;

public class User {
    public static void main( String[] args ) throws IOException
    {
    	 args = new String[] { "-configfile", "src\\main\\resources\\generator.xml", "-overwrite" };
	        ShellRunner.main(args);
    }
}