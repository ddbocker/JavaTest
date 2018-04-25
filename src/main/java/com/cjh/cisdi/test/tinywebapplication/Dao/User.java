package com.cjh.cisdi.test.tinywebapplication.Dao;

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
    
    public static void main( String[] args )
    {
//    	 args = new String[] { "-configfile", "src\\main\\resources\\generator.xml", "-overwrite" };
//	        ShellRunner.main(args);
    	String filePath = "C:\\Users\\1606020155.xlsx";
    	InputStream is = new FileInputStream(filePath);
    	XSSFWorkbook wb = new XSSFWorkbook(is);
    	XSSFSheet sheet = wb.getSheetAt(0);
    	Row row=sheet.getRow(2);
    	Cell cell=row.getCell(3);
    	System.out.println(cell.getDateCellValue());
    }
}