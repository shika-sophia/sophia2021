/**
 * @title javaGold / se11Violet / Practice03VT.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第３章 例外処理
 * @author shika
 * @date 2021-03-29
 */
/* Appendix 2021-03-29
 * @costTime 06:59 - 07:18 ( 18 分)
 * @correctRate 正答率 69.23 ％ ( 〇9問 / 全13問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice03VT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-29 ======
 第３章 例外処理
Ｘ （1） B, C -> B, D
   => close()で Exceptionを throwしているので、main()での Eeception処理が必要。

〇 （2） A, C
Ｘ （3） A, F
    => try-catch, try-finallyは可。
    => try-with-resourceは tryのみは可。

〇 （4） D
〇 （5） B, C, E
〇 （6） B
Ｘ （7） D -> E (ケアレスミス)
    => 9行目 class Bexではなく
    => 10行目 Bex()

Ｘ （8） A, C, E -> C, D, E
    => Foo extends Exceptionのとき
    e = new Exception()は サブに superを代入しているのでコンパイルエラー。

〇 （9） E
    => マルチキャッチの eは 暗黙final

〇 （10） F
   => 独自定義の例外に 特にルールはなし。

〇 （11） C, E
〇 （12） B, E
〇 （13） D

開始時刻 06:59
終了時刻 07:18
所要時間 18 分
正答率 69.23 ％ ( 〇9問 / 全13問 )
*/

