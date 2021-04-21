/**
 * @title javaGold / se11Violet / Practice06VT.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content  第６章 StreamAPI
 * @author shika
 * @date 2021-04-21
 */
/* Appendix 2021-04-21
 * @costTime ※修正入力のため計測できず 11:19 - 11:21 ( 2 分)
 * @correctRate 正答率 40.00 ％ ( 〇8問 / 全20問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice06VT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class

/*
//====== 2021-04-21 ======
 第６章 StreamAPI
Ｘ （1） B, D -> B, E
    => Comparable: compare(T) 抽象メソッドは１つ。=関数型。
                オブジェクト自身が実装するためのインターフェイス。ラムダ式での利用は意味がない。
       Comparator: compareTo(T, T) 抽象メソッドは１つ。=関数型。
         BinaryOparator<T> apply(T, T)でラムダ式利用可。
    => remove(Object)
       removeAll(Collection)
       removeIf(Predicate)

〇 （2） C, E, F
〇 （3） F
    => V Map.merge(K key, V value, BiFunction<K,V,V> remap)
        ・「key=value, ...」を結合した V型の値を返す。
        ・keyが重複したときのみ、BiFunctionの処理を実行。
        ・keyが存在しないときは、新しい「key=value」を追加
        ・keyが nullのとき、keyそのものを破棄し、valueだけを結合した値になる。
    => @see chap05VT.MainMerge.java

〇 （4） E, F
Ｘ （5） F -> D
    => Stream.generate()に limit()がなく無限Stream
       Stream.anyMatch()で、falseの場合は次を探し続けるため、永久ループ。
       anyMatch()で trueが返ると、以後の判定をせずに trueとなる。
       allMatch()の falseも 最初のfalseで以後評価しない。

〇 （6） E
    => forEach()など要素を取り出す処理を行っていない。
       System.out.prinln(Stream); なので 参照先hash値。

Ｘ （7） C -> F
    => anyMatch(), count()とも終端処理。
         一度、終端したストリームを再度呼ぶと、IllegalStateExcption
Ｘ （8） B, D -> A, D
    => int IntStream.sum()
       OptionalInt IntStream.findFirst(),findAny(),max(),min()
       OptionalDouble IntStream.average()

Ｘ （9） E -> A
    => collect(Collectors)は、Stream<T>のみ。XxxxStreamでは未定義。
        よって、boxed()は必要。
        collect(Collectors.groupingBy())により {2.0=[2.0,2.0,2,0]}
        Map<K,V>.keySet()により  Set<K>を返す。 要素は[2.0]のみ。
Ｘ （10） A -> C
    => mapToInt()で DoubleStream -> IntStreamへの型変換。
       要素は mapToInt(x -> x)だと double -> intへの変換となりコンパイルエラー。
    mapToInt(x -> (int)x)なら可。
    => DoubleStream.asIntStream()なら要素ごと型変換。

〇 （11） B, F
〇 （12） E
〇 （13） D
    =>空文字「""」、空白文字「" "」
    isEmtpty()は空文字「""」のみ true

Ｘ （14） B, C, F -> A, B, F
    => i++ は演算前に戻り値が返されるため ++iに変更。
    => map(i -> "" + i)で文字列にする。Stream<Integer> -> Stream<String>
    => Collectors.joining()でも(= 引数がなくても)、そのまま結合した Stringを返す。

Ｘ （15） B => C
    => mapToInt()に 引数 ToIntFunction<T>が記述していないためコンパイルエラー。
    mapToInt(x -> x)なら、IntStreamへの変換でＯＫ。
    => Stream.findFirst()で最初の要素が Optional<Integer> で返り。
    Optional.get()で値を取り出し。

Ｘ （16） A -> D
    => Stream.findFirst() により Optional<Double>が返る。
    orElseGet()では doubleを返さなければいけない。
    "empty"という Stringを返しているので、コンパイルエラー。

Ｘ （17） E -> A
    => E: コンパイルエラーの回答理由。
        Stream<List<Chreacter>> の要素は Listなので
        そのまま println()しても、Listの参照先hash値になると思う。
    => 要素を出したければ、解答のように、flatMap(list -> list.stream())をして
    要素の Stream<Character>となってから、distinct(), forEach()かな。
    と思って検証。

    =>◆検証コード
    List<Character> charList1 = Arrays.asList('a','c');
        List<Character> charList2 = Arrays.asList('y','a');

        List<List<Character>> listList =
            Arrays.asList(charList1, charList2);
        listList.stream()
            .distinct()
            .map(e -> e)
            .forEach(System.out::println); //結果: [a, c]、 [y, a]

        listList.stream()
            .flatMap(list -> list.stream())
            .distinct()
            .forEach(System.out::print); //結果: acy

    => System.out.print(List<Character>)だから、要素が ちゃんと出るんだ。

Ｘ （18） A, B -> B, F
    => Collectors.partitioning()の戻り値は Map<Boolean, List<T>>
       partitioning()
        第２引数で Collectors.toSet()をすると、Map<Boolean, Set<T>>
    keyは Boolean固定。booleanも不可。

Ｘ （19） B, C -> A, B
    => reduce(T, BinaryOperator)は T型を返す。
       reduce(BinaryOperator)は Optional<T>なので
        値を取り出すときに Optional.get()/orElse()が必要
    => C: メソッド参照時に変更を伴う記述はコンパイルエラー。
    => mapToDouble()で Stream<Double> -> DoubleStream
    DoubleStream.reduce(DoubleBinaryOperator)で
    引数に BinaryOperatorを渡せない。

〇 （20） D

開始時刻 11:19
終了時刻 11:21
所要時間 2 分
正答率 40.00 ％ ( 〇8問 / 全20問 )
*/

