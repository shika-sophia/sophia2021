/**
 * @title javaGold / se11Violet / Practice02vtAnnotation.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第２章 Annotation
 * @author shika
 * @date 2021-03-25
 */
/* Appendix 2021-03-25
 * @costTime 15:04 - 15:13 ( 8 分)
 * @correctRate 正答率 75.00 ％ ( 〇6問 / 全8問 )
 */
/* Appendix 2021-05-07
 * @costTime 16:07 - 16:15 ( 8 分)
 * @correctRate 正答率 75.00 ％ ( 〇6問 / 全8問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice02vtAnnotation {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-25 ======
 第２章 Annotation
Ｘ （1） C -> E コンパイルは成功する
  => default equals()は引数をもたず
  Object.equals(Object obj)とは関係のないオーバーロードと見なされる
〇 （2） F
〇 （3） C, E
〇 （4） D
〇 （5） C
〇 （6） C
    => @SafeVarargsは呼び出し元の警告も抑制する。
    @SuppressWarnings("unchecked")は当該箇所の警告抑制だけで、呼び出し元の警告はそのまま。
Ｘ （7） A, C -> B, E
   => 属性の default値に nullは不可。コンパイルエラー。
       独自定義のクラスをアノテーションの型名に指定できない。コンパイルエラー。
       @Inheritedは、クラスにのみ適用しアノテーションを派生クラスに引き継ぐ。
       インターフェイスに付与しても適用されないがコンパイルエラーにはならない。

〇 （8） C, E

開始時刻 15:04
終了時刻 15:13
所要時間 8 分
正答率 75.00 ％ ( 〇6問 / 全8問 )
*/

/*
//====== 2021-05-07 ======
 Annotation [２回目]
〇 （1） E
Ｘ （2） A -> F
      => @SafeVarags: 型安全ではない可変長引数に使う
          題意は型を利用していないので不適
    => @SuppressWarnings("unchecked")を利用

〇 （3） C, E
〇 （4） D
〇 （5） C
〇 （6） C
    => @SuppressWarnigs("")は呼出元も警告が出る
Ｘ （7） C, E -> B, E
    => ◆@interface
       default値に null不可
       static finalな定数の宣言可
       独自クラスはアノテーションの引数に持てない

〇 （8） C, E

開始時刻 16:07
終了時刻 16:15
所要時間 8 分
正答率 75.00 ％ ( 〇6問 / 全8問 )
*/

