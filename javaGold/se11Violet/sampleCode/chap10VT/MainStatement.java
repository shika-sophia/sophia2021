/**
 * @title javaGold / se11Violet / sampleCode / chap10VT / MainStatement.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第10章 JDBC / List 10-8
 * @content Statement.getUpdateCount()
 * @author shika
 * @date 2021-04-13
 */
package javaGold.se11Violet.sampleCode.chap10VT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainStatement {

    public static void main(String[] args) {
        String sqlInsert =
                "INSERT INTO JAVAGOLD (NAME, ADDRESS, TEL) " +
                "VALUES( ?, ?, ? )";
        String sqlSelect =
                "SELECT * FROM JAVAGOLD " +
                "WHERE CODE = ?";

        try(Connection conn = DbAccess.getConnect();
            PreparedStatement psInsert =
                conn.prepareStatement(sqlInsert);
            PreparedStatement psSelect =
                conn.prepareStatement(sqlSelect);) {

            psInsert.setString(1, "PLANNING");
            psInsert.setString(2, "KYOTO");
            psInsert.setString(3, "075-777-xxxx");

            psSelect.setInt(1, 6);

            show(psInsert);
            show(psSelect);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//main()

    private static void show(PreparedStatement ps)
            throws SQLException {
        boolean isResultSet = ps.execute();

        if(isResultSet) {
            ResultSet rs = ps.getResultSet();
            rs.next();
            System.out.println("検索結果: " + rs.getString(2));
        } else {
            int affected = ps.getUpdateCount();
            System.out.println("更新行数: " + affected);
        }
    }//show()

}//class

/*
更新行数: 1
検索結果: PLANNING

select * from javagold;
+------+-----------+----------+--------------+
| code | name      | address  | tel          |
+------+-----------+----------+--------------+
|    1 | SALES     | TOKYO    | 03-3333-XXXX |
|    2 | ENGINEER  | YOKOHAMA | O45-555-XXXX |
|    3 | DEVEROP   | OSAKA    | NULL         |
|    4 | MAKETING  | FUKUOKA  | 092-222-XXXX |
|    5 | EDUCATION | TOKYO    | NULL         |
|    6 | PLANNING  | KYOTO    | 075-777-xxxx |
+------+-----------+----------+--------------+
*/