/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainAggregate.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2.4 StreamAPI 終端処理 / p497 / List 10-38, 10-39, 10-40
 * @content ◆集計関数 = Aggregate: 集計
 *          Optional<T> min(Comparator)
 *          Optional<T> max(Comparator)
 *          long count()
 *          int IntStream.sum()
 *          OptionalDouble IntStream.average()
 * @author shika
 * @date 2021-04-19
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainAggregate {

    public static void main(String[] args) {
        List<String> list =
            Stream.of("あじ","さんま","ほっけ","まぐろ","ぶり")
            .collect(Collectors.toList());

        //---- min(), max() ----
        Optional<String> listMin = list.stream()
            .min(Comparator.naturalOrder());
        System.out.println("listMin: " + listMin.orElse(""));

        Optional<String> listMax = list.stream()
            .max(Comparator.naturalOrder());
        System.out.println("listMax: " + listMax.orElse(""));

        //---- count() ----
        System.out.println("listLength(s > 2): " +
            list.stream()
                .filter(s -> s.length() > 2)
                .count()
        );

        //---- IntStream.sum(), avarage() ----
        var data = new int[] {5, 1, 10, -3};
        int sum = IntStream.of(data).sum();
        OptionalDouble average = IntStream.of(data).average();

        System.out.println("data: " + Arrays.toString(data));
        System.out.println("data.sum: " + sum);
        System.out.println("data.average: " + average.orElse(0));
    }//main()

}//class

/*
//---- min(), max() ----
listMin: あじ
listMax: まぐろ

//---- count() ----
listLength(s > 2): 3

//---- sum(), average() ----
data: [5, 1, 10, -3]
data.sum: 13
data.average: 3.25

*/