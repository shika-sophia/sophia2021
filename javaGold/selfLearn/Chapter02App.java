/**
 * @title javaGold / selfLearn / Chapter02App.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content ◆章末問題 / p76 [5]のみ
 * @author shika
 * @date 2021-02-15
 */
package javaGold.selfLearn;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class Chapter02App {

    public static void main(String[] args) {
        //(1) varを用いて double型のvalue 10を初期化
        var value = 10d;

        //(2) 「ようこそ、\nJavaへ」と改行を含んだ文字列を表示
        String str = " ようこそ、\n Javaへ";

        //(3)String strを宣言し初期値 null
        String str2 = null;

        //(4) varを使わず  int型の配列data 5行×4列を定義
        int[][] data = new int[5][4];

        //(5) varを利用しint型配列 list {2, 3, 5}, {1, 2}, {10, 11, 12, 13} を定義
        var list = new int[][] {
            {2, 3, 5},
            {1, 2},
            {10, 11, 12, 13}
        };

        //---- test print ----
        System.out.printf("value: %.2f \n", value);
        System.out.println("str: " + str);
        System.out.println("str2: " + str2);
        //System.out.println("data: " + data);

        Arrays.stream(data)
        .flatMapToInt(ary -> Arrays.stream(ary))//2次元配列を結合し、１次元配列へ
        .boxed()                                // IntStream -> Stream<Integer>
        .map((Function<Integer, Integer>) v -> {//各要素にランダムで値を設定
            var rdm = new Random();
            v = rdm.nextInt(100);
            return v;
        })
        .forEach(s -> System.out.print(s + " "));
        System.out.println();

        Arrays.stream(list)
            .flatMapToInt(v -> Arrays.stream(v))//2次元配列を結合し、１次元配列へ
            .forEach(s -> System.out.print(s + " "));

    }//main()

}//class

/*
//====== Result ======
value: 10.00
str:  ようこそ、
 Javaへ
str2: null
69 92 21 22 35 83 89 67 16 84 92 64 83 76 9 67 32 25 2 51
2 3 5 1 2 10 11 12 13
 */
/*
//======= Chapter02App / 2021-02-15 ======
PracticeEditorは改行すると、次の回答に移ってしまうため、
コードや長文回答を記述しずらい。
もともと、JavaGoldなどの 選択式の回答用なので、
swing.JTextAreaで作るしかなさそう。
swingを使えば、PeasonVueの本番のようなアプリを作れそうだが
問題を読み込んで来るのが大変なのと、それ作る時間に試験対策したほうがいい。
*/
