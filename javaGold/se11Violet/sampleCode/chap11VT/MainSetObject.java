/**
 * @title javaGold / se11Violet / sampleCode / chap11VT / MainSetObject.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第11章 JDBC / List 11-9
 * @content ps.setObject(), setNull()
 * @author shika
 * @date 2021-04-13
 */
package javaGold.se11Violet.sampleCode.chap11VT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class MainSetObject {

    public static void main(String[] args) {
        String sql = "INSERT INTO JAVAGOLD VALUES (?, ?, ?, ?)";

        try(Connection conn = DbAccess.getConnect();
            PreparedStatement ps = conn.prepareStatement(sql); ){

            ps.setObject(1, 7);
            ps.setObject(2, "SUPPORT");
            ps.setObject(3, "NARA", Types.VARCHAR);
            ps.setNull(4, Types.NULL);

            int affected = ps.executeUpdate();
            System.out.println("affected: " + affected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
affected: 1

【考察】
setObject(int, Object [,Types])
    indexに Objectの値をセット。Typesは省略可。
    Types.NULLを入れるためのものか。

テキストのように Objectの位置に列名を入れるとコンパイルエラー
直接 列名を指定できるなら「?」の意味がなくなる。
その前に列名を""もなく入れると、javaは この変数なんだ？ってなる。

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
|    7 | SUPPORT   | NARA     | NULL         |
+------+-----------+----------+--------------+
*/