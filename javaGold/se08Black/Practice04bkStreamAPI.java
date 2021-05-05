/**
 * @title javaGold / se08Black / Practice04bkStreamAPI.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  第４章 StreamAPI
 * @author shika
 * @date 2021-05-05
 */
/* Appendix 2021-05-05
 * @costTime 08:09 - 08:36 ( 26 分)
 * @correctRate 正答率 84.00 ％ ( 〇21問 / 全25問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Practice04bkStreamAPI {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-05 ======
 第４章 StreamAPI
〇 （1） C, D
〇 （2） C, D
〇 （3） A, C
     => ◆BaseStream<T, S extends BaseStream<T, S>>
          sub -> Stream<T>, IntStream, LongStream, DoubleStream

〇 （4） A
〇 （5） D
〇 （6） D
      => 終端処理を２回呼ぶと IllegalStateException

〇 （7） D
      => default void Map.forEach(BiConsumer<K, V>)は引数２つ
          System.out.println(k + v);
          k.toString(), v.toString()で要素がそのまま表示される。

〇 （8） C
      => IntStream stream = Arrays.stream(int[]);
      int[]からは Stream<Integer>ではなく、IntStreamが生成される。

〇 （9） C
      => IntStream Arrays.stream(int[], int start, int end);
      endは含まず。配列の一部のみ stream化するオーバーロード。

〇 （10） A, F
〇 （11） B
〇 （12） B, D
      => Stream<String> java.io.BufferedReader.lines()
      => Stream<String> java.nio.file.Files.lines(Path) / static

〇 （13） D
   => map [英]写像

〇 （14） A
〇 （15） C
      => Stream.sorted(Comparator)
      => Collection.sort(Comparator)

Ｘ （16） D -> C
      => Comparator.compare(T, T) <- この抽象メソッドに代入する BinaryFunction<T>
      => Comparator.comparing(Function<T, R>)

〇 （17） C
    => Streamの処理はメソッドごとに全要素を処理しているのではなく、
        １つの要素ごとに、個別に各メソッドを処理している。
〇 （18） A, B, C
Ｘ （19） D -> B
    => boolean Stream<T>.allMatch(Predicate<? super T>)
       boolean Stream<T>.anyMatch(Predicate<? super T>)
       allMatch()は「&&」、途中で falseが出ると以後の評価はしない。
       anyMatch()は「||」、途中で trueが出ると以後の評価はしない。

〇 （20） D
Ｘ （21） F -> D
    => default V Map.merger(K, V, BiFunction<K, V, V>)
    Mapのメソッドであって、Streamの終端処理ではない。
    Kが重複した場合、第三引数の結合関数による処理で Vを生成、
    Kが存在しない場合、新たなkey=valueを生成。
    結合関数が nullを返すと key=valueとも破棄される。〔DJ 130〕

〇 （22） B
Ｘ （23） D -> E
    => 初期値 1で、 1, 2, 3を加算 -> 7

〇 （24） A
〇 （25） D
    => 戻り値 Collector<T, ?, Double>
       Collectors.summingDouble(ToDoubleFunction<T>)
    -> 〔DJ 143 / YM Gold p247〕

開始時刻 08:09
終了時刻 08:36
所要時間 26 分
正答率 84.00 ％ ( 〇21問 / 全25問 )
*/

