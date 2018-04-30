package com.cjh.cisdi.test.tinywebapplication.mapper;

import com.cjh.cisdi.test.tinywebapplication.dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.dao.DataRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataRecordMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DataRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DataRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(DataRecord record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DataRecord record);

    /**
     *
     * @mbggenerated
     */
    List<DataRecord> selectByExample(DataRecordExample example);

    /**
     *
     * @mbggenerated
     */
    DataRecord selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DataRecord record, @Param("example") DataRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DataRecord record, @Param("example") DataRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DataRecord record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DataRecord record);
}