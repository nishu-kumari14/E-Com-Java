package com.shashi.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/shopping-cart?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String username = "shoppingcart";
            String password = "shopping123";
            String driver = "com.mysql.cj.jdbc.Driver";
            
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            
            if (con != null) {
                System.out.println("Database connection successful!");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM product");
                if (rs.next()) {
                    System.out.println("Product count: " + rs.getInt(1));
                }
                con.close();
            } else {
                System.out.println("Database connection failed!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
