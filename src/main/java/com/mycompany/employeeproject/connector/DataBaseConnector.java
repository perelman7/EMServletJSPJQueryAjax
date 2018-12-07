package com.mycompany.employeeproject.connector;

import com.mycompany.employeeproject.util.PropertiesReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.*;

public class DataBaseConnector {
    
    private static final String URL = PropertiesReader.getProperty("urlpostgresql");
    private static final String USERNAME = PropertiesReader.getProperty("username");
    private static final String PASSWORD = PropertiesReader.getProperty("password");
    private static final Logger LOGGER = Logger.getLogger(DataBaseConnector.class);
    
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            LOGGER.error("File of driver not find, " + ex.getMessage());
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}