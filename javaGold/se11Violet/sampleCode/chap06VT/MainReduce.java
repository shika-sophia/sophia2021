/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainReduce.java
 * @reference YM: 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI / p225 / List 6-5, 6-6
 * @reference DJ: 山田祥寛『独習 Java 新版』 翔泳社, 2019
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
import java.util.Optional;
import java.util.function.BinaryOperator;
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

        //---- YM: List 6-5 ----
        int result1 = Stream.of(10, 20, 30)
                      .reduce(0, Integer::sum);
        System.out.println("result1: " + result1);

        //---- YM: List 6-6
        BinaryOperator<Integer> operator = (a,b) -> a + b;
        Stream<Integer> stream2 = Stream.of(10, 20, 30);

        //int result2 = stream2.reduce(operator);
        //型の不一致: Optional<Integer> から int には変換できません

        Optional<Integer> result2 = stream2.reduce(operator);
        result2.ifPresent(System.out::println); //結果 60

        Stream<Integer> stream3 = Stream.empty();
        Optional<Integer> result3 = stream3.reduce(operator);
        System.out.println(result3);           // 結果 Optional.empty
        result3.ifPresent(System.out::println);// 結果 (出力なし)
        System.out.println(result3.isEmpty()); //　結果 true
    }//main()

}//class

/*
//---- reduce(BinaryOperator<String>) ----
result: あさがお / さくら / ゆり / チューリップ / バラ

//---- reduce(T, BinaryOperator<T>) ----
result: ひまわり / あさがお / さくら / ゆり / チューリップ / バラ

//---- reduce(identity, accumulator, combiner) ----
1452

//---- YM: List 6-5 ----
result1: 60

T BinaryOperator<T> apply(T, T)
int Integer.sum(int, int)
メソッド参照が使える

//---- YM: List 6-6 ----
60
Optional.empty
(出力なし) <- ifPresent(empty)
true
*/