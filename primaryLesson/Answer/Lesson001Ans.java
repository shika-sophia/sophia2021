/**
 * @title primaryLesson / primaryAns / Lesson001Ans.java
 * @content System.out.println()
 * @author shika
 * @dete 2021-01-21
 */
package primaryLesson.Answer;

public class Lesson001Ans {

    public static void main(String[] args) {
        //println()メソッド
        System.out.println("---- println()メソッド ----");
        System.out.println("Your Name");
        System.out.println ("24歳");
        System.out.println(); //改行

        //print()メソッド
        System.out.println("---- print()メソッド ----");
        System.out.print("Your Name ");
        System.out.print("24歳");
        System.out.print("\n"); //これでも改行できる
        System.out.println();

        //「+」演算子
        System.out.println("---- 「+」演算子 ----");
        System.out.println("Your Name : " + "24歳");
    }//main()

}//class

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