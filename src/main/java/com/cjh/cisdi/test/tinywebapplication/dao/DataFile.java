package com.cjh.cisdi.test.tinywebapplication.dao;

import java.io.Serializable;
import java.util.Date;

public class DataFile implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 上传文件名
     */
    private String filename;

    /**
     * 文件类型
     */
    private String filetype;

    /**
     * 文件大小
     */
    private Long filesize;

    /**
     * 文件全路径
     */
    private String filepath;

    /**
     * 保存文件名
     */
    private String newfilename;

    /**
     * 操作人id
     */
    private Integer managerid;

    /**
     * 操作人姓名
     */
    private String managername;

    /**
     * 0：处理中，1：处理成功，2：处理失败
     */
    private Integer status;

    /**
     * 描述
     */
    private String data;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Date updatetime;

    /**
     * data_file
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
     * 上传文件名
     * @return filename 上传文件名
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 上传文件名
     * @param filename 上传文件名
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * 文件类型
     * @return filetype 文件类型
     */
    public String getFiletype() {
        return filetype;
    }

    /**
     * 文件类型
     * @param filetype 文件类型
     */
    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    /**
     * 文件大小
     * @return filesize 文件大小
     */
    public Long getFilesize() {
        return filesize;
    }

    /**
     * 文件大小
     * @param filesize 文件大小
     */
    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    /**
     * 文件全路径
     * @return filepath 文件全路径
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * 文件全路径
     * @param filepath 文件全路径
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    /**
     * 保存文件名
     * @return newfilename 保存文件名
     */
    public String getNewfilename() {
        return newfilename;
    }

    /**
     * 保存文件名
     * @param newfilename 保存文件名
     */
    public void setNewfilename(String newfilename) {
        this.newfilename = newfilename == null ? null : newfilename.trim();
    }

    /**
     * 操作人id
     * @return managerid 操作人id
     */
    public Integer getManagerid() {
        return managerid;
    }

    /**
     * 操作人id
     * @param managerid 操作人id
     */
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    /**
     * 操作人姓名
     * @return managername 操作人姓名
     */
    public String getManagername() {
        return managername;
    }

    /**
     * 操作人姓名
     * @param managername 操作人姓名
     */
    public void setManagername(String managername) {
        this.managername = managername == null ? null : managername.trim();
    }

    /**
     * 0：处理中，1：处理成功，2：处理失败
     * @return status 0：处理中，1：处理成功，2：处理失败
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 0：处理中，1：处理成功，2：处理失败
     * @param status 0：处理中，1：处理成功，2：处理失败
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 描述
     * @return data 描述
     */
    public String getData() {
        return data;
    }

    /**
     * 描述
     * @param data 描述
     */
    public void setData(String data) {
        this.data = data == null ? null : data.trim();
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