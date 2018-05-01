package com.cjh.cisdi.test.tinywebapplication.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author cjh
 *
 */
public class DataRecord implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private BigDecimal a1;

    /**
     * 
     */
    private BigDecimal a2;

    /**
     * 
     */
    private BigDecimal a3;

    /**
     * 
     */
    private BigDecimal a4;

    /**
     * 
     */
    private BigDecimal a5;

    /**
     * 
     */
    private BigDecimal a6;

    /**
     * 
     */
    private BigDecimal a7;

    /**
     * 
     */
    private BigDecimal a8;

    /**
     * 
     */
    private BigDecimal a9;

    /**
     * 
     */
    private BigDecimal a10;

    /**
     * 
     */
    private BigDecimal a11;

    /**
     * 
     */
    private BigDecimal a12;

    /**
     * 
     */
    private String quality;

    /**
     * 文件记录id
     */
    private Integer fileRecordid;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Date updatetime;

    /**
     * data_record
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
     * 
     * @return a1 
     */
    public BigDecimal getA1() {
        return a1;
    }

    /**
     * 
     * @param a1 
     */
    public void setA1(BigDecimal a1) {
        this.a1 = a1;
    }

    /**
     * 
     * @return a2 
     */
    public BigDecimal getA2() {
        return a2;
    }

    /**
     * 
     * @param a2 
     */
    public void setA2(BigDecimal a2) {
        this.a2 = a2;
    }

    /**
     * 
     * @return a3 
     */
    public BigDecimal getA3() {
        return a3;
    }

    /**
     * 
     * @param a3 
     */
    public void setA3(BigDecimal a3) {
        this.a3 = a3;
    }

    /**
     * 
     * @return a4 
     */
    public BigDecimal getA4() {
        return a4;
    }

    /**
     * 
     * @param a4 
     */
    public void setA4(BigDecimal a4) {
        this.a4 = a4;
    }

    /**
     * 
     * @return a5 
     */
    public BigDecimal getA5() {
        return a5;
    }

    /**
     * 
     * @param a5 
     */
    public void setA5(BigDecimal a5) {
        this.a5 = a5;
    }

    /**
     * 
     * @return a6 
     */
    public BigDecimal getA6() {
        return a6;
    }

    /**
     * 
     * @param a6 
     */
    public void setA6(BigDecimal a6) {
        this.a6 = a6;
    }

    /**
     * 
     * @return a7 
     */
    public BigDecimal getA7() {
        return a7;
    }

    /**
     * 
     * @param a7 
     */
    public void setA7(BigDecimal a7) {
        this.a7 = a7;
    }

    /**
     * 
     * @return a8 
     */
    public BigDecimal getA8() {
        return a8;
    }

    /**
     * 
     * @param a8 
     */
    public void setA8(BigDecimal a8) {
        this.a8 = a8;
    }

    /**
     * 
     * @return a9 
     */
    public BigDecimal getA9() {
        return a9;
    }

    /**
     * 
     * @param a9 
     */
    public void setA9(BigDecimal a9) {
        this.a9 = a9;
    }

    /**
     * 
     * @return a10 
     */
    public BigDecimal getA10() {
        return a10;
    }

    /**
     * 
     * @param a10 
     */
    public void setA10(BigDecimal a10) {
        this.a10 = a10;
    }

    /**
     * 
     * @return a11 
     */
    public BigDecimal getA11() {
        return a11;
    }

    /**
     * 
     * @param a11 
     */
    public void setA11(BigDecimal a11) {
        this.a11 = a11;
    }

    /**
     * 
     * @return a12 
     */
    public BigDecimal getA12() {
        return a12;
    }

    /**
     * 
     * @param a12 
     */
    public void setA12(BigDecimal a12) {
        this.a12 = a12;
    }

    /**
     * 
     * @return quality 
     */
    public String getQuality() {
        return quality;
    }

    /**
     * 
     * @param quality 
     */
    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
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