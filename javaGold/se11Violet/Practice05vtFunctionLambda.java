/**
 * @title javaGold / se11Violet / Practice05vtFunctionLambda.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content [ 第５章 Function, Lambda]
 * @author shika
 * @date 2021-04-05
 */
/* Appendix 2021-04-05
 * @costTime 16:26 - 16:44 ( 18 分)
 * @correctRate 正答率 90.91 ％ ( 〇10問 / 全11問 )
 */
/* Appendix 2021-05-18
 * @costTime 20:51 - 21:06 ( 14 分)
 * @correctRate 正答率 90.91 ％ ( 〇10問 / 全11問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice05vtFunctionLambda {

    public static void main(String[] args) {
        new PracticeEditor();
        //ToDoubleFunction<Integer> func = i -> i * 0.1;
        //System.out.println(func.applyAsDouble(100)); //結果 10.0
    }//main()

}//class
/*
//====== 2021-04-05 ======
 第５章 Collection, Lambda
〇 （1） B, E
〇 （2） ① B, ② C, ③ G
〇 （3） B
〇 （4） A, D, F
〇 （5） A
    => method(Foo f, Predicate<Foo>) に対し
    method(obj, a -> a < 100)のように
    ラムダ式を引数として渡して Predicate<Foo>を定義できる。


〇 （6） A, F
〇 （7） C
     method(Foo obj, double) に対し
      method((x, y) -> x / y, 3.0)という ラムダ式で
      Foo関数型インターフェイスの実装を渡すのはＯＫ。

      ただ、Foo.bar()の戻り値は booleanのため、 x / yは計算結果の値が返り不適。
      コンパイルエラー。
〇 （8） B, F
〇 （9） B
Ｘ （10） C -> A
     => ToDoubleFunction<T>のように <T>が必要。
    無記の場合は <Object>と解釈され、
    「Objectに 演算子「*」は未定義です」というコンパイルエラー。
  i にデータ型を指定してもコンパイルエラーは解消されない。
  <T>を <Integer>とするとＯＫ。 上記 main()で検証。

〇 （11） C

開始時刻 16:26
終了時刻 16:44
所要時間 18 分
正答率 90.91 ％ ( 〇10問 / 全11問 )
*/

/*
//====== 2021-05-18 ======
 Function, Lambda [２回目]
〇 （1） B, E
〇 （2） B, C, G
〇 （3） B
〇 （4） A, D, F
〇 （5） A
〇 （6） A, F
〇 （7） C
〇 （8） B, F
〇 （9） B
Ｘ （10） E
    => ToDoubleFunction<T>のように <T>が必要。
    *  無記の場合は <Object>と解釈され、
    *  「Objectに 演算子「*」は未定義です」というコンパイルエラー。
    *  i にデータ型を指定してもコンパイルエラーは解消されない。
    *  <T>を <Integer>とするとＯＫ。 上記 main()で検証。

〇 （11） C

開始時刻 20:51
終了時刻 21:06
所要時間 14 分
正答率 90.91 ％ ( 〇10問 / 全11問 )
*/

