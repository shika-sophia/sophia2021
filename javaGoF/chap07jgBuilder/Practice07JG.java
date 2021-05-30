/**
 * @title javaGoF / chap07jgBuilder / Practice07JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第７章 Builder / 練習問題
 * @author shika
 * @date 2021-05-29
 */
/* Appendix 2021-05-29
 * @costTime 19:47 - 19:53 ( 5 分)
 * @correctRate 正答率 100.00 ％ ( 〇6問 / 全6問 )
 */
package javaGoF.chap07jgBuilder;

import javaGold.PracticeEditor;

public class Practice07JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-30 ======
第７章 Builder / 練習問題 7-1
    => interfaceBuilderパッケージ

練習問題 7-2
    => buildOrderedパッケージ

練習問題 7-3
    => SwingGofBuilderクラス

//====== 2021-05-29 ======
 第７章 Builder / 練習問題 7-4
〇 （1） 問 Stringではなく、StringBufferを利用している理由は何か。
〇 （2） Stringは不変オブジェクトであり、たくさんのStringを追加すると、追加分と合成後の Stringオブジェクトが生成される。
〇 （3） StringBuilder, StringBufferなら、可変オブジェクトであり、
〇 （4） オブジェクト追加時も append()で連結していき、StringBuilder自体のオブジェクトは１つのままで、
〇 （5） 中身の文字列を連結していくことができる。
〇 （6） 最後に toString()で１つの連結済の Stringオブジェクトを生成すれば済む。

開始時刻 19:47
終了時刻 19:53
所要時間 5 分
正答率 100.00 ％ ( 〇6問 / 全6問 )
*/

