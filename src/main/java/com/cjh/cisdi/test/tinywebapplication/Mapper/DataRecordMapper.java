package com.cjh.cisdi.test.tinywebapplication.Mapper;

import com.cjh.cisdi.test.tinywebapplication.Dao.DataRecord;
import com.cjh.cisdi.test.tinywebapplication.Dao.DataRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataRecordMapper {
    int countByExample(DataRecordExample example);

    int deleteByExample(DataRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataRecord record);

    int insertSelective(DataRecord record);

    List<DataRecord> selectByExample(DataRecordExample example);

    DataRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataRecord record, @Param("example") DataRecordExample example);

    int updateByExample(@Param("record") DataRecord record, @Param("example") DataRecordExample example);

    int updateByPrimaryKeySelective(DataRecord record);

    int updateByPrimaryKey(DataRecord record);
}