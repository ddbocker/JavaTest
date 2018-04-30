package com.cjh.cisdi.test.tinywebapplication.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataAnalyzeExample {
    /**
     * data_analyze
     */
    protected String orderByClause;

    /**
     * data_analyze
     */
    protected boolean distinct;

    /**
     * data_analyze
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public DataAnalyzeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * data_analyze null
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFileRecordidIsNull() {
            addCriterion("file_recordid is null");
            return (Criteria) this;
        }

        public Criteria andFileRecordidIsNotNull() {
            addCriterion("file_recordid is not null");
            return (Criteria) this;
        }

        public Criteria andFileRecordidEqualTo(Integer value) {
            addCriterion("file_recordid =", value, "fileRecordid");
            return (Criteria) this;
        }

        public Criteria andFileRecordidNotEqualTo(Integer value) {
            addCriterion("file_recordid <>", value, "fileRecordid");
            return (Criteria) this;
        }

        public Criteria andFileRecordidGreaterThan(Integer value) {
            addCriterion("file_recordid >", value, "fileRecordid");
            return (Criteria) this;
        }

        public Criteria andFileRecordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_recordid >=", value, "fileRecordid");
            return (Criteria) this;
        }

        public Criteria andFileRecordidLessThan(Integer value) {
            addCriterion("file_recordid <", value, "fileRecordid");
            return (Criteria) this;
        }

        public Criteria andFileRecordidLessThanOrEqualTo(Integer value) {
            addCriterion("file_recordid <=", value, "fileRecordid");
            return (Criteria) this;
        }

        public Criteria andFileRecordidIn(List<Integer> values) {
            addCriterion("file_recordid in", values, "fileRecordid");
            return (Criteria) this;
        }

        public Criteria andFileRecordidNotIn(List<Integer> values) {
            addCriterion("file_recordid not in", values, "fileRecordid");
            return (Criteria) this;
        }

        public Criteria andFileRecordidBetween(Integer value1, Integer value2) {
            addCriterion("file_recordid between", value1, value2, "fileRecordid");
            return (Criteria) this;
        }

        public Criteria andFileRecordidNotBetween(Integer value1, Integer value2) {
            addCriterion("file_recordid not between", value1, value2, "fileRecordid");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNull() {
            addCriterion("column_name is null");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNotNull() {
            addCriterion("column_name is not null");
            return (Criteria) this;
        }

        public Criteria andColumnNameEqualTo(String value) {
            addCriterion("column_name =", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotEqualTo(String value) {
            addCriterion("column_name <>", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThan(String value) {
            addCriterion("column_name >", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("column_name >=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThan(String value) {
            addCriterion("column_name <", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThanOrEqualTo(String value) {
            addCriterion("column_name <=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLike(String value) {
            addCriterion("column_name like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotLike(String value) {
            addCriterion("column_name not like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameIn(List<String> values) {
            addCriterion("column_name in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotIn(List<String> values) {
            addCriterion("column_name not in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameBetween(String value1, String value2) {
            addCriterion("column_name between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotBetween(String value1, String value2) {
            addCriterion("column_name not between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNull() {
            addCriterion("column_type is null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNotNull() {
            addCriterion("column_type is not null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeEqualTo(Integer value) {
            addCriterion("column_type =", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotEqualTo(Integer value) {
            addCriterion("column_type <>", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThan(Integer value) {
            addCriterion("column_type >", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("column_type >=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThan(Integer value) {
            addCriterion("column_type <", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThanOrEqualTo(Integer value) {
            addCriterion("column_type <=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIn(List<Integer> values) {
            addCriterion("column_type in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotIn(List<Integer> values) {
            addCriterion("column_type not in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeBetween(Integer value1, Integer value2) {
            addCriterion("column_type between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("column_type not between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andAvgIsNull() {
            addCriterion("avg is null");
            return (Criteria) this;
        }

        public Criteria andAvgIsNotNull() {
            addCriterion("avg is not null");
            return (Criteria) this;
        }

        public Criteria andAvgEqualTo(BigDecimal value) {
            addCriterion("avg =", value, "avg");
            return (Criteria) this;
        }

        public Criteria andAvgNotEqualTo(BigDecimal value) {
            addCriterion("avg <>", value, "avg");
            return (Criteria) this;
        }

        public Criteria andAvgGreaterThan(BigDecimal value) {
            addCriterion("avg >", value, "avg");
            return (Criteria) this;
        }

        public Criteria andAvgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("avg >=", value, "avg");
            return (Criteria) this;
        }

        public Criteria andAvgLessThan(BigDecimal value) {
            addCriterion("avg <", value, "avg");
            return (Criteria) this;
        }

        public Criteria andAvgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("avg <=", value, "avg");
            return (Criteria) this;
        }

        public Criteria andAvgIn(List<BigDecimal> values) {
            addCriterion("avg in", values, "avg");
            return (Criteria) this;
        }

        public Criteria andAvgNotIn(List<BigDecimal> values) {
            addCriterion("avg not in", values, "avg");
            return (Criteria) this;
        }

        public Criteria andAvgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg between", value1, value2, "avg");
            return (Criteria) this;
        }

        public Criteria andAvgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg not between", value1, value2, "avg");
            return (Criteria) this;
        }

        public Criteria andStdIsNull() {
            addCriterion("std is null");
            return (Criteria) this;
        }

        public Criteria andStdIsNotNull() {
            addCriterion("std is not null");
            return (Criteria) this;
        }

        public Criteria andStdEqualTo(BigDecimal value) {
            addCriterion("std =", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotEqualTo(BigDecimal value) {
            addCriterion("std <>", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdGreaterThan(BigDecimal value) {
            addCriterion("std >", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("std >=", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdLessThan(BigDecimal value) {
            addCriterion("std <", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("std <=", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdIn(List<BigDecimal> values) {
            addCriterion("std in", values, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotIn(List<BigDecimal> values) {
            addCriterion("std not in", values, "std");
            return (Criteria) this;
        }

        public Criteria andStdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("std between", value1, value2, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("std not between", value1, value2, "std");
            return (Criteria) this;
        }

        public Criteria andNsIsNull() {
            addCriterion("ns is null");
            return (Criteria) this;
        }

        public Criteria andNsIsNotNull() {
            addCriterion("ns is not null");
            return (Criteria) this;
        }

        public Criteria andNsEqualTo(Integer value) {
            addCriterion("ns =", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsNotEqualTo(Integer value) {
            addCriterion("ns <>", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsGreaterThan(Integer value) {
            addCriterion("ns >", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ns >=", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsLessThan(Integer value) {
            addCriterion("ns <", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsLessThanOrEqualTo(Integer value) {
            addCriterion("ns <=", value, "ns");
            return (Criteria) this;
        }

        public Criteria andNsIn(List<Integer> values) {
            addCriterion("ns in", values, "ns");
            return (Criteria) this;
        }

        public Criteria andNsNotIn(List<Integer> values) {
            addCriterion("ns not in", values, "ns");
            return (Criteria) this;
        }

        public Criteria andNsBetween(Integer value1, Integer value2) {
            addCriterion("ns between", value1, value2, "ns");
            return (Criteria) this;
        }

        public Criteria andNsNotBetween(Integer value1, Integer value2) {
            addCriterion("ns not between", value1, value2, "ns");
            return (Criteria) this;
        }

        public Criteria andFactorIsNull() {
            addCriterion("factor is null");
            return (Criteria) this;
        }

        public Criteria andFactorIsNotNull() {
            addCriterion("factor is not null");
            return (Criteria) this;
        }

        public Criteria andFactorEqualTo(Integer value) {
            addCriterion("factor =", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorNotEqualTo(Integer value) {
            addCriterion("factor <>", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorGreaterThan(Integer value) {
            addCriterion("factor >", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorGreaterThanOrEqualTo(Integer value) {
            addCriterion("factor >=", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorLessThan(Integer value) {
            addCriterion("factor <", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorLessThanOrEqualTo(Integer value) {
            addCriterion("factor <=", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorIn(List<Integer> values) {
            addCriterion("factor in", values, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorNotIn(List<Integer> values) {
            addCriterion("factor not in", values, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorBetween(Integer value1, Integer value2) {
            addCriterion("factor between", value1, value2, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorNotBetween(Integer value1, Integer value2) {
            addCriterion("factor not between", value1, value2, "factor");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    /**
     * data_analyze
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * data_analyze null
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}