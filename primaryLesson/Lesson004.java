/**
 * @title primaryLesson / primaryAns / Lesson004.java
 * @content System.out,println(); 「+」演算子
 * @author shika
 * @dete 2021-01-27
 */
/*
 * ◆Lesson004
 * 下記のコードを実行すると何が表示されるか。正しいものを１つ記号で答えよ。
 *
 * (A) 124 = 124 = 124
 * (B) 16 = 16 = 16
 * (C) 124 = ( x + y ) = 124
 * (D) 16 = ( x + y ) = 16
 * (E) 16 = ( x + y ) = 124
 * (F) 124 = ( x + y ) = 16
 *
 */

package primaryLesson;

public class Lesson004 {

    public static void main(String[] args) {
        int x = 12;
        int y = 4;

        System.out.println(x + y + " = ( x + y ) = " + x + y);

    }//main()

}//class
