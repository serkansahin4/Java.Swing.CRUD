package com.serkansahin.crud.DbProviders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDatabase {
    private String uName="root";
    private String password="123456";
    private String databaseUrl="jdbc:mysql://localhost:3306/world";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(databaseUrl,uName,password);
    }
}
