package com.cjh.cisdi.test.tinywebapplication.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andA1IsNull() {
            addCriterion("a1 is null");
            return (Criteria) this;
        }

        public Criteria andA1IsNotNull() {
            addCriterion("a1 is not null");
            return (Criteria) this;
        }

        public Criteria andA1EqualTo(BigDecimal value) {
            addCriterion("a1 =", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotEqualTo(BigDecimal value) {
            addCriterion("a1 <>", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1GreaterThan(BigDecimal value) {
            addCriterion("a1 >", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a1 >=", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1LessThan(BigDecimal value) {
            addCriterion("a1 <", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a1 <=", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1In(List<BigDecimal> values) {
            addCriterion("a1 in", values, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotIn(List<BigDecimal> values) {
            addCriterion("a1 not in", values, "a1");
            return (Criteria) this;
        }

        public Criteria andA1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a1 between", value1, value2, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a1 not between", value1, value2, "a1");
            return (Criteria) this;
        }

        public Criteria andA2IsNull() {
            addCriterion("a2 is null");
            return (Criteria) this;
        }

        public Criteria andA2IsNotNull() {
            addCriterion("a2 is not null");
            return (Criteria) this;
        }

        public Criteria andA2EqualTo(BigDecimal value) {
            addCriterion("a2 =", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotEqualTo(BigDecimal value) {
            addCriterion("a2 <>", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2GreaterThan(BigDecimal value) {
            addCriterion("a2 >", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a2 >=", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2LessThan(BigDecimal value) {
            addCriterion("a2 <", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a2 <=", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2In(List<BigDecimal> values) {
            addCriterion("a2 in", values, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotIn(List<BigDecimal> values) {
            addCriterion("a2 not in", values, "a2");
            return (Criteria) this;
        }

        public Criteria andA2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a2 between", value1, value2, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a2 not between", value1, value2, "a2");
            return (Criteria) this;
        }

        public Criteria andA3IsNull() {
            addCriterion("a3 is null");
            return (Criteria) this;
        }

        public Criteria andA3IsNotNull() {
            addCriterion("a3 is not null");
            return (Criteria) this;
        }

        public Criteria andA3EqualTo(BigDecimal value) {
            addCriterion("a3 =", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotEqualTo(BigDecimal value) {
            addCriterion("a3 <>", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3GreaterThan(BigDecimal value) {
            addCriterion("a3 >", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a3 >=", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3LessThan(BigDecimal value) {
            addCriterion("a3 <", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a3 <=", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3In(List<BigDecimal> values) {
            addCriterion("a3 in", values, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotIn(List<BigDecimal> values) {
            addCriterion("a3 not in", values, "a3");
            return (Criteria) this;
        }

        public Criteria andA3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a3 between", value1, value2, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a3 not between", value1, value2, "a3");
            return (Criteria) this;
        }

        public Criteria andA4IsNull() {
            addCriterion("a4 is null");
            return (Criteria) this;
        }

        public Criteria andA4IsNotNull() {
            addCriterion("a4 is not null");
            return (Criteria) this;
        }

        public Criteria andA4EqualTo(BigDecimal value) {
            addCriterion("a4 =", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotEqualTo(BigDecimal value) {
            addCriterion("a4 <>", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4GreaterThan(BigDecimal value) {
            addCriterion("a4 >", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a4 >=", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4LessThan(BigDecimal value) {
            addCriterion("a4 <", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a4 <=", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4In(List<BigDecimal> values) {
            addCriterion("a4 in", values, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotIn(List<BigDecimal> values) {
            addCriterion("a4 not in", values, "a4");
            return (Criteria) this;
        }

        public Criteria andA4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a4 between", value1, value2, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a4 not between", value1, value2, "a4");
            return (Criteria) this;
        }

        public Criteria andA5IsNull() {
            addCriterion("a5 is null");
            return (Criteria) this;
        }

        public Criteria andA5IsNotNull() {
            addCriterion("a5 is not null");
            return (Criteria) this;
        }

        public Criteria andA5EqualTo(BigDecimal value) {
            addCriterion("a5 =", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5NotEqualTo(BigDecimal value) {
            addCriterion("a5 <>", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5GreaterThan(BigDecimal value) {
            addCriterion("a5 >", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a5 >=", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5LessThan(BigDecimal value) {
            addCriterion("a5 <", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a5 <=", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5In(List<BigDecimal> values) {
            addCriterion("a5 in", values, "a5");
            return (Criteria) this;
        }

        public Criteria andA5NotIn(List<BigDecimal> values) {
            addCriterion("a5 not in", values, "a5");
            return (Criteria) this;
        }

        public Criteria andA5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a5 between", value1, value2, "a5");
            return (Criteria) this;
        }

        public Criteria andA5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a5 not between", value1, value2, "a5");
            return (Criteria) this;
        }

        public Criteria andA6IsNull() {
            addCriterion("a6 is null");
            return (Criteria) this;
        }

        public Criteria andA6IsNotNull() {
            addCriterion("a6 is not null");
            return (Criteria) this;
        }

        public Criteria andA6EqualTo(BigDecimal value) {
            addCriterion("a6 =", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6NotEqualTo(BigDecimal value) {
            addCriterion("a6 <>", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6GreaterThan(BigDecimal value) {
            addCriterion("a6 >", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a6 >=", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6LessThan(BigDecimal value) {
            addCriterion("a6 <", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a6 <=", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6In(List<BigDecimal> values) {
            addCriterion("a6 in", values, "a6");
            return (Criteria) this;
        }

        public Criteria andA6NotIn(List<BigDecimal> values) {
            addCriterion("a6 not in", values, "a6");
            return (Criteria) this;
        }

        public Criteria andA6Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a6 between", value1, value2, "a6");
            return (Criteria) this;
        }

        public Criteria andA6NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a6 not between", value1, value2, "a6");
            return (Criteria) this;
        }

        public Criteria andA7IsNull() {
            addCriterion("a7 is null");
            return (Criteria) this;
        }

        public Criteria andA7IsNotNull() {
            addCriterion("a7 is not null");
            return (Criteria) this;
        }

        public Criteria andA7EqualTo(BigDecimal value) {
            addCriterion("a7 =", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7NotEqualTo(BigDecimal value) {
            addCriterion("a7 <>", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7GreaterThan(BigDecimal value) {
            addCriterion("a7 >", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a7 >=", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7LessThan(BigDecimal value) {
            addCriterion("a7 <", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a7 <=", value, "a7");
            return (Criteria) this;
        }

        public Criteria andA7In(List<BigDecimal> values) {
            addCriterion("a7 in", values, "a7");
            return (Criteria) this;
        }

        public Criteria andA7NotIn(List<BigDecimal> values) {
            addCriterion("a7 not in", values, "a7");
            return (Criteria) this;
        }

        public Criteria andA7Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a7 between", value1, value2, "a7");
            return (Criteria) this;
        }

        public Criteria andA7NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a7 not between", value1, value2, "a7");
            return (Criteria) this;
        }

        public Criteria andA8IsNull() {
            addCriterion("a8 is null");
            return (Criteria) this;
        }

        public Criteria andA8IsNotNull() {
            addCriterion("a8 is not null");
            return (Criteria) this;
        }

        public Criteria andA8EqualTo(BigDecimal value) {
            addCriterion("a8 =", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8NotEqualTo(BigDecimal value) {
            addCriterion("a8 <>", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8GreaterThan(BigDecimal value) {
            addCriterion("a8 >", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a8 >=", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8LessThan(BigDecimal value) {
            addCriterion("a8 <", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a8 <=", value, "a8");
            return (Criteria) this;
        }

        public Criteria andA8In(List<BigDecimal> values) {
            addCriterion("a8 in", values, "a8");
            return (Criteria) this;
        }

        public Criteria andA8NotIn(List<BigDecimal> values) {
            addCriterion("a8 not in", values, "a8");
            return (Criteria) this;
        }

        public Criteria andA8Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a8 between", value1, value2, "a8");
            return (Criteria) this;
        }

        public Criteria andA8NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a8 not between", value1, value2, "a8");
            return (Criteria) this;
        }

        public Criteria andA9IsNull() {
            addCriterion("a9 is null");
            return (Criteria) this;
        }

        public Criteria andA9IsNotNull() {
            addCriterion("a9 is not null");
            return (Criteria) this;
        }

        public Criteria andA9EqualTo(BigDecimal value) {
            addCriterion("a9 =", value, "a9");
            return (Criteria) this;
        }

        public Criteria andA9NotEqualTo(BigDecimal value) {
            addCriterion("a9 <>", value, "a9");
            return (Criteria) this;
        }

        public Criteria andA9GreaterThan(BigDecimal value) {
            addCriterion("a9 >", value, "a9");
            return (Criteria) this;
        }

        public Criteria andA9GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a9 >=", value, "a9");
            return (Criteria) this;
        }

        public Criteria andA9LessThan(BigDecimal value) {
            addCriterion("a9 <", value, "a9");
            return (Criteria) this;
        }

        public Criteria andA9LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a9 <=", value, "a9");
            return (Criteria) this;
        }

        public Criteria andA9In(List<BigDecimal> values) {
            addCriterion("a9 in", values, "a9");
            return (Criteria) this;
        }

        public Criteria andA9NotIn(List<BigDecimal> values) {
            addCriterion("a9 not in", values, "a9");
            return (Criteria) this;
        }

        public Criteria andA9Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a9 between", value1, value2, "a9");
            return (Criteria) this;
        }

        public Criteria andA9NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a9 not between", value1, value2, "a9");
            return (Criteria) this;
        }

        public Criteria andA10IsNull() {
            addCriterion("a10 is null");
            return (Criteria) this;
        }

        public Criteria andA10IsNotNull() {
            addCriterion("a10 is not null");
            return (Criteria) this;
        }

        public Criteria andA10EqualTo(BigDecimal value) {
            addCriterion("a10 =", value, "a10");
            return (Criteria) this;
        }

        public Criteria andA10NotEqualTo(BigDecimal value) {
            addCriterion("a10 <>", value, "a10");
            return (Criteria) this;
        }

        public Criteria andA10GreaterThan(BigDecimal value) {
            addCriterion("a10 >", value, "a10");
            return (Criteria) this;
        }

        public Criteria andA10GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a10 >=", value, "a10");
            return (Criteria) this;
        }

        public Criteria andA10LessThan(BigDecimal value) {
            addCriterion("a10 <", value, "a10");
            return (Criteria) this;
        }

        public Criteria andA10LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a10 <=", value, "a10");
            return (Criteria) this;
        }

        public Criteria andA10In(List<BigDecimal> values) {
            addCriterion("a10 in", values, "a10");
            return (Criteria) this;
        }

        public Criteria andA10NotIn(List<BigDecimal> values) {
            addCriterion("a10 not in", values, "a10");
            return (Criteria) this;
        }

        public Criteria andA10Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a10 between", value1, value2, "a10");
            return (Criteria) this;
        }

        public Criteria andA10NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a10 not between", value1, value2, "a10");
            return (Criteria) this;
        }

        public Criteria andA11IsNull() {
            addCriterion("a11 is null");
            return (Criteria) this;
        }

        public Criteria andA11IsNotNull() {
            addCriterion("a11 is not null");
            return (Criteria) this;
        }

        public Criteria andA11EqualTo(BigDecimal value) {
            addCriterion("a11 =", value, "a11");
            return (Criteria) this;
        }

        public Criteria andA11NotEqualTo(BigDecimal value) {
            addCriterion("a11 <>", value, "a11");
            return (Criteria) this;
        }

        public Criteria andA11GreaterThan(BigDecimal value) {
            addCriterion("a11 >", value, "a11");
            return (Criteria) this;
        }

        public Criteria andA11GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a11 >=", value, "a11");
            return (Criteria) this;
        }

        public Criteria andA11LessThan(BigDecimal value) {
            addCriterion("a11 <", value, "a11");
            return (Criteria) this;
        }

        public Criteria andA11LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a11 <=", value, "a11");
            return (Criteria) this;
        }

        public Criteria andA11In(List<BigDecimal> values) {
            addCriterion("a11 in", values, "a11");
            return (Criteria) this;
        }

        public Criteria andA11NotIn(List<BigDecimal> values) {
            addCriterion("a11 not in", values, "a11");
            return (Criteria) this;
        }

        public Criteria andA11Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a11 between", value1, value2, "a11");
            return (Criteria) this;
        }

        public Criteria andA11NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a11 not between", value1, value2, "a11");
            return (Criteria) this;
        }

        public Criteria andA12IsNull() {
            addCriterion("a12 is null");
            return (Criteria) this;
        }

        public Criteria andA12IsNotNull() {
            addCriterion("a12 is not null");
            return (Criteria) this;
        }

        public Criteria andA12EqualTo(BigDecimal value) {
            addCriterion("a12 =", value, "a12");
            return (Criteria) this;
        }

        public Criteria andA12NotEqualTo(BigDecimal value) {
            addCriterion("a12 <>", value, "a12");
            return (Criteria) this;
        }

        public Criteria andA12GreaterThan(BigDecimal value) {
            addCriterion("a12 >", value, "a12");
            return (Criteria) this;
        }

        public Criteria andA12GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("a12 >=", value, "a12");
            return (Criteria) this;
        }

        public Criteria andA12LessThan(BigDecimal value) {
            addCriterion("a12 <", value, "a12");
            return (Criteria) this;
        }

        public Criteria andA12LessThanOrEqualTo(BigDecimal value) {
            addCriterion("a12 <=", value, "a12");
            return (Criteria) this;
        }

        public Criteria andA12In(List<BigDecimal> values) {
            addCriterion("a12 in", values, "a12");
            return (Criteria) this;
        }

        public Criteria andA12NotIn(List<BigDecimal> values) {
            addCriterion("a12 not in", values, "a12");
            return (Criteria) this;
        }

        public Criteria andA12Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("a12 between", value1, value2, "a12");
            return (Criteria) this;
        }

        public Criteria andA12NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("a12 not between", value1, value2, "a12");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(String value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(String value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(String value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(String value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(String value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(String value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLike(String value) {
            addCriterion("quality like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotLike(String value) {
            addCriterion("quality not like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<String> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<String> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(String value1, String value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(String value1, String value2) {
            addCriterion("quality not between", value1, value2, "quality");
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

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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