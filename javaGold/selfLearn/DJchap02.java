/**
 * @title javaGold / selfLearn / DJchap02.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content [ ◆練習問題2.1 / p47,  ◆練習問題2.2 / p54,  ◆練習問題2.3 / p60,
 *            ◆練習問題2.4 / p63,  ◆章末問題 / p76]
 * @author shika
 * @date 2021-02-15
 */
/* Appendix
 * @costTime 08:36 - 09:07 ( 30 分)
 * @correctRate 正答率 90.00 ％ ( 〇18問 / 全20問 )
 */
package javaGold.selfLearn;

import javaGold.PracticeEditor;

public class DJchap02 {
    public static void main(String[] args) {
        new PracticeEditor();
    }//main()
}//class
/*
//====== 2021-02-15 ======
 ◆練習問題2.1 / p47
〇 （1） 1data -> 識別子に最初数字はＮＧ =>
〇 （2） Hoge -> コンパイルは通るが変数名に大文字は避ける(クラス名に見える) =>
〇 （3） 整数の箱 -> Unicode文字はコンパイル通るが、変数名は半角英数字で =>
〇 （4） for -> 予約語は不可 =>
〇 （5） data-1 -> 識別子で計算不可。使える記号は「_」「$」のみ。 =>

 ◆練習問題2.2 / p54
〇 （1） 基本型 byte,short,char,int,long,float,double,boolean =>
〇 （2） 基本型は変数名の定義により、メモリ領域が確保されそこに格納。\n
           参照型はnewによりメモリ作られ、そのメモリの場所を変数が保持。 =>

 ◆練習問題2.3 / p60
〇 （1） 16進数 -> 0xA08F =>
〇 （2） 数値セパレーター -> int x = 123_456; =>
〇 （3） 改行区切りの文字列 -> String str = "あい" + "う"; =>
〇 （4） 指数表現 -> double i = 0.314E1; =>
〇 （5） 文字リテラル -> char a = 'a'; =>

 ◆練習問題2.4 / p63
Ｘ （1） long m = 10; -> 数値はデフォルトで intと解釈される。
     (long)でキャストするか、10Lとしないとコンパイルエラー。 =>
〇 （2） int i = m; -> あっ、上式ではコンパイル通る。暗黙の型変換。
                                     下式はキャストしないとコンパイルエラー。 =>

 ◆章末問題 / p76
〇 （1） dataの型宣言Stringが必要、文字列は「"」、文末は「;」 =>
〇 （2） 完全修飾名,単純クラス名,import,名前の解決 =>  単純名
〇 （3） final, 0.1, (1 - DISCOUNT), println, int =>
〇 （4） 0, 1 =>
〇 （5） 1, 1, 1 =>
Ｘ （6） (別枠に記述) =>

開始時刻 08:36
終了時刻 09:07
所要時間 30 分
正答率 90.00 ％ ( 〇18問 / 全20問 )
*/

