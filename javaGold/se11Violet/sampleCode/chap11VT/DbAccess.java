package javaGold.se11Violet.sampleCode.chap11VT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAccess {
    private static Connection conn;

    public static Connection getConnect() {
        String dbUrl = "jdbc:mysql://localhost:3306/practice?serverTimezone=JST";
        String user = "root";
        String pass = "root";

        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }//getConnect()

    public static void close() {
        try {
            if(conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//close()
}//class
