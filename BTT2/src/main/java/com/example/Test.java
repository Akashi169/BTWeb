package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
	 public static void main(String[] args) {
	        String jdbcURL = "jdbc:mysql://localhost:3306/estate";
	        String dbUser = "root";
	        String dbPassword = "AMK1JJ9786abcd_";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");


	            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

	            if (connection != null) {
	                System.out.println(" Kết nối MySQL thành công!");
	                connection.close();
	            }
	        } catch (Exception e) {
	            System.out.println(" Lỗi kết nối MySQL:");
	            e.printStackTrace();
	        }
	    }

}
