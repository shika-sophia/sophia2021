/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainCollectorsAggregate.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI / p247 / List 6-27, 6-20, 6-28
 * @content ◆Collectorsファクトリメソッド / 集計関数
 *          ＊static mapping()
 *          戻値: Collector<T, ?, R>
 *          引数: mapping(Function<? super T, ? extends U> mapper,
 *                        Collector<? super U,A,R> downstream )
 *
 *          ＊static summingInt()
 *          戻値: Collector<T, ?, Integer>
 *          引数: summingInt(ToIntFunction<? super T>)
 *
 *          ＊static averagingInt()
 *          戻値: Collector<T, ?, Double>
 *          引数: averagingInt(ToIntFunction<? super T>)
 *
 *          ＊static maxBy()
 *          戻値: Collector<T, ?, Optional<T>>
 *          引数: maxBy(Comparator<? super T>)
 *
 *          ＊static minBy()
 *          戻値: Collector<T, ?, Optional<T>>
 *          引数: minBy(Comparator<? super T>)
 *
 * @author shika
 * @date 2021-04-20
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainCollectorsAggregate {

    public static void main(String[] args) {
        List<String> list =
            Stream.of("naoki","akko","ami")
            .collect(Collectors.toList());
        System.out.println("list: " + list);

        //---- mapping() ----
        String upper =
            list.stream()
                .collect(
                    Collectors.mapping(s -> s.toUpperCase(),
                    Collectors.joining(" / ") )
                );
        System.out.println("upper: " + upper);

        List<Integer> lengthList =
                list.stream()
                .collect(
                        Collectors.mapping(s -> s.length(),
                                Collectors.toList())
                        );
        System.out.println("lengthList: " + lengthList);

        //---- summingInt() ----
        Integer sum =
            list.stream()
            .collect(
                Collectors.summingInt(s -> s.length())
            );
        System.out.println("sum: " + sum);

        //---- averagingInt() ----
        Double average =
            list.stream()
            .collect(
                Collectors.averagingInt(s -> s.length())
            );
        System.out.println("average: " + average);

        //---- minBy() ----
        Optional<String> minStr =
            list.stream()
                .collect(
                    Collectors.minBy(Comparator.naturalOrder())
                );
        System.out.println("minStr: " + minStr.get());

        //---- maxBy() ----
        Map<String, Optional<String>> groupMax =
            IntStream.of(101, 102, 105, 203, 207)
            .mapToObj(i -> String.valueOf(i))
            .collect(
                Collectors.groupingBy(
                    s -> s.substring(0,1),
                    Collectors.maxBy(Comparator.naturalOrder())
                )
            );
        System.out.println("groupMax: " + groupMax);
    }//main()

}//class

/*
//---- mapping() ----
list: [naoki, akko, ami]
upper: NAOKI / AKKO / AMI
lengthList: [5, 4, 3]

//---- summingInt() ----
sum: 12

//---- averagingInt() ----
average: 4.0

//---- minBy() ----
minStr: akko

//---- maxBy() ----
groupMax: {1=Optional[105], 2=Optional[207]}

*/