package javaGold.selfLearn;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DJchap10Functional {

    public static void main(String[] args) {
        //---- [3]③ ----
        Stream.of("ABCDE","OP","WXYZ","HIJKL")
        .filter(s -> s.length() >= 3)
        .map(s -> s.substring(0, 3) + " ")
        .forEach(System.out::print);
        System.out.println();

        //---- [3]④ ----
        Stream.of("シュークリーム","プリン","マドレーヌ","ババオア")
        .sorted((str1, str2) -> -(str1.length() - str2.length()))
        .map(s -> s + " ")
        .forEach(System.out::print);
        System.out.println();

        //---- [3]⑤ ----
        IntSummaryStatistics summary = IntStream.of(60, 95, 75, 80, 70)
                .collect(
                    IntSummaryStatistics::new,
                    IntSummaryStatistics::accept,
                    IntSummaryStatistics::combine
                );

        System.out.println("最高点: " + summary.getMax());
        System.out.println("平均点: " + summary.getAverage());

    }//main()

}//class

//---- [3]① ----
@FunctionalInterface
interface Hoge {
    abstract void print(String str);
}

//---- [3]② ----
@FunctionalInterface
interface Foo {
    abstract <T, R> R process(T v1, T v2);
}

/*
//---- ③ ----
ABC WXY HIJ

//---- ④ ----
＊sorted(Comparator.reverseOrder())
マドレーヌ プリン ババオア シュークリーム
【考察】これだと アイウエオ順の逆順。題意は文字列の長い順。

＊sorted((str1, str2) -> str1.length() - str2.length())
プリン ババオア マドレーヌ シュークリーム
【考察】これだと正順。 引数２つ入れるだけで
    Comparator<String>.compare(String, String)が呼び出される様子。

＊sorted((str1, str2) -> -(str1.length() - str2.length()))
シュークリーム マドレーヌ ババオア プリン
【考察】これで逆順。マイナス付けずに str1, str2の位置を入れ替えてもいい。

//---- ⑤ ----
最高点: 95
平均点: 76.0
*/