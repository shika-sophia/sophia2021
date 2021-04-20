/**
 * @title javaGold / se11Violet / sampleCode / chap06VT / MainSummaryStatistics.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第６章 StreamAPI
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 10.2.4 StreamAPI 終端処理 / p509 / List 10-52
 * @content ◆XxxxSummaryStatisticsクラス / Xxxx = Int, Long, Double
 *          long summ.getCount(): 要素の個数
 *          T summ.getMax(): 最大値 (値がないときは MAX_VALUE)
 *          T summ.getMin(): 最小値 (値がないときは MIN_VALUE)
 *          T summ.getSum(): 合計値 (値がないときは 0)
 *          double summ.getAverage(): 平均値 (値がないときは 0)
 *
 *          ◆Stream.collect()
 *          戻値: XxxxSummryStatisticsオブジェクト
 *          定型文: collect(XxxxSummaryStatistics::new,
 *                         XxxxSummaryStatistics::accept,
 *                         XxxxSummaryStatistics::combine )
 *
 * @author shika
 * @date 2021-04-20
 */
package javaGold.se11Violet.sampleCode.chap06VT;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class MainSummaryStatistics {

    public static void main(String[] args) {
        IntSummaryStatistics summ =
            IntStream.of(5, 13, 7, 2, 30)
            .collect(IntSummaryStatistics::new,
                     IntSummaryStatistics::accept,
                     IntSummaryStatistics::combine
             );

        System.out.println("count: " + summ.getCount());
        System.out.println("max: " + summ.getMax());
        System.out.println("min: " + summ.getMin());
        System.out.println("sum: " + summ.getSum());
        System.out.printf("ave: %.2f", summ.getAverage());
    }//main()

}//class

/*
count: 5
max: 30
min: 2
sum: 57
ave: 11.40
*/