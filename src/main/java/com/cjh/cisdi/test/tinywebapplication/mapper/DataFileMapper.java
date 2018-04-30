package com.cjh.cisdi.test.tinywebapplication.mapper;

import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataFileMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DataFileExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DataFileExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(DataFile record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DataFile record);

    /**
     *
     * @mbggenerated
     */
    List<DataFile> selectByExample(DataFileExample example);

    /**
     *
     * @mbggenerated
     */
    DataFile selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DataFile record, @Param("example") DataFileExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DataFile record, @Param("example") DataFileExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DataFile record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DataFile record);
}