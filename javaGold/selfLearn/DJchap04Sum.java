/**
 * @title javaGold / selfLearn / DJchap04.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第4章 制御構文 / ◆章末問題 [2] / p141
 * @content 題意を変えて、 p136 List4.24を
 *          Streamで 1-100までの合計が1000以上になったらbreakをする試み
 * @author shika
 * @date 2021-02-17
 */
package javaGold.selfLearn;

import java.util.stream.IntStream;

public class DJchap04Sum {
    static int sumStatic;
    static int count;

    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 100).sum();
        int sumLimit = IntStream.rangeClosed(1, 100)
            .filter(s -> {
                sumStatic += s;
                return sumStatic <= 1000;
            }).map(s -> {
                count++; //値はそのまま返し、ここを通過する回数をカウント
                return s;
            }).sum();

        System.out.println("sum: " + sum);
        System.out.println("sumLimit: " + sumLimit);
        System.out.println("count : " + count);
        System.out.printf("合計が1000を超えるのは 1 ～ %d を加算したとき", count + 1);
    }//main()

}//class

/*
//====== result ======
sum: 5050
sumLimit: 990
count : 44
合計が1000を超えるのは 1 ～ 45 を加算したとき
*/
/*
long count = IntStream.rangeClosed(1, 100)
.filter(s -> {
    sumStatic += s;
    return sumStatic <= 1000;
}).count();

count : 0
【考察】この count 0は、よくわからない。
*/
/*
int sumLimit = IntStream.rangeClosed(1, 100)
.filter(s -> {
    count++;
    sumStatic += s;
    return sumStatic <= 1000;
}).sum();

count : 100

【考察】 合計が 1000を超えても、filter()には 100までの値がやってきて
true / falseの判定をしていくので、上記のコードだと  count : 100 という結果。
*/