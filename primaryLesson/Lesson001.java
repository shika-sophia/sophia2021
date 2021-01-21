/**
 * @title primaryLesson / Lesson001.java
 * @content System.out.println(), print(),「+」演算子
 * @author shika
 * @dete 2021-01-21
 */
/*
 * ◆Lesson001
 *     問１: System.out.println("");を用いて、自分の名前と年齢を表示せよ。
 *     問２: print("")メソッドでも表示し、実行結果の違いを確認。
 *     問３: 「+」を用いて、文字列の結合を行い、
 *            System.out.println("");を一文で「名前 : 年齢」表示せよ。
 *
 * ◇ヒント
 * Eclipseでは「sysout」と入力して [ctrl + スペース]をすると
 * 「System.out.println();」に変換される。
 */
/*
//====== 実行結果 ======
---- println()メソッド ----
Your Name
24歳

---- print()メソッド ----
Your Name 24歳

---- 「+」演算子 ----
Your Name : 24歳
*/

package primaryLesson;

public class Lesson001 {

    public static void main(String[] args) {
        //println()メソッド
        System.out.println("---- println()メソッド ----");
        System.out.println("");
        System.out.println ("");
        System.out.println(); //改行

        //print()メソッド
        System.out.println("---- print()メソッド ----");
        System.out.print("");
        System.out.print("");
        System.out.print("\n"); //これでも改行できる
        System.out.println();

        //「+」演算子
        System.out.println("---- 「+」演算子 ----");


    }//main()

}//class
