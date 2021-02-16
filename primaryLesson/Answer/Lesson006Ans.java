/**
 * @title primaryLesson / primaryAns / Lesson006Ans.java
 * @content 演算子
 * @author shika
 * @dete 2021-01-28
 */
/*
 * ◆Lesson006
 * x = 10, y = 4 のとき、
 * 10 ÷ 4 の計算結果を 小数で表示せよ。
 * また 10 ÷ 4 をしたときの余りを表示せよ。
 *
 * ◇実行結果
 * x ÷ y = 2.50
 * x ÷ y の余りは 2
 */
package primaryLesson.Answer;

public class Lesson006Ans {

    public static void main(String[] args) {
        int x = 10;
        int y = 4;
        double result = (double) x / y;

        System.out.printf("x ÷ y = %.2f \n", result);
        System.out.printf("x ÷ y の余りは %d \n", x % y);
    }//main()

}//class

/*
x ÷ y = 2.50
x ÷ y の余りは 2
*/