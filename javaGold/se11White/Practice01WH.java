/**
 * @title javaGold / se11White / Practice01WH.java
 * @reference 日本サードパーティ  『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content 第１章 Javaの基本
 * @author shika
 * @date 2021-03-16
 */
/* Appendix 2021-03-16
 * @content [1]-[9]
 * @costTime 16:03 - 16:23 ( 19 分)
 * @correctRate 正答率 77.78 ％ ( 〇7問 / 全9問 )
 */
/* Appendix 2021-03-18
 * @content [10]-[20]
 * @costTime 09:04 - 09:24 ( 19 分)
 * @correctRate 正答率 90.91 ％ ( 〇10問 / 全11問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice01WH {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class

/*
//====== 2021-03-16 ======
 第１章 Javaの基本
〇 （1） C, E
〇 （2） C 16行目 empNoは private
〇 （3） C, D
〇 （4） A, C
Ｘ （5） A -> C
    => static と フィールドは オーバライドに関係なく、
    変数型のメソッドが呼び出される

〇 （6） B
Ｘ （7） E => D
    -> Exam と Bronzeに継承関係はないので
    Bronze b2 = (Bronze) e; は Exam e = new Gold();でも
    コンパイルエラーが出ると思うのだが・・

    上記が通るとして、staticメソッドは 変数型のメソッドが呼び出される。
    非staticは 変数型ではなくオブジェクト型の @Overrideしたメソッドが呼び出される。

〇 （8） E
〇 （9） A
    => println()の引数にオブジェクトを指定すると、
    そのオブジェクトの toString()を呼び出す。
    そのオブジェクトが toString()を @Overrideしていないときは
    extends Objectの Object.toString()を呼び出す。

開始時刻 16:03
終了時刻 16:23
所要時間 19 分
正答率 77.78 ％ ( 〇7問 / 全9問 )
*/
/*
//====== 2021-03-18 ======
 1-10から続き
Ｘ （1） [1-10] D
  => F
  => StringBuffer.equals()は 参照先を比較する同一性の判定である Object.equals()。
  => String.equals()は 同値性判定をするように @Overrideされている。

〇 （2） [11] C
〇 （3） [12] A, C
〇 （4） [13] C
〇 （5） [14] A, D
〇 （6） [15] B
〇 （7） [16] A, C
〇 （8） [17] B
〇 （9） [18] D
〇 （10） [19] A
〇 （11） [20] C, E

開始時刻 09:04
終了時刻 09:24
所要時間 19 分
正答率 90.91 ％ ( 〇10問 / 全11問 )
*/

