/**
 * @title javaGoF / chap19State / Practice19JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第19章 State / 練習問題 19-1, 19-2, 19-3, 19-4
 * @author shika
 * @date 2021-06-25
 */
/* Appendix 2021-06-25
 * @costTime 14:25 - 14:38 ( 13 分)
 * @correctRate 正答率 90.91 ％ ( 〇10問 / 全11問 )
 */
package javaGoF.chap19State;

import javaGold.PracticeEditor;

public class Practice19JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-06-25 ======
 第19章 State / 練習問題 19-1
〇 （1） 問 stateフィールドを Contextインターフェイスに記述したほうが、パターンの主旨に沿うはずなのに、
〇 （2） ConcreteContextに記述しているのはなぜか？
Ｘ （3） 答 今後、ConcreteContextを増やした場合にクラスごとに違う Stateにできるようにかな。
    => Javaの単一継承問題。
    *  DepsitFrameは すでに extends Frameしているので、
    *  Contextを抽象クラスにすると継承できなくなる。

 19-2
問 昼間と夜間の時間を変更したい。どのクラスを修正すべきか。
〇 （1） DayState, NightStateの 状態遷移を行うメソッド doClock()を変更する

 19-3
〇 （1） 問 「昼食時」の状態追加
〇 （2）  => LunchStateをサンプルに追加。

 19-4
〇 （1） 問 「非常時」という状態を追加し、そのときの処理を記述。
〇 （2） この仕様には問題がある。それは何か？
〇 （3） 答 状態遷移は時間によって行われており、
〇 （4） 「非常時」の処理は時間によらず、連絡が行くように記述できるが、
〇 （5） 通常時に戻す方法がない。doClock()の時間判定を採用するなら、「非常時」の時間によらずという処理は実現しない

開始時刻 14:25
終了時刻 14:38
所要時間 13 分
正答率 90.91 ％ ( 〇10問 / 全11問 )
*/

