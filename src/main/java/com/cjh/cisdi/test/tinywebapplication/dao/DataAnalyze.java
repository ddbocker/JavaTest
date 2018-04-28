package com.cjh.cisdi.test.tinywebapplication.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DataAnalyze implements Serializable {
    private Integer id;

    private Integer fileRecordid;

    private String columnName;

    private Integer columnType;

    private BigDecimal avg;

    private BigDecimal std;

    private Integer ns;

    private Integer factor;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFileRecordid() {
        return fileRecordid;
    }

    public void setFileRecordid(Integer fileRecordid) {
        this.fileRecordid = fileRecordid;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public Integer getColumnType() {
        return columnType;
    }

    public void setColumnType(Integer columnType) {
        this.columnType = columnType;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    public BigDecimal getStd() {
        return std;
    }

    public void setStd(BigDecimal std) {
        this.std = std;
    }

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}