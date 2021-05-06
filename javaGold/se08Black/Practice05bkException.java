/**
 * @title javaGold / se08Black / Practice05bkException.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  第５章 Exception, Assertion
 * @author shika
 * @date 2021-05-06
 */
/* Appendix 2021-05-06
 * @costTime 10:03 - 10:11 ( 8 分)
 * @correctRate 正答率 75.00 ％ ( 〇9問 / 全12問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Practice05bkException {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-06 ======
 第５章 Exception, Assertion
〇 （1） B
〇 （2） C
      => ◆例外の再throw
      new Exception(e); コンストラクタに eオブジェクトを入れる。
      これ以上、例外処理をしないということであり、呼出元に例外処理を任せるので、
      throws句を記述する必要がある。

〇 （3） B
〇 （4） D
〇 （5） A
Ｘ （6） C -> A
      => java.lang.Throwableは Exception, Errorクラスの super
          Throwableの直接のサブクラス Exceptionを継承して 独自例外を定義するのが一般的
          C: java.lang.exception.Throwableなのでパッケージ階層が違う

〇 （7） B
Ｘ （8） C -> A
    => try-with-resource文は catch,finallyが必須ではない。
        try節だけでもコンパイルエラーにならない。

〇 （9） C
     => AutoCloseableインターフェースを implementsしていないと
     try-with-resourceを利用できない。コンパイルエラー。

Ｘ （10） A -> B
    => assert 条件式
      => assert(条件式）; 半角スペースはあってもなくてもよい。
          java.lang.AssertionError: 条件式が falseのとき、
                  実行時に -eaを付けて assert有効にしているときのみ

〇 （11） A
      => assert 条件式 : 引数;
          引数は AssertionErrorのコンストラクタに渡す引数。エラーメッセージ等。

〇 （12） C
     => java -ea クラス名


開始時刻 10:03
終了時刻 10:11
所要時間 8 分
正答率 75.00 ％ ( 〇9問 / 全12問 )
*/

