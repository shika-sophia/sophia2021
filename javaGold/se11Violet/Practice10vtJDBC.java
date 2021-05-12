/**
 * @title javaGold / se11Violet / Practice10vtJDBC.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content  第10章 JDBC
 * @author shika
 * @date 2021-04-15
 */
/* Appendix 2021-04-15
 * @costTime 13:27 - 13:45 ( 17 分)
 * @correctRate 正答率 69.23 ％ ( 〇9問 / 全13問 )
 */
/* Appendix 2021-05-12
 * @costTime 15:49 - 16:09 ( 19 分)
 * @correctRate 正答率 61.54 ％ ( 〇8問 / 全13問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice10vtJDBC {

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
     * executeQuery()の後
    * executeUpdate()を実行するため、ResultSetは closeする。
    * close後の getString()は SQLException

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

/*
//====== 2021-05-12 ======
 JDBC [２回目]
〇 （1） D, E
〇 （2） E
〇 （3） C
〇 （4） A, C, D
〇 （5） D
Ｘ （6） B -> E
       => SQLExceptionの処理をしていないのでコンパイルエラー。
       *  main() throws SQLExceptionか、catch節が必要。
Ｘ （7） A -> E
       => PreparedStatement.executeQuery()で ResultSet取得。
       *  ps.executeUpdate()時に ResultSetは close()する。
    *  closeの後、 rs.getString()をしているので SQLException

〇 （8） E
Ｘ （9） A, F?
      => void rs.beforeFirst()
         void rs.afterLast()
〇 （10） F
    => rs.next()なく、getString()しているので SQLException

Ｘ （11） B -> A
       => 33行目がないのに UPDATE
       *  更新行 0となるだけで、例外は出ない。
Ｘ （12） F -> C
       => PreparedStatementは
       *  INパラメタ「?」の値を変えて複数実行することができる。

〇 （13） E

開始時刻 15:49
終了時刻 16:09
所要時間 19 分
正答率 61.54 ％ ( 〇8問 / 全13問 )
*/

