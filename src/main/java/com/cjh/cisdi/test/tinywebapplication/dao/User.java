package com.cjh.cisdi.test.tinywebapplication.dao;

import java.io.IOException;
import java.io.Serializable;

import org.mybatis.generator.api.ShellRunner;

public class User implements Serializable {
    private Integer id;

    private String name;

    private String password;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
    public static void main( String[] args ) throws IOException
    {
    	 args = new String[] { "-configfile", "src\\main\\resources\\generator.xml", "-overwrite" };
	        ShellRunner.main(args);
    }
}