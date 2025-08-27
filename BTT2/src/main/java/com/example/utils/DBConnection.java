package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static String jdbcURL = "jdbc:mysql://localhost:3306/estate";
    public static String dbUser = "root";
    public static String dbPassword = "AMK1JJ9786abcd_";
    
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            return connection;
        } catch (Exception e) {
            System.out.println(" Lỗi kết nối MySQL:");
            e.printStackTrace();
        }
 
    	return null;
    }
}
