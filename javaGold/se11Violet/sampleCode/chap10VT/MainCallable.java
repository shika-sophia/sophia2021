/**
 * @title javaGold / se11Violet / sampleCode / chap10VT / MainCallable.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第10章 JDBC / List 10-10
 * @content CallableStatement / ストアプロシージャの実行
 *          DBに登録した プロシージャ(procedure) = SQLの関数のようなもの
 *          を javaから呼び出して利用する。
 * @see chap11VT / dbSettingGold.sql
 * @author shika
 * @date 2021-04-13
 */
package javaGold.se11Violet.sampleCode.chap10VT;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

public class MainCallable {

    public static void main(String[] args) {
        String callSql = "{ call myProcedure (?, ?) }";
        String dbUrl = "jdbc:mysql://localhost:3306/practice?serverTimezone=JST";

        try(Connection conn =
                DriverManager.getConnection(dbUrl, "root", "root");
            CallableStatement cs = conn.prepareCall(callSql); ){

            cs.setInt(1, 1100);
            cs.registerOutParameter(2, Types.BIGINT);
            cs.execute();
            int result = cs.getInt(2);
            System.out.println("result: " + result);

            //---- procedure metadata ----
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rsProcedure = meta.getProcedures("practice", null, "myProcedure");
            ResultSetMetaData rsMeta = rsProcedure.getMetaData();

            rsProcedure.next();
            for (int i = 1; i < rsMeta.getColumnCount(); i++) {
                System.out.printf(
                    "%s: %s \n",
                    rsMeta.getColumnName(i),
                    rsProcedure.getString(i));
            }//for

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
//---- result ----
result: 2500

@see chap11VT / dbSettingGold.sql

//---- callable_tb in practice_DB ----
select * from callable;
+----+-------+------+
| ID | VALUE | MEMO |
+----+-------+------+
|  1 |  1100 | NULL |
|  2 |  1100 | NULL |
|  3 |  1200 | NULL |
|  4 |  1300 | NULL |
+----+-------+------+

//---- myProcedure in practice_DB ----
CREATE PROCEDURE myProcedure (IN inPara INT, OUT total INT)
  BEGIN
    SELECT SUM(VALUE) INTO total
      FROM CALLABLE
      WHERE VALUE > inPara;
  END //

//---- procedure metadata ----
PROCEDURE_CAT: practice
PROCEDURE_SCHEM: null
PROCEDURE_NAME: myProcedure
reserved1: null
reserved2: null
reserved3: null
REMARKS:
PROCEDURE_TYPE: 1

 */
