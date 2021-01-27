/**
 * @title primaryLesson / primaryAns / Lesson003Ans.java
 * @content System.out,println(); 「+」演算子と( )
 * @author shika
 * @dete 2021-01-27
 */
/*
 * ◆Lesson003
 *  x = 12, y = 4のとき
 *  実行結果が次のようになるコードを作成せよ。
 *  ただし、計算部分は println()の「( )」内に記述すること。
 *
 * ====== 実行結果 ======
 * 12 ＋ 4 ＝ 16
 * 12 ー 4 ＝ 8
 * 12 × 4 ＝ 48
 * 12 ÷ 4 ＝ 3
 */
package primaryLesson.Answer;

public class Lesson003Ans {

    public static void main(String[] args) {
        int x = 12;
        int y = 4;

        System.out.println( x + " ＋ " + y + " ＝ " + (x + y));
        System.out.println( x + " ー " + y + " ＝ " + (x - y));
        System.out.println( x + " × " + y + " ＝ " + (x * y));
        System.out.println( x + " ÷ " + y + " ＝ " + (x / y));
        System.out.println();

        //---- ( )の用法を示すため、( )を外したコード例 ----
        System.out.println( x + " ＋ " + y + " ＝ " + x + y);
        //System.out.println( x + " ー " + y + " ＝ " + x - y);
        System.out.println( x + " × " + y + " ＝ " + x * y);
        System.out.println( x + " ÷ " + y + " ＝ " + x / y);
    }//main()

}//class

/*
//====== 解説 ======
12 ＋ 4 ＝ 124 という表示結果が出た諸君は、このようなコードを書いたと思う。

 System.out.println( x + " ＋ " + y + " ＝ " + x + y);

 ◆「+」演算子 ２通りの用法
 ・数値同士の場合、「+」は足し算の記号
 ・String(文字列)と数値の場合、String(文字列)同士の結合記号
   (数値も文字列として扱われる)

 前半部分は全て文字列の結合なので
 "12 ＋ 4 ＝" + x + y となり、
 次の処理は文字列と xなので、これも文字列結合

 "12 ＋ 4 ＝ 12" + y
 これも文字列の結合のため、
 "12 ＋ 4 ＝ 124" こうなる。

 正しく足し算の結果を表示したければ、解答に示したように
 (x + y)を 先に計算しint同士の計算となるよう ( )でくくらないといけない。

 掛け算と割り算は「+」演算子よりも演算優先順位が高く、( )を付けなくても
 先に計算されるので問題ない。

 「-」は「+」と演算順位が同じなので
 「( )を付けて」という意味のコンパイルエラー。

 //====== 実行結果 ======
12 ＋ 4 ＝ 16
12 ー 4 ＝ 8
12 × 4 ＝ 48
12 ÷ 4 ＝ 3

12 ＋ 4 ＝ 124
12 × 4 ＝ 48
12 ÷ 4 ＝ 3
*/
