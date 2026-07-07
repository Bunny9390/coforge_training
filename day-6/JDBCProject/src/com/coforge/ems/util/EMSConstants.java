package com.coforge.ems.util;

// This class stores reusable SQL and database constants.
public class EMSConstants {
    public static final String DATABASE_URL = ApplicationProperties.DATABASE_URL;
    public static final String USERNAME = ApplicationProperties.USERNAME;
    public static final String PASSWORD = ApplicationProperties.PASSWORD;

    public static final String INSERT_QUERY = ApplicationProperties.INSERT_EMPLOYEE;
    public static final String UPDATE_QUERY = ApplicationProperties.UPDATE_EMPLOYEE;
    public static final String DELETE_QUERY = ApplicationProperties.DELETE_EMPLOYEE;
    public static final String SELECT_QUERY = ApplicationProperties.FIND_ALL_EMPLOYEES;
    public static final String SELECT_BY_ID = ApplicationProperties.FIND_EMPLOYEE_BY_ID;
    public static final String CREATE_TABLE_QUERY = ApplicationProperties.CREATE_TABLE_SQL;
}
