/**
 * @title javaGold / se11White / Practice06WH.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content  第６章 StreamAPI
 * @author shika
 * @date 2021-04-18
 */
/* Appendix 2021-04-18
 * @costTime 12:42 - 13:35 ( 52 分)
 * @correctRate 正答率 68.42 ％ ( 〇13問 / 全19問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice06WH {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-18 ======
 第６章 StreamAPI
〇 （1） B
〇 （2） D
    => ◆Streamの生成
        Arrays.stream()
        Collection.stream()
        String.chars()
        String.codePoints() :サロゲートペア(= 4バイト文字)に対応した Stream<String>
        Files.lines(Path [,Charset])
        Files.list(Path)
        BufferedReader.lines()
        Stream.of(T), of(T...), empty()
        Random.ints([int, int])
        Random.doubles([double, double])

〇 （3） C
Ｘ （4） D -> B
    => mapToInt(ToIntFunction<T>): int applyAsInt(T)
        D: mapToInt(x -> x) 戻り値に Stringを渡しているのでコンパイルエラー
    => filter(Preadicate<T>)は、trueになった要素のみを残すが
        Stream内の要素の型は変更しない。

〇 （5） B
    => Stream.count()の戻り値は、longなので、(int)にキャストするのは必要。
    終端処理の戻り値は Stream<T>ではない。

〇 （6） C
    => Stream.skip(int): indexではなく個数をskip
〇 （7） C
〇 （8） B
    =>  別Streamで行われた filter()はそのStream内だけの処理
        別ストリームであっても、map()で行われた
        C.setRank()は Customerクラスのフィールドに保存されるため
        値の変更は残る

〇 （9） B
    => map(s -> s.concat(s.toUpperCase())
        String s と sを大文字にしたものを結合した文字列を返す

〇 （10） D
Ｘ （11） A -> C
    => Stream.peek()は中間処理。peek(System::print);で終了していると
    終端処理が行われていないので、Stream内の処理は何も実行されない。

〇 （12） B
Ｘ （13） A -> B
    => boolean Stream.allMatch(Predicate<T>): 全ての要素が条件にマッチするか
    要素の途中で falseがあると、それ以降の要素は評価せずに 結論である falseを返す。

〇 （14） B
    => List<String> Files.readAllLines()
        Files.readAllLines.stream()で List<String>.stram()をしたことになり、
        Stream<String>が生成される。
    => 読み込んだ行を要素とする Streamから forEach()で各要素を表示。

Ｘ （15） D -> C
    => D:コンパイルエラーとした回答理由
    listは Arrays,asList()で作られており、要素数の変更は不可と判断したが
    list = Stream.collect(Collectors.toList());は
    new Listを生成して代入しているので、上記の判断は誤り。

〇 （16） D
    => static Optional<t> Optional.ofNullable(T):
        引数に値があれば その値をラップした Optional<T>を返す。
        引数が nullの場合は 空の Optional<T>を返す。
    => boolean Optional.isPresent():
        値があれば true, それ以外なら false
    => add1.isPresent() ? add1.get() : "Not";
    三項演算子。get()は値がないと NoSuchElementExceptionを throwするので
    こういう形で使うと良い。
    if(add.isPresen()){ add.get() } else { }と同じ処理。

Ｘ （17） B -> A
    => Conparator<T> Comparator.comparing(Function<T,R>)
        引数に指定した式で比較を行う Comparator<T>を生成するファクトリーメソッド。

    => Optional<T> Stream.min(c)/max(c) 引数 cは Comparator<T>
        Stream要素の最小値/最大値を Optional<T>で返す。
        戻り値が Optionalであることに注意。
        値を取り出すには Optional.get(), isElse()が必要
    => Integer.min(Comparator)は内部的に
        Comparator<Integer>.compare(Integer o1, Integer o2) {
            return Integer.min(o1, o2);
        }
        となり、常に最小値 50をreturn。
        「第１引数が第２引数より大きい場合」という判断となり、
        要素の大小は正しく判断されない。
        コレクションの最後の要素が常に最小値と判定する。とのこと。
        (?) ここよくわからない WHp182

Ｘ （18） C -> B
    => C:コンパイルエラーと回答した理由 forEach()の２つの引数を取るSteramがどこから来たのか分からず
        引数２つの BiComsumerは使えないだろうと判断したから。
    => Collector<T, ?, Map<List<T>> Collectors.groupingBy(Function<T,K>)
    groupingBy(Employee::getLoc)の戻り値は
    locでグループ化された Map<String, List<Emplyee>)の Collectorsオブジェクトとなり
    collect(Collectors.groupingBy())の戻り値 Map<String, List<Employee>>
    String keyは loc値の"Tokyo", "Osaka"

    forEach(BiConsumer<K, V>)で Mapの要素を取り出し
    forEach((str, res) -> System.out.println(res))を
    ラムダ式を使わずに書くと
    forEach(new BiConsumer<String,List<Emproyee>>() {
        public void accept(String str, List<Emplyee> res) {
            System.out.println(res);
        }
    });

〇 （19） D
    => ◆Stream.reduce()
        ＊Optional<T> reduce(BinaryOperator<T>)
            引数に accumulatorで 処理をして値を集約
        ＊T reduce(T, BinaryOpareator<T>)
            引数 identity(= 初期値), accumlator
            初期値に値を集約し、初期値の型である Tを返す
    => reduce(new Item(4.0), (i1, i2) -> {
            i1.qu += i2.qu;
            retrun new Item(i1.no, i1.qu);
        })

        reduce(new Item(4.0), new BinaryOparator<Item>() {
            public Item apply(Item i1, Item i2){
                i1.qu += i2.qu;
                retrun new Item(i1.no, i1.qu);
            }
        }
        i1は 初期値である new Item(4, 0)。ここに集計処理で加算していく
        i2は Streamの各要素が入り i2.quより、 0 + 10 + 30 + 30 = 70
        retrun new Item(4, 70);

    => reduce((i1, i2) -> i1.qu > i2.qu ? i1 : i2)
    Itemのフィールド quを比較して大きいほうの オブジェクトを残す。
    結果、quが 70の Item(4, 70)が残り、
    Optional<Item>.ifPresent(System.out::print)で表示

開始時刻 12:42
終了時刻 13:35
所要時間 52 分
正答率 68.42 ％ ( 〇13問 / 全19問 )
*/

