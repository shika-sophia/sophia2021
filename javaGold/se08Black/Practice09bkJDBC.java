/**
 * @title javaGold / se08Black / Practice09bkJDBC.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  第９章 JDBC
 * @author shika
 * @date 2021-05-12
 */
/* Appendix 2021-05-12
 * @costTime 07:48 - 07:59 ( 11 分)
 * @correctRate 正答率 81.25 ％ ( 〇13問 / 全16問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Practice09bkJDBC {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-12 ======
 第９章 JDBC
〇 （1） C
       => 「JDBC API」「JDBCドライバ」の２つのレイヤ(=階層)に別れた構造になっていてる。
       * JDBC API: JavaプログラミングからDBにアクセスするためのAPI
       * API: Application Programming Interface
       * 	java.sql/javax.sqlパッケージとしてインターフェイスやユーティリティクラス群を提供
       *
       * JDBC Driver: 個々のDBに対して実際にアクセスするコードの実装。
       * 	通常はDBの開発元ベンダによって提供される。
       * 	JDBC APIで規定されるインターフェイスの具体的な実装
       *
       * Javaプログラムで JDBC APIに対する共通のコードで、個々のDBにアクセス可能。
       * 利用する個々のDBによって、コードを修正することなく切り替えることができる。
〇 （2） A
       => JDBC APIは JDKに標準で含まれる
       *  JDBC Driverは 個々のDBごとに入手する。
       *  	個々のDB製品に依存する。
〇 （3） C
〇 （4） D
       => ◆static Connection.getConnection()
       * 	Connection getConnection(String url)
       * 	Connection getConnection(String url, Properties info)
       * 	Connection getConnection(String url, String user, String pass)
〇 （5） B
〇 （6） B, C
〇 （7） F
〇 （8） C
      => Date ResultSet.getDate(): 日付
      *  Time ResultSet.getTime(): 時刻
      *  Timestamp ResultSet.getTimestamp(): 日付と時刻
      *  LocalDate Date.toLocalDate()
      *  LocalTime Time.toLocalTime()
      *  LocalDateTime Timestamp.toLocalDateTime()
      *
      *  ※ java.sql.Dateであり、java.util.Dateではないことに注意。他も同様。

Ｘ （9） B -> C
    => ◆boolean Statement.execute()
    *  executeQuery(), executeUpdate()のどちらかではなく、
    *  動的に切り替えたいときに利用。
    *
    *  INSERT, UPDATE, DELETE文が成功すると 結果は false
    *
    *  trueが返ると ResultSetオブジェクトも返ってきているので、
    *  Statement.getResultSet()で取り出せる。
    *  falseの場合、Statement.getUpdateCount()で更新行数を取り出せる。
    *
    *  複数の結果が返ってくる SQL文を execute()で実行した場合
    *  Statement.getMoreResults()で、結果を順に取得していくことができる。
    *
Ｘ （10） A -> D
       => Statementから、ResultSetを一度取り出すと close()される。
       *  Statementから取り出せる ResultSetは １つだけ。
       *  ２つ目を取り出そうとすると、
       *  java.sql.SQLException: 〔runtime〕
       *      Operation not allowed after ResultSet closed

       => javax.sql.rowset.CachedRowSet
       *  Connection, Statement, ResultSetが close()した後も結果セットを利用できる。

Ｘ （11） C -> D
       => Ｘ ResultSet.TYPE_SCROLLABLEという定数は存在しない。
       *  ResultSet.TYPE_SCROLL_INSENSITIVE,
       *  ResultSet.TYPE_SCROLL_SENSITIVE のいずれかでスクロール可能になる。
       *
       *
〇 （12） A, D, E
〇 （13） A
〇 （14） D
〇 （15） B
〇 （16） C

開始時刻 07:48
終了時刻 07:59
所要時間 11 分
正答率 81.25 ％ ( 〇13問 / 全16問 )
*/

