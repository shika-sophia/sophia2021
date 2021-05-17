/**
 * @title javaGold / se08Black / Examin01BK.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  総合問題１
 * @author shika
 * @date 2021-05-17
 */
/* Appendix 2021-05-17
 * @costTime 10:02 - 12:38 ( 156 分)
 * @correctRate 正答率 75.29 ％ ( 〇64問 / 全85問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Examin01BK {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-17 ======
 総合問題１
〇 （1） D
Ｘ （2） E -> B
    => 「x -> y -> x + y」
    *  引数 x -> 戻り値 y -> x + y
    *  問題文 IntFunction<Integer>は
    *  戻り値を Integerを想定しているためコンパイルエラー。
    *
    *  解答は Function<T, R>か IntFunction<R>の
    *  Rがラムダ式の戻り値となっているものを選ぶ。
    *
    *  B: IntFunction<Integer, UnaryOperator<Integer>>
    *       T IntFunction.apply(Integer)
    *
    *  applyAsInt()は戻り値を Integerで返すインターフェイスのみ
    *    LongToIntFunction
    *    DoubleToIntFunction
    *    ToIntFunction
    *    ToIntBiFunction
    *    IntUnaaryOperator
    *    IntBinaryOperator
〇 （3） E
〇 （4） D
Ｘ （5） A -> D
    => assertの条件式が falseになるため、AssertionError

〇 （6） D
    => Stream Arrays.stream(T[])

Ｘ （7） D -> B
    => 引数に 「Child::new」のコンストラクタ参照を受けられるのは
    *  Supplier<T>, Supplier<? extends T>のみ
    *
    *  Supplier<Parent> parentに Child::newが受け取れるか
    *  Supplier<Parent> parent = () -> new Child();
    *  Parent parent = new Child();と同じ意味となり、ＯＫ。
    *
    *  doIt()メソッドは Supplierに定義されているわけではないので、
    *  Parent p = parent.get();で Parentオブジェクトを読んで
    *  p.doIt()をする。
    *
Ｘ （8） C? -> E
    => RecursiveActionクラス / 値を返さない処理を継承している
    *    T ForkJoinPool.invoke(RecuriveTask<?>);
    *    ForkJoinPool.fork(): 処理を分岐
    *    compute()を呼出、分岐した残り部分を処理。
    *
    * 最大処理数は THERSHOLD_SIZE = 3
    * [1 + 2 + 3][4 + 5]が行われ、 6 9
    * ただし処理順は保証しない。
Ｘ （9） D -> E
    => flatMapToInt(Function<T, ? extends IntStream>)
    *  の戻り値は IntStreamになるためコンパイルエラー

〇 （10） A
    => Stream<String> Files.lines(Path)
    *  Stream<String> BufferedReader.lines()
    *  Stream<Path> Files.list(Path)
    *  List<String> Files.readAllLines()
    *
Ｘ （11） B -> E
    => 回答理由 B:
    *  File[]で絶対パスを入れて再帰するなら、Appのところで再び再帰し、
    *  処理は進まないのでは？
    *  この解答の処理はテンプレートになっているようなので、
    *  再帰的にサブディレクトリをたどる処理はこのようにするのかも、要検証。後日。。
    *
    => 解答 E: 自己定義メソッド deleteForTemporyFiles(String dir)
    *    引数Pathのディレクトリを対象に
    *    File[] File.listFiles(Path)を利用、
    *    ディレクトリ内の全てのファイル / ディレクトリを配列 File[]で取得し、
    *    ループ処理を行う。
    *
    *    String dirがディレクトリなら、サブディレクトリをたどるため、
    *    自身の絶対パスを入れて再帰呼出。
    *    ファイルの場合は、拡張子「.tmp」のものを削除
    *
    *    Appディレクトリのサブディレクトリまで回って、全ての「.tmp」ファイルを削除
    *
〇 （12） B
〇 （13） A
〇 （14） C -> D -> C
    => comparingByKey()をしているので keyを自然順序でソートしていなければならない。
    *  なので Cを正解とする。

〇 （15） C
〇 （16） D
Ｘ （17） E -> C
    => Pathオブジェクトはファイルパスを表すオブジェクトであり、
    *  実際にそのPathに対応するファイル/ディレクトリが存在するかは
    *  オブジェクト生成時には関係がない。
    *  存在しなくても例外は出ない。
    *
    *  getNameCount(), getName(), getFileName()はそのまま処理される。
    *

Ｘ （18） A -> C
    => ◆JDBC 3.0
    *  Class.forName(String path):
    *    クラスローダーを使って JDBCドライバを読み込む必要がある
    *  JDBC 4.0以降は不要。
    *  A: /META-INF/services/に Driverの「.jar」を配置するのは必要だと思うけど

〇 （19） C
〇 （20） D
〇 （21） D
    => Files.copy()
    *  ファイルが存在し StandardCopyOption.REPLACE_EXISTINGでなければ
    *    FileAlreadyExistingException
    *  ディレクトリ名でコピーして、ディレクトリが存在しても同様。
    *
    *  コピー元のファイル / ディレクトリが存在しない場合
    *    NoSuchFileException

Ｘ （22） A -> D
    => getDept()は Employeeに定義されていないためコンパイルエラー。
    *  main()以外の他クラスあまり見ていなかった。呼出てるんだから、あるんだろうと..
    *
〇 （23） D
    => コンパイルエラーは、interfaceを newしているからではないのか。
    *  そういえば、Runnableの匿名クラスで new Runnable() { }を何度か見たことがあるような。
    *  Predicate<String>に、型の異なる匿名クラスを代入していてコンパイルエラー。

    *  StringFilter implements Predicate<String>なら、
    *  匿名クラス定義時の newはＯＫ。と書いてある。

〇 （24） B
〇 （25） C
〇 （26） D
Ｘ （27） A -> D
    => TreeSetの要素にする Carクラスが Comparableを実装しておらず
    *  int Compable.compareTo(T)を定義していないため、
    *  実行時に ClassCastException
    *
    *  それか TreeSetのコンストラクタで Comaratorを渡していればＯＫ。

〇 （28） D
    => SQLExceptionにした回答理由:
    *  DBのテーブルに列が２つしかないのに ３つの要素を SQL文に記述しているから。
    *
    => 解答では別の説明をしている。
    *  try-with-resourcesを抜けた Connectionは close()されるので、
    *  close()した connを呼び出すと SQLExceotion。
    *
    *  問題文の不備、仕掛けは どちらか一方にすべき。

Ｘ （29） D -> B
    => Reader.ready(): 入力ストリームを読み取れる場合のみ trueを返す。
    *  これ、あるんだ。ないと思ってコンパイルエラーと回答。

〇 （30） C
〇 （31） B
〇 （32） D
Ｘ （33） C -> B
    => void Collection.sort(Collection<T>, Comparator<T>)
    *  sort()の第２引数に Comparatorを渡すことができ、
    *  new CD()は implements Comparator<T>をしているので、コンパイルエラーにはならず。

〇 （34） B
〇 （35） C
    => equals()で両者の型が異なるので false

〇 （36） A
Ｘ （37） D -> A
    => D: コンパイルエラーの回答理由
    *  int countを count++していたため、実質 final規定違反かと。
    *  ラムダの外、メソッド内のローカル変数なら、参照する際 実質 finalを求められる。
    *  ラムダ内で定義した int countに対しては変更してもいいのか。
    *
    *  匿名クラス内でいつも初期化されるので、ＯＫと思われ。
    *  count++も 0に初期化、値を出力後にインクリメント。
    *  boolen result = n > 10;より n=12がくるまで false、
    *  filter(false)で要素は消され、
    *  「0:0:0:12」

〇 （38） D
Ｘ （39） A? -> C
    => A: コンストラクタ参照でコンストラクタの引数を渡すことはできません。
    *  B: コンストラクタ参照の代入先は関数型インターフェイス
    *  D: インターフェイス Flyableはインスタンス不可。 コンストラクタも持たない。
    *        Flyable::newはできない。
    *  ◆Flyableインターフェイスを匿名クラスで実装
    *  Flyable f = new Flyable() {
    *      public Airplane getAirplane(String name){
    *          return new Airplane();
    *      }
    *  };
    *  Airplane a = f.getAirplane("Boeing");
    *
    *  ◆getAirplane()の実装だけをラムダ式で記述
    *  Flyable f = name -> new Airplne(name);
    *  受け取った引数をそのままコンストラクタに渡しているため、
    *  コンストラクタ参照を利用できる。
    *
    *  ◆メソッド参照
    *  Flyable f = Airplne::new;
    *
〇 （40） A
〇 （41） D
    => Optional<T> Stream.max(Comparator<T>)/min(Comparator<T>)
    *  Comparator<R> Comparator.comparing(Function<T,R>)
    *
    *  Integer.min(int, int)は引数２つ、map(Function<T,R>)は引数１つのため、
    *  メソッド参照では渡せない。
    *
Ｘ （42） C, E -> A, E
    => 〇A: ローカライズで再コンパイルなしに、言語と地域の変更が可能
    *  Ｘ B: 外部リソースとして記述できる
    *  Ｘ C: 言語と地域に特化したリソースだけが読み込まれ、
    *       専用のプログラムが作成されるわけではない。
    *  Ｘ D: ResourceBundleには、データと通貨と情報はない。
    *  〇E: 言語は小文字、地域は大文字
〇 （43） B
〇 （44） A
〇 （45） B, D
〇 （46） D
    => ResultSet.executeQuery()を２回実行しているため、
    *  最初の ResultSetは close()する。
Ｘ （47） D -> C
    => List<E>.replaceAll(UnaryOprator<E>)
    *  Listの Eと UnaryOparatorの Eは同じ型でないとコンパイルエラー。

〇 （48） B
〇 （49） E
〇 （50） C
    => CyclicBarrier(2)にすると、その数のスレッドが待機するまで、
    *  トリップ(=通過)できない。シングルスレッドなら 1を指定。

〇 （51） B, E
    => IntFunctionは、引数も戻り値も intを扱うFunctionのプリミティブ型
    *  <String>を扱うことはない。
    => Integer ToIntFunction<String>.applyAsInt(String)は
    *  引数 String, 戻り値 Integer
    *    = Integer Function<String,Integer>と同じ
〇 （52） A
〇 （53） C
〇 （54） D, E
Ｘ （55） D -> B
    => D: line2を EmptyInkExceptionにしても Overrideの例外としては正解だが、
    *  main() throws EmptyInkException, Exceptionと並記されているので、
    *  B: 両方の例外を記述するには、superを Exception, subで EmptyInkException

〇 （56） C
〇 （57） A
〇 （58） B, C, D
    => DriverManager, SQLExceptionはインターフェイスではなく、クラス。
    *  JDBCドライバが提供する機能ではなく、JDBC APIの機能？

〇 （59） C
    => Integer + Double の演算はオートアンボクシングされ計算可。
    *  BiFunction<Intrger,Double,Integer>となっており戻り値は Integer
    *  int + doubleの計算は double -> Doubleとなりコンパイルエラー。
    *
    *  計算式を (Integer)でキャストするか、
    *  BiFunction<Intrger,Double,Double>にすればＯＫ。

〇 （60） C
〇 （61） D
    => UnaryOperator<Integer>で List<Double>の要素を扱うとコンパイルエラー。
    *  UnaryOperator<Double>ならＯＫ。

〇 （62） C
〇 （63） D
〇 （64） A
〇 （65） C
    => try-with-resourcesの try{ }を抜けた時点で、
    *  BufferedReaderオブジェクトは close()
    *  reader.ready()を呼出た時点でコンパイルエラー。

〇 （66） D
〇 （67） B
〇 （68） C
〇 （69） A
〇 （70） B
〇 （71） C
    => ジェネリッククラスの宣言に <?>は不可。
    *  上限境界の指定はインターフェイスも extends クラスが先。「&」で並記。

Ｘ （72） B -> A
    => () -> new Foo()となるため、Supplier<T>
    *  Supplier.get()なので、B

〇 （73） C
    => enumのコンストラクタは暗黙的に private
    *  他クラスからの呼出不可。
    *
〇 （74） A
〇 （75） B
Ｘ （76） B, C -> B, D
    => Ｘ A: java.io.Closeableは AutoCloseableのサブインターフェイス、
    *           implementsが必要。
    => C: public void close()の Overrideで protectedにするのは不可。

Ｘ （77） A -> C
    => sqlを引数に取る createStatement()は定義されていないため、
    *  コンパイルエラー。

〇 （78） A
    => 自己定義 Readable<Integer> は
    *  public abstract void skip(Integer)を持つ関数型インターフェイス
    *  defaultメソッドがあっても関数型
    *  C: Readable と<>指定がないで <Object>と見なされ、
    *     引数に (Integer i)を入れているのでコンパイルエラー。
    *
    *  クラス宣言で使われる Readable<Integer>の Integerは
    *  java.lang.Integerではない。<T>などと同じ一意に識別可能な識別子。
    *  <T>がいろいろな型となるように、<Integer>も違う型となる。

〇 （79） B
    => ResourceBundleは xml形式に標準対応していない。
    => Propertiesクラスが .txtと .xml対応。

〇 （80） A
Ｘ （81） A -> D
    => assert false : "N/A";
    *  AssertionErrorが出て、N/Aと表示

〇 （82） A
〇 （83） B
〇 （84） C
〇 （85） B, C

開始時刻 10:02
終了時刻 12:38
所要時間 156 分
正答率 75.29 ％ ( 〇64問 / 全85問 )
*/

