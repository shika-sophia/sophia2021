/**
 * @title javaGold / se11Violet / sampleCode / chap10VT / MainScrollResultSet.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第10章 JDBC / List 10-12
 * @content ResultSetの拡張
 * 			rs.absolute(int): 絶対位置の行に移動
 * 			rs.relative(int): 相対位置に +-行移動
 * 			SCROLL: 逆方向にも移動可
 * 			CONCUR: ResultSetの変更可能か
 * 			TYPE_SCROLL_INSENSITIVE: スクロール可、変更をDBに反映しない
 * 			CONCUR_UPDATABLE: ResultSetの編集可
 * @see MainScrollResultSet.java
 * @see MainDbUpdateResultSet.java
 * @author shika
 * @date 2021-04-14
 */
package javaGold.se11Violet.sampleCode.chap10VT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainAbsoluteResultSet {

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
            rs.absolute(1);    //先頭行に移動
                showRecord(rs);
            rs.relative(+2);   //２行先に移動。符号は任意
                showRecord(rs);
            rs.absolute(-1);   //-1で最終行に移動
                showRecord(rs);
            rs.absolute(-2);   //-2は最終行のひとつ前
                showRecord(rs);
            rs.absolute(10);   //存在しない行の指定だけは可
                //showRecord(rs);//そこの値を取り出そうとすると
                //java.sql.SQLException: After end of result set

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//main()

    private static void showRecord(ResultSet rs)
            throws SQLException {
        System.out.println(
            rs.getInt("CODE") + ": " + rs.getString("NAME"));
    }//showRecord()

}//class

/*
1: SALES
3: DEVEROP
7: SUPPORT
6: PLANNING

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