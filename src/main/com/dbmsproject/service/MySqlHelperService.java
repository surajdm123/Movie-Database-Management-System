package com.dbmsproject.service;

import java.sql.Connection;

public interface MySqlHelperService {

    public Connection getConnection() throws Exception;

}
