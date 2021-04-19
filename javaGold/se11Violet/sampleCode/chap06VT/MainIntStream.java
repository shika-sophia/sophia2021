/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainIntStream.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2 StreamAPI / p484 / List 10-23 ～ 10-25, 10-29 ～ 10-31
 * @content IntStream IntStream.range(int, int)
 *          IntStream IntStream.rangeClosed(int, int)
 *          Stream<T>/ IntStream skip(long), limit(long)
 *          IntStream IntStrem.dropWhile(IntPredicate) 条件式に合致している間、初回のみskip
 *          IntStream IntStrem.takeWhile(IntPredicate) 条件式に合致している間、初回のみ取得
 *          DoubleStream IntStream.asDoubleStream() 要素をdoubleに変換し、型もDoubleStreamに変換
 *          IntStram -> Stream<Integer>:  mapToObj(IntFunction<R>), boxed()
 *          Stream<Integer> -> IntStream: mapToInt(ToIntFunction<T>)
 * @author shika
 * @date 2021-04-19
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainIntStream {

    public static void main(String[] args) {
        //---- range(), skip(), limit() ----
        IntStream.range(1,20)
            .skip(4)
            .limit(10)
            .forEach(i -> System.out.print(i +" "));
        System.out.println();

        //---- dropWhile() ----
        IntStream.of(-2, -5, 0, 3, -1, 2)
            .dropWhile(i -> i < 0)
            .forEach(i -> System.out.print(i +" "));
        System.out.println();

        //---- takeWhile() ----
        IntStream.of(-2, -5, 0, 3, -1, 2)
            .takeWhile(i -> i < 0)
            .forEach(i -> System.out.print(i +" "));
        System.out.println();

        //---- asDoubleStream() ----
        IntStream.range(1, 5)
            .asDoubleStream()
            .forEach(i -> System.out.print(i +" "));
        System.out.println();

        //IntStream -> Stream<Integer>
        IntStream.range(1, 5)
            .boxed()
            .forEach(i -> System.out.print(i +" "));
        System.out.println();

        IntStream.rangeClosed(1, 5)
            .mapToObj(Integer::valueOf)
            .forEach(i -> System.out.print(i +" "));
        System.out.println();

        //Stream<Integer> -> IntStream
        Stream.iterate(1, i -> i + 2).limit(5)
            .mapToInt(i -> i)
            .forEach(i -> System.out.print(i +" "));
        System.out.println();
    }//main()

}//class

/*
//---- range(), skip(), limit() ----
5 6 7 8 9 10 11 12 13 14

//---- dropWhile() ----
条件式に合致している間、初回のみskip
0 3 -1 2

//---- takeWhile() ----
条件式に合致している間、初回のみ取得
-2 -5

//---- asDoubleStream() ----
1.0 2.0 3.0 4.0

//---- boxed(), mapToObj(), mapToInt() ----
1 2 3 4
1 2 3 4 5
1 3 5 7 9
*/