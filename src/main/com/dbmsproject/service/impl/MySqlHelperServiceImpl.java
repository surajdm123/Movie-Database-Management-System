package com.dbmsproject.service.impl;

import com.dbmsproject.config.MySqlConfig;
import com.dbmsproject.service.MySqlHelperService;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlHelperServiceImpl implements MySqlHelperService {


    /***
     * This method creates a new Connection and returns it.
     *
     * @author Suraj D M
     * @return Connection
     * @throws Exception
     */
    @Override
    public Connection getConnection() throws Exception {

        Class.forName(MySqlConfig.DRIVER_NAME);
        Connection connection = DriverManager.getConnection(MySqlConfig.DATABASE_URL, MySqlConfig.USERNAME, MySqlConfig.PASSWORD);
        return connection;
    }



}
