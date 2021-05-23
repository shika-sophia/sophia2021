/**
 * @title javaGold / se11White / Practice02whAnnotation.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content 第２章 Annotation
 * @author shika
 * @date 2021-03-25
 */
/* Appendix 2021-03-25
 * @costTime 13:52 - 14:06 ( 14 分)
 * @correctRate 正答率 50.00 ％ ( 〇5問 / 全10問 )
 */
/* Appendix 2021-05-06
 * @costTime 16:32 - 16:44 ( 12 分)
 * @correctRate 正答率 80.00 ％ ( 〇8問 / 全10問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice02whAnnotation {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-25 ======
 第２章 Annotation
〇 （1） C, D
〇 （2） D
Ｘ （3） B -> 〇 B, C
    => @SuppressWarnings("unchecked")

Ｘ （4） B,C-> B, D
    属性名を定義したものは宣言時に値が必要。
    ただし defaultを指定したものは任意

〇 （5） B, C
 => 定義している属性が１つ かつ 属性名が valueは
     宣言時に属性省略可。value=も省略可。

〇 （6） A
〇 （7） B
Ｘ （8） B -> 〇 D
 => Java8-
 ◆同じ場所に同一アノテーションを付与できる条件
 ① @Repeatable()を指定
 ② 引数に配列を属性に持つクラスを .classで指定

Ｘ （9） A, E -> 〇 C, E
    => @Deprecated 非推奨の要素に付与
    変数、メソッド、コンストラクタなど
    コンパイル時に警告が発生する

Ｘ （10） B, C -> 〇 C, E
  => @Retention(RetentionPolicy.SOURCE)は
  @Override, @SuppressWarnings
   コンパイル後に破棄され、クラスファイルには保持されない

開始時刻 13:52
終了時刻 14:06
所要時間 14 分
正答率 50.00 ％ ( 〇5問 / 全10問 )
*/

/*
//====== 2021-05-06 ======
 Annotation [２回目]
〇 （1） C, D
〇 （2） D
〇 （3） B, C
      => 可変長引数にジェネリックを用いると警告発生。
      @SafeVarargs
          -> 対象のメソッドに private, staitic finalを指定する必要がある。

      @SuppressWarnings("unchecked")
          -> 呼出元にも警告が出る

〇 （4） B, D
〇 （5） B, C
〇 （6） A
〇 （7） B
〇 （8） D
Ｘ （9） A, E
      => @Deprecated 非推奨に付与。警告を発生させる。
         @Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE,
         METHOD, PACKAGE, MODULE, PARAMETER, TYPE})

Ｘ （10） B, C
   => RetentionPolicy.SOURCE: @Override, @SuppressWarnigs

開始時刻 16:32
終了時刻 16:44
所要時間 12 分
正答率 80.00 ％ ( 〇8問 / 全10問 )
*/

