/**
 * @title javaGoF / chap10Strategy / Practice10JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第10章 Strategy / 練習問題 10-1, 10-2, 10-3, 10-4
 * @author shika
 * @date 2021-06-06
 */
/* Appendix 2021-06-06
 * @costTime 08:25 - 08:32 ( 7 分)
 * @correctRate 正答率 100.00 ％ ( 〇7問 / 全7問 )
 */
package javaGoF.chap10Strategy;

import javaGold.PracticeEditor;

public class Practice10JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-06-06 ======
 練習問題 10-1
〇 （1） threeDeadLock/RandomStrategy追加

 10-2
〇 （1） 問 even判定が 「this == other」で済むのはなぜか
〇 （2） Handオブジェクト同士が等しければ「あいこ」 handValueを比較しなくても等しいから。
    => 【解答】 Handのインスタンスは３つしか作っていないから
    *  ３つ以上のインスタンスがあると、同じHandでも違う参照になる可能性はある
    *  その場合「this == other」 -> falseとなってしまう。

 10-3
〇 （1） 問 private boolean won;でも可なのはなぜか。
〇 （2） フィールドはデフォルトで初期値が与えられ、boolen型は false。
〇 （3） int 0, double 0.0, boolean false, Stringなど参照型 null
    => 【解答】デフォルト初期値が与えられるのはフィールドのみ
    *  ローカル変数にデフォルト値はないので、
    *  明示的に初期値を記述しないと、その変数の値を利用する際に コンパイルエラー

 10-4
〇 （1） selectSortパッケージに記述

開始時刻 08:25
終了時刻 08:32
所要時間 7 分
正答率 100.00 ％ ( 〇7問 / 全7問 )
*/

