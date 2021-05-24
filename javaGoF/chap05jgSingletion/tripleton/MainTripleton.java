/**
 * @title javaGoF / chap05JG / MainTripleton.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第５章 Singleton / 練習問題 5-2
 * @content Tripletonインスタンスは３つまで
 * @author shika
 * @date 2021-04-17
 */
package javaGoF.chap05jgSingletion.tripleton;

import java.util.stream.IntStream;

public class MainTripleton {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5).boxed()
            .map(i -> Tripleton.getInstance(i))
            .forEach(tri -> System.out.println(
                tri.getClass() + ":ID " + tri.getId()));
    }//main()

}//class

/*
class javaGoF.chap05jgSingletion.tripleton.Tripleton:ID 1
class javaGoF.chap05jgSingletion.tripleton.Tripleton:ID 2
class javaGoF.chap05jgSingletion.tripleton.Tripleton:ID 3
class javaGoF.chap05jgSingletion.tripleton.Tripleton:ID 3
class javaGoF.chap05jgSingletion.tripleton.Tripleton:ID 3

【考察】
getInstance()は 5回したけど、
インスタンスは 3つまで
 */
