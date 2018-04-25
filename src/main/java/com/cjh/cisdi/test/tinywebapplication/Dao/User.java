package com.cjh.cisdi.test.tinywebapplication.Dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
//    	 args = new String[] { "-configfile", "src\\main\\resources\\generator.xml", "-overwrite" };
//	        ShellRunner.main(args);
    	String filePath = "D:\\Documents\\Downloads\\1524670058313.xlsx";
    	InputStream is = new FileInputStream(filePath);
    	XSSFWorkbook wb = new XSSFWorkbook(is);
    	XSSFSheet sheet = wb.getSheetAt(0);
    	Row row=sheet.getRow(2);
    	Cell cell=row.getCell(3);
    	System.out.println(cell.getDateCellValue());
    	
    	for(int i=0;i<sheet.getLastRowNum();i++){
            Row row1=sheet.getRow(i);
            System.out.println(row1.getCell(0).getDateCellValue());
        }
    }
}