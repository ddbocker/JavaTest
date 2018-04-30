package com.cjh.cisdi.test.tinywebapplication.mapper;

import com.cjh.cisdi.test.tinywebapplication.dao.DataAnalyze;
import com.cjh.cisdi.test.tinywebapplication.dao.DataAnalyzeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataAnalyzeMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DataAnalyzeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DataAnalyzeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(DataAnalyze record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DataAnalyze record);

    /**
     *
     * @mbggenerated
     */
    List<DataAnalyze> selectByExample(DataAnalyzeExample example);

    /**
     *
     * @mbggenerated
     */
    DataAnalyze selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DataAnalyze record, @Param("example") DataAnalyzeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DataAnalyze record, @Param("example") DataAnalyzeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DataAnalyze record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DataAnalyze record);
}