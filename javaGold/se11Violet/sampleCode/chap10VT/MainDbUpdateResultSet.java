/**
 * @title javaGold / se11Violet / sampleCode / chap10VT / MainScrollResultSet.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第10章 JDBC / List 10-13
 * @content ResultSetの拡張 /
 * 			SCROLL: 逆方向にも移動可
 * 			CONCUR: ResultSetの変更可能か
 * 			TYPE_SCROLL_INSENSITIVE: スクロール可、変更をDBに反映しない
 * 			CONCUR_UPDATABLE: ResultSetの編集可
 * @see MainScrollResultSet.java
 * @see MainAbsoluteReaultSet.java
 * @author shika
 * @date 2021-04-14
 */
package javaGold.se11Violet.sampleCode.chap10VT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainDbUpdateResultSet {

    public static void main(String[] args) {
        String sql =
            "SELECT CODE, NAME, ADDRESS, TEL FROM JAVAGOLD " +
            "WHERE CODE = 4";
        try(Connection conn = DbAccess.getConnect();
            PreparedStatement ps = conn.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE); ){
            ResultSet rs = ps.executeQuery();

            //4行目の変更
            if(rs.next()) {
                System.out.println(
                    rs.getString("NAME") +": " + rs.getString("ADDRESS"));
            }

            rs.updateString(3, "CHIBA");
            rs.updateNull(4);
            rs.updateRow();
            System.out.println(
                rs.getString("NAME") +": " + rs.getString("ADDRESS"));

            //行の挿入
            rs.moveToInsertRow();
            rs.updateString(2, "RESEARCH");
            rs.updateString(3, "NAGOYA");
            rs.insertRow();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
MARKTING: FUKUOKA
MARKTING: CHIBA

(past) SELECT * FROM JAVAGOLD;
+------+-----------+----------+--------------+
| code | name      | address  | tel          |
+------+-----------+----------+--------------+
|    1 | SALES     | TOKYO    | 03-3333-XXXX |
|    2 | ENGINEER  | YOKOHAMA | O45-555-XXXX |
|    3 | DEVEROP   | OSAKA    | NULL         |
|    4 | MAKETING  | FUKUOKA  | 092-222-XXXX |
|    5 | EDUCATION | TOKYO    | NULL         |
|    6 | PLANNING  | KYOTO    | 075-777-xxxx |
|    7 | SUPPORT   | NARA     | NULL         |
+------+-----------+----------+--------------+

(now) SELECT * FROM JAVAGOLD;
+------+-----------+----------+--------------+
| code | name      | address  | tel          |
+------+-----------+----------+--------------+
|    1 | SALES     | TOKYO    | 03-3333-XXXX |
|    2 | ENGINEER  | YOKOHAMA | O45-555-XXXX |
|    3 | DEVEROP   | OSAKA    | NULL         |
|    4 | MARKTING  | CHIBA    | 092-222-XXXX |
|    5 | EDUCATION | TOKYO    | NULL         |
|    6 | PLANNING  | KYOTO    | 075-777-xxxx |
|    7 | SUPPORT   | NARA     | NULL         |
+------+-----------+----------+--------------+

(insert) SELECT * FROM JAVAGOLD;
+------+-----------+----------+--------------+
| code | name      | address  | tel          |
+------+-----------+----------+--------------+
|    1 | SALES     | TOKYO    | 03-3333-XXXX |
|    2 | ENGINEER  | YOKOHAMA | O45-555-XXXX |
|    3 | DEVEROP   | OSAKA    | NULL         |
|    4 | MARKTING  | CHIBA    | NULL         |
|    5 | EDUCATION | TOKYO    | NULL         |
|    6 | PLANNING  | KYOTO    | 075-777-xxxx |
|    7 | SUPPORT   | NARA     | NULL         |
|    8 | RESEARCH  | NAGOYA   | NULL         |
+------+-----------+----------+--------------+

【考察】
ResultSetという JVMメモリ上の仮想テーブルだけ変更するならいいが
元のDBまで書き換わるのは危険なコード。

プログラムにミスがあると、間違えて他の部分を変更してしまったりする。
削除も deleteRow()で可能。

セキュリティ面でも問題があり、DBに Connectionさえできれば、
javaプログラムによって DB内のデータを改変できてしまう。

*/