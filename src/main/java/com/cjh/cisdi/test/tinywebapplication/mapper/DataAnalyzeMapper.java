package com.cjh.cisdi.test.tinywebapplication.mapper;

import com.cjh.cisdi.test.tinywebapplication.dao.DataAnalyze;
import com.cjh.cisdi.test.tinywebapplication.dao.DataAnalyzeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataAnalyzeMapper {
    int countByExample(DataAnalyzeExample example);

    int deleteByExample(DataAnalyzeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataAnalyze record);

    int insertSelective(DataAnalyze record);

    List<DataAnalyze> selectByExample(DataAnalyzeExample example);

    DataAnalyze selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataAnalyze record, @Param("example") DataAnalyzeExample example);

    int updateByExample(@Param("record") DataAnalyze record, @Param("example") DataAnalyzeExample example);

    int updateByPrimaryKeySelective(DataAnalyze record);

    int updateByPrimaryKey(DataAnalyze record);
}