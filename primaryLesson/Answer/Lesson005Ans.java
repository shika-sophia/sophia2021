/**
 * @title primaryLesson / primaryAns / Lesson005Ans.java
 * @content System.out.printf();
 * @author shika
 * @dete 2021-01-28
 */
/*
 * ◆Lesson005
 * print(), println()メソッドの仲間に printf()メソッドがある。
 * 「ｆ」は formatの fで、表示内容の書式を設定することができる。
 *
 * 〔ヒント〕 printf()の使い方
 * String name = "Your Name";
 * System.out.printf("名前: %s", name);
 * //実行結果[ 名前: Your Name ]
 *
 * printf()は、" "内に変数の値を代入して表示する。
 * 代入する場所は、「%s」という記号で示す。
 *
 * String name = "Your Name";
 * int age = 24;
 * System.out.printf("名前: %s / 年齢 %d歳", name, age);
 * //実行結果[ 名前: Your Name / 年齢 24歳 ]
 *
 * 今回は記号が違っているが、
 * 	文字 -> %s
 * 	整数 -> %d
 * の記号で、変数の値を挿入する位置を指定する。
 * 代入順は、" "の後ろに、配置する変数の順になる。
 * (代入順も指定できるが、最初のうちは こう覚えて使ってみよう)
 *
 * 〔問題〕
 * 上記のヒントを参考にして、
 * 自分の名前、年齢、生年月日を printf()で表示せよ。
 */
package primaryLesson.Answer;

public class Lesson005Ans {

    public static void main(String[] args) {
        String name = "Your Name";
        int age = 24;
        String birth = "1972-11-24";

        System.out.printf("名前: %s / 年齢 %d歳 / 誕生日 %s \n",
            name, age, birth);
    }//main()

}//class

/*
//====== 実行結果 ======
名前: Your Name / 年齢 24歳 / 誕生日 1972-11-24
*/
