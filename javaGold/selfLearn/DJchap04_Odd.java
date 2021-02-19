/**
 * @title javaGold / selfLearn / DJchap04_Odd.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第4章 制御構文 / ◆章末問題 [3] / p141
 * @content 題意を変えて、 100-200の奇数の合計をStreamで求める
 * @content [英] odd: 奇数, even:偶数
 * @author shika
 * @date 2021-02-17
 */
package javaGold.selfLearn;

import java.util.stream.IntStream;

public class DJchap04_Odd {

    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(100, 200).sum();
        int sumOdd = IntStream.rangeClosed(100, 200)
            .filter(i -> (i % 2 == 1))
            .sum();

        System.out.println("sum: " + sum);
        System.out.println("sumOdd: " + sumOdd);
    }//main()

}//class

/*
sum: 15150
sumOdd: 7500
 */
