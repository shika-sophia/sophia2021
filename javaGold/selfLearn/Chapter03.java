/**
 * @title javaGold / selfLearn / Chapter03.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content [ ◇練習問題 3.1,  ◇練習問題 3.2,  ◆章末問題]
 * @author shika
 * @date 2021-02-16
 */
/* Appendix
 * @costTime 15:33 - 16:06 ( 32 分)
 * @correctRate 正答率 84.21 ％ ( 〇16問 / 全19問 )
 */
package javaGold.selfLearn;

import javaGold.PracticeEditor;

public class Chapter03 {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-02-16 ======
 ◇練習問題 3.1 / p87
Ｘ （1） 前置演算 ++i 演算(+1)する前のiの値を代入。後置演算 i++は演算(+1)後のiを代入。
    => 〇 ++i: 演算してから代入、 i++: 演算前に代入しその後演算。
〇 （2） ①"4" + "5" -> 45
〇 （3） ② 1++; -> リテラルのインクリメントは不可。コンパイルエラー。
〇 （4） ③ 10 / 6 -> 1 int同士の演算結果はint。
〇 （5） ④ 2.0 / 0 -> Infinity(無限) 値ではない
〇 （6） ⑤ 10 % 4 -> 2

 ◇練習問題 3.2 / p99
〇 （1） System.out.println( ? value == null "値なし" : value);
〇 （2） ① "123".equals("123") -> true
〇 （3） ② "123" = 123 -> コンパイルエラー: Stringとintの同値比較は不可。
〇 （4） ③ new String("abc") == new String("abc") -> false 参照は異なるため
Ｘ （5） ④ Arrays.equals(new int[]{1, 2, 3}, new int[]{1, 2, 3}) -> false 同上。
    => @see testExamin / TestAryEquals.java
    => Array.equals(ary1, ary2)は、参照比較ではなく、要素が一致しているかを比較。

 ◆章末問題 / p107
〇 （1） ①算術演算子 ②代入演算子 ③? true:false ④論理演算子 ⑤ &, |, ~, >>, <<, >>>
〇 （2） x: 6, y: 4, builder1: いろはにほへと, builder2: いろはにほへと
〇 （3） 理由: str = nullより、NullPointerException。 str = "Class.java"か str=""で初期化し引数やScannerなどでstrに代入する。
Ｘ （4） ①演算優先度 =>〇優先順位
〇 （5） ②結合法則 => 結合則
〇 （6） ③高い
〇 （7） ④同じ
〇 （8） ⑤代入演算子

開始時刻 15:33
終了時刻 16:06
所要時間 32 分
正答率 84.21 ％ ( 〇16問 / 全19問 )
*/

