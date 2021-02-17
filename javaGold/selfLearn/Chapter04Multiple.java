/**
 * @title javaGold / selfLearn / Chapter04.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第4章 制御構文 / ◇練習問題 4.1 [2]
 * @content 題意を変えて、for文を使わずに Streamで 九九を表示する試み
 * @author shika
 * @date 2021-02-17
 */

package javaGold.selfLearn;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter04Multiple {
    static int[] x = new int[9];
    static int[] y = new int[9];
    static Integer result;

    static {
        x = IntStream.rangeClosed(1, 9).toArray();
        y = IntStream.rangeClosed(1, 9).toArray();
    }

    public static void main(String[] args) {
        Stream<Integer> resultSM =
            Stream.generate(() -> {
                Arrays.stream(x).map(( xe -> {
                    Arrays.stream(y).map(ye -> {
                        result = (Integer)(xe * ye);
                        return result;
                    });
                    return result;
                }));
                return result;
            }).limit(81);

        Arrays.stream(x).forEach(System.out::print);
        System.out.println();
        Arrays.stream(y).forEach(System.out::print);
        System.out.println();

        resultSM.forEachOrdered(re -> {
            System.out.print(re + " ");

            if(re % 9 == 0) {
                System.out.println();
            }
        });
    }//main()

}//class

/*
123456789
123456789
null Exception in thread "main" java.lang.NullPointerException
    at javaGold.selfLearn.Chapter04Multiple.lambda$5(Chapter04Multiple.java:47)
    at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    at java.base/java.util.stream.SliceOps$1$1.accept(SliceOps.java:199)
    at java.base/java.util.stream.StreamSpliterators$InfiniteSupplyingSpliterator$OfRef.tryAdvance(StreamSpliterators.java:1360)
    at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:127)
    at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:502)
    at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:488)
    at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    at java.base/java.util.stream.ReferencePipeline.forEachOrdered(ReferencePipeline.java:502)
    at javaGold.selfLearn.Chapter04Multiple.main(Chapter04Multiple.java:44)
 */
/*
//====== selfLearn.Chapter04Multiple / 2021-02-17 =======
for文を使わずに、Streamで九九を表示する試み -> 失敗 Give up

＊ラムダ内でローカル変数を参照すると、finalしか無理と言われるので、
  必要な外生変数を参照したい場合は、fieldにすると解決する。

＊map()の 「引数 <no type> -> { }は対応してません」というエラー、
  { }ブロック内が完成し、returnで値を返すと解決する。

 */