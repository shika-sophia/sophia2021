/**
 * @title javaGold / selfLearn / DJchap09Practice.java
 * @reference 山田祥寛 『独習 Java 新版』 翔泳社, 2019
 * @content 第９章 Object, 例外処理 // 練習問題 9.1, 9.2
 * @author shika
 * @date 2021-03-08
 */
/* Appendix
 * @costTime 08:17 - 08:31 ( 13 分)
 * @correctRate 正答率 92.31 ％ ( 〇12問 / 全13問 )
 */
package javaGold.selfLearn;

import javaGold.PracticeEditor;

public class DJchap09Practice {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-08 ======
 第９章 Object / 例外処理 // 練習問題 9.1
Ｘ （1） ① Person
    => Object
    他オブジェクトと比較するメソッドなので、他クラスも入れるように
    Objectクラスをメソッドの引数型に指定すべき。

〇 （2） ② this
〇 （3） ③ instanceof
〇 （4） ④ (Person)
〇 （5） ⑤ equals()
〇 （6） ⑥ false

 練習問題 9.2
〇 （1） Exceptionの継承関係にある 派生クラスから記述する。
〇 （2） catch ( A | B ){ }のように記述も可だが、この場合 継承関係にあるもの同士は不可。
〇 （3） [2]例外をスローする場合、解決可能な「検査例外」をスローする。
    => 解決できないものは、RuntimeExceptionとしてスロー。

〇 （4） 解決不可能な「Error」クラスをスローしても意味がないので「Exception」配下のクラスをスローする。
〇 （5） 「非検査例外」である RuntimeExceptionは プログラム上のバグであることが多いので
〇 （6） try-catchをするより、RuntimeExceptionが出ないようプログラムを見直すべきである。
〇 （7） また、自己定義の extends Exceptionを利用するより、可読性の観点から java既存の「標準例外」を利用すべき。
    => 具体的な例外の内容を識別できるように、「Exception」クラスのスローは避ける。

開始時刻 08:17
終了時刻 08:31
所要時間 13 分
正答率 92.31 ％ ( 〇12問 / 全13問 )
*/

