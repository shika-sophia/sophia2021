/**
 * @title javaGold / selfLearn / DJchap04.java
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content 第4章 制御構文 / ◇練習問題 4.1 [2]
 * @content 題意を変えて、for文を使わずに Streamで 九九を表示する試み
 * @author shika
 * @date 2021-02-17, 2021-03-08
 */

package javaGold.selfLearn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class DJchap04Multiple {
    private static int count = 1;

    //====== 2021-03-08 ======
    public static void main(String[] args) {
        List<Integer> multiplyList =
            IntStream.rangeClosed(1, 9).boxed() //IntStream -> Stream<Integer>
            .flatMap(x ->                       //２つの Stream<Integer>を１つに結合
                IntStream.rangeClosed(1, 9)     // 1-9の yを IntStreamで定義
                    .map(y -> x * y)            // 積 x * y の IntStreamへ格納
                    .boxed())                   // yの IntStream -> Stream<Integer>
            .collect(Collectors.toList());      //flatMap()で結合された Stream<Interger>を
                                                //List<Integer>に変換して代入
        multiplyList.stream()
            .forEach(xy -> {
                System.out.printf("%2d ", xy);

                if(count % 9 == 0) {
                    System.out.println();
                }
                count++;
            });
    }//main()
}//class

/*
 1  2  3  4  5  6  7  8  9
 2  4  6  8 10 12 14 16 18
 3  6  9 12 15 18 21 24 27
 4  8 12 16 20 24 28 32 36
 5 10 15 20 25 30 35 40 45
 6 12 18 24 30 36 42 48 54
 7 14 21 28 35 42 49 56 63
 8 16 24 32 40 48 56 64 72
 9 18 27 36 45 54 63 72 81

 */
//====== 2021-02-17 (失敗作) ======
//public class DJchap04Multiple {
//    static int[] x = new int[9];
//    static int[] y = new int[9];
//    static Integer result;
//
//    static {
//        x = IntStream.rangeClosed(1, 9).toArray();
//        y = IntStream.rangeClosed(1, 9).toArray();
//    }
//
//    public static void main(String[] args) {
//        Stream<Integer> resultSM =
//            Stream.generate(() -> {
//                Arrays.stream(x).map(( xe -> {
//                    Arrays.stream(y).map(ye -> {
//                        result = (Integer)(xe * ye);
//                        return result;
//                    });
//                    return result;
//                }));
//                return result;
//            }).limit(81);
//
//        Arrays.stream(x).forEach(System.out::print);
//        System.out.println();
//        Arrays.stream(y).forEach(System.out::print);
//        System.out.println();
//
//        resultSM.forEachOrdered(re -> {
//            System.out.print(re + " ");
//
//            if(re % 9 == 0) {
//                System.out.println();
//            }
//        });
//    }//main()
//
//}//class

/*
123456789
123456789
null Exception in thread "main" java.lang.NullPointerException
    at javaGold.selfLearn.DJchap04Multiple.lambda$5(DJchap04Multiple.java:47)
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
    at javaGold.selfLearn.DJchap04Multiple.main(DJchap04Multiple.java:44)
 */
/*
//====== selfLearn.DJchap04Multiple / 2021-02-17 =======
for文を使わずに、Streamで九九を表示する試み -> 失敗 Give up

＊ラムダ内でローカル変数を参照すると、finalしか無理と言われるので、
  必要な外生変数を参照したい場合は、fieldにすると解決する。

＊map()の 「引数 <no type> -> { }は対応してません」というエラー、
  { }ブロック内が完成し、returnで値を返すと解決する。

 */