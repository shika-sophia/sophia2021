/**
 * @title javaGold / se11White / Examin02WH.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content  White 総合問題２
 * @author shika
 * @date 2021-05-22
 */
/* Appendix 2021-05-22
 * @costTime 10:05 - 13:07 ( 182 分)
 * @correctRate 正答率 68.75 ％ ( 〇55問 / 全80問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Examin02WH {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-22 ======
 White 総合問題２
〇 （1） A
      => staticメソッドはそのインターフェイスにのみ付属
      *  継承クラスには defaultメソッドのみ引き継がれる。

Ｘ （2） C, D -> B, C
    => 〇B: アプリケーション側だけでなく、DB側でも検証可能。
    *  〇C: アプリケーションにとって有効な入力値のみ受入。
      *  Ｘ D: 入力値を修正することは適切ではない。

〇 （3） B
〇 （4） C, D
Ｘ （5） D -> B
   => Set.add(null)はＯＫ。
   *  Setの値の重複は add() falseで無視される。
   => Mapの key重複は 後のput()の valueが上書きされる。
〇 （6） B
〇 （7） B
〇 （8） A
〇 （9） C
Ｘ （10） A -> C
     => サブクラスのみ Seriarizable
     *  ＊サブクラスがデシリアライズ
     *  ＊super()引数なしコンストラクタが呼び出されインスタンス化
     *
Ｘ （11） A -> B
    => OptionalDouble DoubleStream.average()
    *    double OptionalDouble.orElse(double)
    *      値がなくても orElse()の引数を表示
    *    double OptionalDouble.getAsDouble()
    *      値がないと例外 NoSuchElementException
    *
    * A: 0.0の回答理由。下記と混同。
    * Collector<T,?,Double> Collectors.avaraging()
    *   値がないと 0を返す
    *
    * Optionalは nullも可なのでデフォルト値がなくても行ける。
    * Collectorで nullになると困るのでデフォルト値 0があると覚えよう。

Ｘ （12） Ax -> C
      => ◆正規表現
      * 「^」: 行頭
      * 「.」: 任意の１文字
      * 「*」: 直前文字の０回以上の繰り返し
      *
      * Pattern Pattern.compile(String regex [,int flag])
      *   flag: Pattern型の列挙定数
      * Matcher Pattern.matcher(Object)
      *   Matcherオブジェクトを生成。
      * boolean Matcher.matches()
      *   パターンとのマッチングを行い、文字列全体でマッチするか
      * String Matcher.group()
      *   一致した文字列を取得

〇 （13） B
〇 （14） D
〇 （15） B?
    => boolean Matcher.find() 次のマッチがあるか
    *  〔問12 参照〕

〇 （16） D
    => Object ResourceBundle.getObject(String)
    *    引数は keyを表す文字列のみ、int値を渡すとコンパイルエラー。
    *
Ｘ （17） C -> B
    => ◆ PathMatcherクラス
    *  java.nio.file.FileSystem
    *  FileSystem FileSystems.getDefault()
    *  PathMatcher FileSystem.getPathMatcher(String "文字列:pattern")
    *    pattern:
    *      ＊glob: glob構文
    *      ＊regex: 正規表現
    *
    *  ◆ glob構文
    *  「?」: １文字
    *  「*」: ０文字以上の文字
    *  「**」: *と同じ。ディレクトリ構造をまたいだ指定が可能

〇 （18） E
〇 （19） C
〇 （20） C
Ｘ （21） B -> A
    => list.stream().forEach()を２回
    *  １つ目の処理と２つ目の処理は、別Streamなので関連性がない。
    *  フィールドに保存するか、
    *  collect(Collectors.toList())で listに代入するかなら
    *  処理結果が保存される。
    *  同じStreamのまま forEach()２回は不可。

〇 （22） B
〇 （23） B
〇 （24） D
    => printf()で書式の変数と引数の数/インデックスが違うと
    *  MissingFormatArgumentException 〔runtime〕

〇 （25） B
〇 （26） D
    => AutoCloseable/Closeableを実装していないオブジェクトで
    *  try-with-resourcesを利用するとコンパイルエラー。
    *  クローズ時 close()を呼び出すので、実装していないとコンパイラが検出。

〇 （27） D
〇 （28） A
    => D: 書き込みStreamオブジェクトは、書き込みの際、
    *  指定したファイルが存在しないと、自動的にファイルを生成して、書き込み。

〇 （29） C
〇 （30） B
Ｘ （31） A -> A, C
    => setDefault(Locale)
    *  setDefault(Locale.Category, Locale)

〇 （32） C
〇 （33） A
〇 （34） A
〇 （35） C
〇 （36） C
〇 （37） C
〇 （38） A, D, E
〇 （39） C
〇 （40） D
Ｘ （41） C, D? -> A, D
    => forEach(Employee::getId)での呼出
    *  ＊引数なしのインスタンスメソッド
    *  ＊引数１つの staticメソッド
    *  の定義で、メソッド参照による呼出が可能。
    *

〇 （42） A
Ｘ （43） A -> C
    => Files.copy()
    *  ＊ファイルが存在していない場合、コピー成功。
    *  ＊ファイルが存在して、StandardCopyOption.REPLACE_EXSITINGなら可。
    *  ＊"./se"などディレクトリのみの場合も存在していたら
    *    FileAlreadyExsitsException

〇 （44） B
〇 （45） D
〇 （46） B, C
    => ◆アノテーションの引数
    *  default値が設定してあるものは引数指定不要。
    *  T value()
    *    指定する属性が１つのみ
    *    属性名が value
    *  以上の２つの条件があれば、「value=」を省略可
    *
    *  値を指定する際は「id=」が必要
    *  複数指定する場合は、{ }でくくる。
    *
Ｘ （47） C -> A, C
    => A: Object.toString()は引数なし、
    *  ここでの抽象メソッドは toString(String)のオーバロードのため
    *  Override可能な抽象メソッド

〇 （48） A, D
〇 （49） C
〇 （50） C
Ｘ （51） C? -> B
    => Testに throw FooExceptionとあるため、
    *  throws new BarExceptionを受けるには継承関係が必要。
    *  Fooを main()の Exceptionで受けるには継承関係が必要。

〇 （52） F
〇 （53） D
Ｘ （54） Dx -> B
    => staticインナークラスにすることで、
    *  エンクロージングクラス内からは
    *    Inner inner = new Inner();
    *  でインスタンス生成が可能。
    *  外部クラスからの staticインナー呼出は
    *    Test.Inner in = new Test.Inner();
    *
    *  外部からの 非static内部クラスの呼び出しは
    *    Test.Inner in = new Test().new Inner();
    *  なら可。

〇 （55） B, C
〇 （56） B
    => List.replaceAll(UnaryOperator<E>)

〇 （57） A
Ｘ （58） A, C -> B, C
    => A: void Opitonal<T>.ifPreset(Consumer<T>)
    *  ifPresent()の引数は Consumerのため、戻り値のないラムダ式を渡す。
    *  B: map(Custom::getId)
    *  staticな メソッド参照、Custom.getId()は 非staticなので選択しなかった。
    *    引数なしのインスタンスメソッド
    *    引数１つのstaticメソッド
    *  なら メソッド参照可能
    *
Ｘ （59） B -> C 〔基本問題〕
    => land()は Flyerには定義されておらず、コンパイルエラー。

〇 （60） B, D
〇 （61） B
Ｘ （62） E -> A
    => boolean ResultSet.last() 最終行に移動
    *  boolean ResultSet.absolute(1) 先頭行
    *  boolean ResultSet.absolute(-1) 最終行
    *  boolean ResultSet.absolute(-2) 最終行の上の行
    *    absolute()はレコードのない行も指定可能だが、値を取り出そうとすると
    *    SQLException

Ｘ （63） B -> C
    => int Reader.read()
    *  １文字取得。戻り値 intのため、「A」でも「65」とユニコードの int
    *  読み取れるものがないときは -1
    *  (char) reader.read(); とキャストすると「A」と出力。

Ｘ （64） A, B? -> B, D
    => Streamのジェネリック型を指定してない raw型なので、<Object>として扱われ、
    *  int getPoint()を呼び出すとコンパイルエラー。
    *  A: Listに <Customer> を追加しているが、Streamも raw型なので
    *  コンパイルエラーは解消しない。
    *  C: filter((Customer c) -> )のラムダ式だが、raw型で変数型が不明なので
    *  コンパイルエラー。
    *  D: filter(c -> (Customer.c).getPoint() > 300)
    *  戻り値側の cをキャストして getPoint()を呼び出すと成功する。

Ｘ （65） D -> B
    => print(Object)
    *  その インスタンスObjectの toString()を呼び出す。
    *  toString()がない場合 hash値
    *  toString(String)など、引数が違うものしかない場合も hash値

〇 （66） B
    => writeObject() シリアライズ時
    => default? Serializable?.readObject(ObjectInputSteam)
    *  を実装することをデシリアライズ時の処理を独自定義できる。

〇 （67） A, B
〇 （68） B, C
    => コンポジション: 集約の一種でクラス間における「全体と部分」の関係
    *    クラスのライフサイクルが同一である関係をいう。
    *

〇 （69） C
Ｘ （70） A -> B
    => Path path = Paths.get(
    *      "C:/gold/./cert/../exam/./../test")
    *  C
    *  ┗ gold
    *      ┗ cert
    *      ┗ exam
    *      ┗ test
    *  Path.nomalize() -> "C:/gold/test"

〇 （71） C
〇 （72） C
〇 （73） B, E
Ｘ （74） A -> C
    => public classは ソースファイル名と同じ
    *  このコードには publicが 2つあるのでコンパイルエラー。
    *  欄外に ソースファイル名として「CreateTest.java」とあるので
    *  ここだけに public classとする。
    *
    *  って、そこかよ・・

〇 （75） A
Ｘ （76） E? -> D
    => TreeSet.last()最後の要素を取得
    *  TreeSet.pollFirst() 最初の要素を取得し削除。null時は null

Ｘ （77） A -> B
    => 引数なし、戻り値なしを選択
    *  A: () -> System.out::println;でもいいはずだが、
    *  表示されるものは何もない。

〇 （78） B
Ｘ （79） D -> A
    => ◆Exceptionクラスのコンストラクタ
    *  Exception()
    *  Exception(String message)
    *  Exception(Throwable cause)
    *  Exception(String message, Throwable cause)
    *  Exception(String message, Throwable cause,
    *            boolean enableSuppression,
    *            boolean writableStackTrace)

Ｘ （80） C -> D
    => Collection Collection.of(T...)
    *  of()により、不変コレクションが生成される。
    *  変更を加えると、 UnsupportedOperationException 〔runtime〕
    *  C: コンパイルエラーではない。

開始時刻 10:05
終了時刻 13:07
所要時間 182 分
正答率 68.75 ％ ( 〇55問 / 全80問 )
*/

