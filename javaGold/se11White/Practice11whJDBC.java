/**
 * @title javaGold / se11White / Practice11whJDBC.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content  第11章 JDBC / se11VTと章立てが異なる
 * @author shika
 * @date 2021-04-15
 */
/* Appendix 2021-04-15
 * @costTime 09:19 - 09:42 ( 22 分)
 * @correctRate 正答率 50.00 ％ ( 〇7問 / 全14問 )
 */
/* Appendix 2021-05-12
 * @costTime 11:10 - 11:30 ( 19 分)
 * @correctRate 正答率 71.43 ％ ( 〇10問 / 全14問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice11whJDBC {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-15 ======
 第11章 JDBC
〇 （1） A, C
Ｘ （2） D -> B
    => ◆Statementインターフェイス
        Statement conn.createStatement()
        ResultSet st.executeQuery(String sql)
        sqlは create()時には不要で、execute()時に指定する。

Ｘ （3） A, B, E -> B, C, E
    => close()の必要なインターフェイス/クラス
        Connection, Statement, ResultSet
Ｘ （4） C -> A
    SQL文: SELECT name, id, score FROM javaGold;
    表のカラム id, name, scoreと列選択リストの順が違う
    ResultSetの仮想テーブルは SELECTで示した列順になるので注意。

    sql.Integer型の列を getString()で受けてもいいのか？
    print(rs.getString(2));
    検証すると
     int id = rs.getString(2); とするとコンパイルエラーだが
     String id = rs.getString(2);だと
  sql.Integerを受け取って Stringに変換し、ちゃんと表示もされる。

〇 （5） D
    WHERE id = 3 の結果は EmptySetで 空の情報が返るが
    ResultSetは nullではなく、空のオブジェクトとなる。

    if(rs != null) -> trueでこの節に入って
        while(rs.next()) -> falseとなり、何も表示されない。

〇 （6） D
    SELECT no FROM javaGold;
    「no」という列は存在しないため、
    SQLSyntaxErrorException extends SQLException

Ｘ （7） D -> B
    => rs.updateStrind()の変更は仮変更で
       rs.updateRow()によって DBへの変更と ResultSetも変更確定する。
       rs.updateRow()が抜けると、DBも ResultSetも変更は破棄され元のまま。

〇 （8） C
Ｘ （9） F -> D
    F コンパイルエラーにした理由は ネストの try{ }のみで catchがなかったから
    外側に catchがあれば try{ }のみでもいいのか。
    try-with-resourcesの場合、tryのみ可。

〇 （10） B
    => psの「?」に値が入っていないと SQLException

〇 （11） B
    => psの「?」は２つしかないのに 3つ代入すると、SQLException
    コンパイル時に検出されないんだ

Ｘ （12） D -> C
    => psの「?」に setXxxx()を一度した場合、
       ２回目に一部の列しか setXxxx()をしなくても
          前回代入した値が使われる。

〇 （13） B, C
    => Savepoint conn.setSavepoint(): rollback()の戻り先を設定。

Ｘ （14） E -> D
    => E: SQLExceptionにした理由
    sql1 = "INSERT ・・" + "VALUES ・・"
    +演算子の前に半角スペースがなく、sql2のほうは、ちゃんとあるので、
    sql1を実行すると Syntaxになる。
    そういう問題かと思ったら単なる誤植かい。

    プライマリーkeyが重複してネストcatch節 -> rollback()
    初期状態に戻るため、１行目のINSERTは無効になる。

開始時刻 09:19
終了時刻 09:42
所要時間 22 分
正答率 50.00 ％ ( 〇7問 / 全14問 )
*/

/*
//====== 2021-05-12 ======
 JDBC [２回目]
〇 （1） A, C
    => try( )内で定義した変数は try{ }内のみのスコープ

〇 （2） B
〇 （3） B, C, E
〇 （4） A
〇 （5） D
    => SQL: EmptySet時 -> ResultSetは空のオブジェクト。nullではない。

〇 （6） D
    => SQL: SyntaxError: unknown column
    -> Java: SyntaxErrorException extends SQLException

Ｘ （7） D -> B
    => ResultSet.updateRow()をしていない場合、ResultSetも変更されない。
    -> 元のテーブルも変更されない。

〇 （8） C
〇 （9） D
〇 （10） B
    => INパラメタ「?」を３つ定義して、値を入れてないものがあると
       SQLException

Ｘ （11） C -> B
    => INパラメタ「?」を２つ定義して、３つ目の値を入れると SQLException
    *  コンパイルエラーではない。

Ｘ （12） D -> C
    => ２回目の executeUpdate()
    *  ResultSetから、値を取得していないので、２回目も実行可能なのか？
    *
    => 一度、ps.setSring()をして、
    *  二度目に setString()等の値が抜けているものがあると、
    *  一度目に入れた値となる。

〇 （13） B, C
Ｘ （14） C -> D
    => 12行目の INSERTは プライマリーkeyの重複で失敗。
    => setSavePoint()をしていないので、
       rollback()は初期状態に戻る。

開始時刻 11:10
終了時刻 11:30
所要時間 19 分
正答率 71.43 ％ ( 〇10問 / 全14問 )
*/

