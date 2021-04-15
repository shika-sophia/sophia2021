/**
 * @title javaGold / se11Violet / Practice10VT.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content  第10章 JDBC
 * @author shika
 * @date 2021-04-15
 */
/* Appendix 2021-04-15
 * @costTime 13:27 - 13:45 ( 17 分)
 * @correctRate 正答率 69.23 ％ ( 〇9問 / 全13問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice10VT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-15 ======
 第10章 JDBC
〇 （1） D, E
    => DB_URLのポート番号は デフォルトを使用している場合、省略可能。

〇 （2） E
     => META-INF/service/java.sql.Driverが JDBCのjarファイルに入っており、
         CLASSPATHとして自動的に登録される。

〇 （3） C
〇 （4） A, C, D
〇 （5） D
Ｘ （6） D -> E
   => catch節がないためコンパイルエラー。
         YMはいつも省略しているから、またかと思ったらこれかい。

         main() throws SQLExceptionならコンパイル通る

         私の回答理由は UPDATE テーブル名 の後に列名が必要だと思ったけど、
             UPDATE テーブル名
               SET 列名 = 値
               WHERE 列名 = 値
             ; でした。

Ｘ （7） A -> E
    executeQuery()を実行するため、ResultSetは closeする。
    close後の 再executeQuery()は SQLException
    executeUpdate()は 戻り値 intのため、可能。

〇 （8） E
〇 （9） D, E
Ｘ （10） B -> F
      => rs.next()など、行指定するメソッドがなく、
      getString()しているので、SQLException

Ｘ （11） F -> A
    => UPDATE文 更新対象の行が存在しないとき SQLExceptionではなく、
        executeUpdate()の戻り値 0が返る。
            Query OK, 0 rows affected (0.00 sec)

〇 （12） C
〇 （13） E
    => CallableStatement conn.prepareCall()
       void cs.registerOutParameter()

開始時刻 13:27
終了時刻 13:45
所要時間 17 分
正答率 69.23 ％ ( 〇9問 / 全13問 )
*/

