/**
 * @title javaGold / se11Violet / sampleCode / chap10VT / MainScrollResultSet.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第10章 JDBC / List 10-11
 * @content ResultSetの拡張 /
 * 			SCROLL: 逆方向にも移動可
 * 			CONCUR: ResultSetの変更可能か
 * 			TYPE_SCROLL_INSENSITIVE //スクロール可、変更をDBに反映しない
 * 			CONCUR_UPDATABLE        //ResultSetの編集可
 * @see MainAbsoluteReaultSet.java
 * @see MainDbUpdateResultSet.java
 * @author shika
 * @date 2021-04-14
 */
package javaGold.se11Violet.sampleCode.chap10VT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainScrollResultSet {

    public static void main(String[] args) {
        String sql =
            "SELECT CODE, NAME FROM JAVAGOLD " +
            "ORDER BY CODE ASC"; //ASC:昇順, DESC:降順
        try(Connection conn = DbAccess.getConnect();
            PreparedStatement ps = conn.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE); ){
            ResultSet rs = ps.executeQuery();
            rs.last();            //最終行に移動
            System.out.println("最後の行番号: " + rs.getRow());
            rs.afterLast();       //最終行の次に移動

            while(rs.previous()) {//逆方向にスクロール
                System.out.println(
                    rs.getInt("CODE") + ": " + rs.getString("NAME"));
            }//while

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
最後の行番号: 7
7: SUPPORT
6: PLANNING
5: EDUCATION
4: MAKETING
3: DEVEROP
2: ENGINEER
1: SALES

【考察】
ResultSet生成時に CODEの昇順だったものを
最終行から前方向に読み取って降順に表示。
元のＤＢには反映していない。

SELECT * FROM JAVAGOLD;
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
*/