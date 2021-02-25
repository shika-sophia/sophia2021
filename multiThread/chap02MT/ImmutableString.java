/**
 * @title multiThread / chap02MT / ImmutableString.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable 練習問題 2-3
 * @content List A2-2 / Stringの immutability(不変性)を検証。
 * @author shika
 * @date 2021-02-25
 */
package multiThread.chap02MT;

public class ImmutableString {

    public static void main(String[] args) {
        String original = "BAT";
        String replaced = original.replace('B', 'C');

        System.out.println("original: " + original);
        System.out.println("replaced: " + replaced);

        System.out.println("original == replaced: " + (original == replaced));

    }//main()

}//class

/*
＊replace('B', 'C');
original: BAT
replaced: CAT
original == replaced: false
新しい Stringオブジェクトを生成。元のStringは元のまま存在している(不変)。

＊replace('B', 'B');
original: BAT
replaced: BAT
original == replaced: true

replace()の置換文字を同じにすると、
Stringオブジェクトは新しく生成されず
コンスタントプールにあるStringオブジェクトを再利用している。
*/