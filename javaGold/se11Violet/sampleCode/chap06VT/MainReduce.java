/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainReduce.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2.4 StreamAPI 終端処理 / p498 / List 10-41, 10-42, 10-43
 * @content ◆Stream.reduce(): Streamを集計して１つの値にまとめる
 *          Optional<T> reduce(BinaryOperator<T>)
 *          T reduce(T identity, BinaryOperator<T>)
 *          U reduce(U identity,
 *                   BiFunctuin<U, ? super T, U> accumulator,
 *                   BinaryOperator<U> combiner)
 * @author shika
 * @date 2021-04-19
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainReduce {

    public static void main(String[] args) {
        List<String> list =
            Stream.of("バラ","さくら","チューリップ","あさがお","ゆり")
            .collect(Collectors.toList());

        //Optional<T> reduce(BinaryOperator<T>)
        System.out.println("result: " +
            list.stream()
                .sorted()
                .reduce((result, str) -> result + " / " + str)
                .orElse("")
        );

        //T reduce(T identity, BinaryOperator<T>)
        System.out.println("result: " +
            list.stream()
                .sorted()
                .reduce("ひまわり", (result, str) -> result + " / " + str)
        );

        //U reduce(U identity,
        //         BiFunctuin<U, ? super T, U> accumulator,
        //         BinaryOperator<U> combiner)
        System.out.println(
            Stream.of("153","211","112","350","418","208")
                .parallel()
                .reduce(0,
                    (result, value) -> result + Integer.parseInt(value),
                    (result1, result2) -> result1 + result2
                )
        );

    }//main()

}//class

/*
//---- reduce(BinaryOperator<String>) ----
result: あさがお / さくら / ゆり / チューリップ / バラ

//---- reduce(T, BinaryOperator<T>) ----
result: ひまわり / あさがお / さくら / ゆり / チューリップ / バラ

//---- reduce(identity, accumulator, combiner) ----
1452

*/