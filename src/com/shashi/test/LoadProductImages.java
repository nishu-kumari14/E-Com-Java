package com.shashi.test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LoadProductImages {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/shopping-cart?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String username = "shoppingcart";
            String password = "shopping123";
            String driver = "com.mysql.cj.jdbc.Driver";
            
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            
            // Map product IDs to image files
            String[][] productImages = {
                {"P001", "samsung.jpg"},
                {"P002", "phone1.jpg"},
                {"P003", "laptop.png"},
                {"P004", "laptop.png"},
                {"P005", "speaker.jpg"}
            };
            
            String imagesPath = "/Users/hemanthpalagani/Downloads/shopping-cart-master/WebContent/images/";
            
            PreparedStatement ps = con.prepareStatement("UPDATE product SET image = ? WHERE pid = ?");
            
            for (String[] productImage : productImages) {
                String pid = productImage[0];
                String imageName = productImage[1];
                
                File imageFile = new File(imagesPath + imageName);
                if (imageFile.exists()) {
                    FileInputStream fis = new FileInputStream(imageFile);
                    ps.setBinaryStream(1, fis, (int) imageFile.length());
                    ps.setString(2, pid);
                    ps.executeUpdate();
                    fis.close();
                    System.out.println("Updated image for product: " + pid + " with " + imageName);
                } else {
                    System.out.println("Image file not found: " + imageName);
                }
            }
            
            ps.close();
            con.close();
            System.out.println("All product images updated successfully!");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
