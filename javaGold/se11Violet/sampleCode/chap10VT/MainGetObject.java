/**
 * @title javaGold / se11Violet / sampleCode / chap10VT / MainGetObject.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第10章 JDBC / List 10-1, List 10-3
 * @content rs.getObject()
 * @author shika
 * @date 2021-04-13
 */
package javaGold.se11Violet.sampleCode.chap10VT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainGetObject {

    public static void main(String[] args) {
        String sql = "SELECT * FROM javaGold WHERE CODE = ? OR CODE = ?";
        try(Connection conn = DbAccess.getConnect();
            PreparedStatement ps = conn.prepareStatement(sql);){

            //set value to '?'
            ps.setInt(1, 1);
            ps.setInt(2, 3);

            //ResultSet
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
//                int code = rs.getInt("code");
//                String name = rs.getString("name");
//                String address = rs.getString("address");
//                String tel = rs.getString("tel");
                Object codeObj = rs.getObject("code");
                Object name = rs.getObject("name");
                Object address = rs.getObject("address");
                Object tel = rs.getObject("tel");

                int code = 0;
                if(codeObj instanceof Integer) {
                    code = Integer.parseInt(codeObj.toString());
                }

                System.out.printf(
                    "%d: %s: %s: %s \n",
                    code,  name, address, tel);
            }//while

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
//==== console ====
//---- getString() ----
1: SALES: TOKYO: 03-3333-XXXX
3: DEVEROP: OSAKA: null

//---- getObject() ----
1: SALES: TOKYO: 03-3333-XXXX
3: DEVEROP: OSAKA: null

【考察】
テキストは Object codeObjを
Integer.parseInt(codeObj.toString())で
int codeに変換したが、
printf("%s", codeObj)にすれば、
printf()が toString()を呼んでくれるので
Objectのままで、ちゃんと表示される。

getObject()は データ型が混在しているときに便利だが、
データ型が混在しているなら、なおさら
getString(), getInt()で取得したほうが
可読性は上がるのではなかろうか。

//==== javaGold_tb ====
SELECT * FROM JAVAGOLD;
+------+-----------+----------+--------------+
| code | name      | address  | tel          |
+------+-----------+----------+--------------+
|    1 | SALES     | TOKYO    | 03-3333-XXXX |
|    2 | ENGINEER  | YOKOHAMA | O45-555-XXXX |
|    3 | DEVEROP   | OSAKA    | NULL         |
|    4 | MAKETING  | FUKUOKA  | 092-222-XXXX |
|    5 | EDUCATION | TOKYO    | NULL         |
+------+-----------+----------+--------------+

*/