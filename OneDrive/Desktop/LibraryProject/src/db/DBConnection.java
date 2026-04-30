package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_db?useSSL=false&serverTimezone=UTC",
                "root",
                "2011"   // your password
            );

            System.out.println("✅ CONNECTED SUCCESSFULLY");
            return con;

        } catch (Exception e) {
            System.out.println("❌ CONNECTION ERROR:");
            e.printStackTrace();
            return null;
        }
    }
}