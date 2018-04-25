package com.cjh.cisdi.test.tinywebapplication.Dao;

import java.io.Serializable;
import java.util.Date;

public class DataRecord implements Serializable {
    private Integer id;

    private Integer a1;

    private Integer a2;

    private Integer a3;

    private Integer a4;

    private Integer a5;

    private Integer a6;

    private Integer a7;

    private Integer a8;

    private Integer a9;

    private Integer a10;

    private Integer a11;

    private Integer a12;

    private String quality;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getA1() {
        return a1;
    }

    public void setA1(Integer a1) {
        this.a1 = a1;
    }

    public Integer getA2() {
        return a2;
    }

    public void setA2(Integer a2) {
        this.a2 = a2;
    }

    public Integer getA3() {
        return a3;
    }

    public void setA3(Integer a3) {
        this.a3 = a3;
    }

    public Integer getA4() {
        return a4;
    }

    public void setA4(Integer a4) {
        this.a4 = a4;
    }

    public Integer getA5() {
        return a5;
    }

    public void setA5(Integer a5) {
        this.a5 = a5;
    }

    public Integer getA6() {
        return a6;
    }

    public void setA6(Integer a6) {
        this.a6 = a6;
    }

    public Integer getA7() {
        return a7;
    }

    public void setA7(Integer a7) {
        this.a7 = a7;
    }

    public Integer getA8() {
        return a8;
    }

    public void setA8(Integer a8) {
        this.a8 = a8;
    }

    public Integer getA9() {
        return a9;
    }

    public void setA9(Integer a9) {
        this.a9 = a9;
    }

    public Integer getA10() {
        return a10;
    }

    public void setA10(Integer a10) {
        this.a10 = a10;
    }

    public Integer getA11() {
        return a11;
    }

    public void setA11(Integer a11) {
        this.a11 = a11;
    }

    public Integer getA12() {
        return a12;
    }

    public void setA12(Integer a12) {
        this.a12 = a12;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
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