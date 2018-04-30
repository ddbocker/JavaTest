package com.cjh.cisdi.test.tinywebapplication.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DataAnalyze implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 文件记录id
     */
    private Integer fileRecordid;

    /**
     * 列名
     */
    private String columnName;

    /**
     * 列类型，0：数字，1：字符
     */
    private Integer columnType;

    /**
     * 平均值
     */
    private BigDecimal avg;

    /**
     * 标准差
     */
    private BigDecimal std;

    /**
     * 离群值
     */
    private Integer ns;

    /**
     * 因子数
     */
    private Integer factor;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Date updatetime;

    /**
     * data_analyze
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 文件记录id
     * @return file_recordid 文件记录id
     */
    public Integer getFileRecordid() {
        return fileRecordid;
    }

    /**
     * 文件记录id
     * @param fileRecordid 文件记录id
     */
    public void setFileRecordid(Integer fileRecordid) {
        this.fileRecordid = fileRecordid;
    }

    /**
     * 列名
     * @return column_name 列名
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 列名
     * @param columnName 列名
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 列类型，0：数字，1：字符
     * @return column_type 列类型，0：数字，1：字符
     */
    public Integer getColumnType() {
        return columnType;
    }

    /**
     * 列类型，0：数字，1：字符
     * @param columnType 列类型，0：数字，1：字符
     */
    public void setColumnType(Integer columnType) {
        this.columnType = columnType;
    }

    /**
     * 平均值
     * @return avg 平均值
     */
    public BigDecimal getAvg() {
        return avg;
    }

    /**
     * 平均值
     * @param avg 平均值
     */
    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    /**
     * 标准差
     * @return std 标准差
     */
    public BigDecimal getStd() {
        return std;
    }

    /**
     * 标准差
     * @param std 标准差
     */
    public void setStd(BigDecimal std) {
        this.std = std;
    }

    /**
     * 离群值
     * @return ns 离群值
     */
    public Integer getNs() {
        return ns;
    }

    /**
     * 离群值
     * @param ns 离群值
     */
    public void setNs(Integer ns) {
        this.ns = ns;
    }

    /**
     * 因子数
     * @return factor 因子数
     */
    public Integer getFactor() {
        return factor;
    }

    /**
     * 因子数
     * @param factor 因子数
     */
    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    /**
     * 
     * @return createtime 
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 
     * @param createtime 
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 
     * @return updatetime 
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 
     * @param updatetime 
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}