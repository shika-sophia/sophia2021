/**
 * @title primaryLesson / primaryAns / Lesson004Ans.java
 * @content System.out,println(); 「+」演算子
 * @author shika
 * @dete 2021-01-27
 */
/*
 * ◆Lesson004
 * 下記のコードを実行すると何が表示されるか。正しいものを１つ記号で答えよ。
 *
 * (A) 48
 * (B) 372
 * (C) 124 = 124 = 124
 * (D) 16 = 16 = 16
 * (E) 124 = 16 = 124
 * (F) 16 = ( 12 + 4 ) = 16
 * (G) 124 = ( x + y ) = 124
 * (H) 16 = ( x + y ) = 16
 * (I) 16 = ( x + y ) = 124
 * (J) 124 = ( x + y ) = 16
 *
 * ◆正解 (I)
 */
package primaryLesson.Answer;

public class Lesson004Ans {

    public static void main(String[] args) {
        int x = 12;
        int y = 4;

        System.out.println(x + y + " = ( x + y ) = " + x + y);

    }//main()

}//class

/*
//====== 解説 ======
println(x + y + " = ( x + y ) = " + x + y);

「+」演算子は、左→右に処理を進める。
最初の x + y は int同士の計算のため、足し算の「+」。
次の「+」は " "で囲まれた文字列のため、文字列結合の「+」。
" "内の x + y は文字列として扱うので、 x, y の値を代入せず、そのまま文字として表示。

ここまでの結果は、"16 = ( x + y ) = " + x + y となり、
以下の「+」は、 Lesson003で説明した通り、( )がない限り文字列結合の「+」。

よって、(I) 16 = ( x + y ) = 124 が 正解。

//====== 実行結果 ======
16 = ( x + y ) = 124
 */
