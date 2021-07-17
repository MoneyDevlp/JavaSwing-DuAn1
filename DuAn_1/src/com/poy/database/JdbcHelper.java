/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class JdbcHelper {
    public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
			"databaseName=DB_QUANLINEMCHUARANPHOCOHANOI; user = sa; password = 123456";
    public static Connection getDBConnect(){
        try {
       Connection con = null;
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       con = DriverManager.getConnection(connectionUrl);
       return con;
       } catch (ClassNotFoundException ex) {
            System.out.println("Where is the driver");
            System.out.println("ERROR: "+ex.toString());
        }
        catch (SQLException e) {
		System.out.println("ERROR: "+e.toString());	
		}
        return null;
    }
     public static PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(connectionUrl);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
