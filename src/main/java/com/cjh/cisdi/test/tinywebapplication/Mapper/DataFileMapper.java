package com.cjh.cisdi.test.tinywebapplication.mapper;

import com.cjh.cisdi.test.tinywebapplication.dao.DataFile;
import com.cjh.cisdi.test.tinywebapplication.dao.DataFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataFileMapper {
    int countByExample(DataFileExample example);

    int deleteByExample(DataFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataFile record);

    int insertSelective(DataFile record);

    List<DataFile> selectByExample(DataFileExample example);

    DataFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataFile record, @Param("example") DataFileExample example);

    int updateByExample(@Param("record") DataFile record, @Param("example") DataFileExample example);

    int updateByPrimaryKeySelective(DataFile record);

    int updateByPrimaryKey(DataFile record);
}