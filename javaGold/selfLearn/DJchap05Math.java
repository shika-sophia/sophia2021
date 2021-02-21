/**
 * @title javaGold / selfLearn / DJchap05nioFile.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第5章 標準ライブラリ: String, regex, LocalDateTime,
 *          ioFile, Math, Random, NumberFormat, Arrays, HttpClient
 * @content ◆章末問題[4], p227
 * @author shika
 * @date 2021-02-21
 */
package javaGold.selfLearn;

import java.util.Arrays;
import java.util.stream.Stream;

public class DJchap05Math {

    public static void main(String[] args) {
        //[4]① 6の3乗 ② -15の絶対値
        double power = Math.pow(6, 3);
        int abs = Math.abs(-15);

        System.out.println("power: " + (int)power);
        System.out.println("abs: " + abs);

        //[4]③ 110, 14, 28, 32 の値を持つ配列を定義し sort()
        int[] array = {110, 14, 28, 32};
        Arrays.sort(array);
        System.out.println("array: " + Arrays.toString(array));

        //[4]改
        System.out.print("stream: ");
        Stream.of(110, 14, 28, 32)
            .sorted()
            .map(i -> i + " ")
            .forEachOrdered(System.out::print);
    }//main()

}//class

/*
power: 216
abs: 15
array: [14, 28, 32, 110]
stream: 14 28 32 110
*/
