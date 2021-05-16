/**
 * @title javaGold / se11White / Examin01WH.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content  模擬試験１
 * @author shika
 * @date 2021-05-16
 */
/* Appendix 2021-05-16
 * @costTime 09:17 - 11:42 ( 144 分)
 * @correctRate 正答率 81.25 ％ ( 〇65問 / 全80問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Examin01WH {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-16 ======
 模擬試験１
〇 （1） B
〇 （2） A, E
Ｘ （3） C -> E
    => List.copy()で生成された Listは immutable 不変リスト。
    *  add()により、UnsupporetedOprerationException

〇 （4） B
Ｘ （5） C
    => Path Path.getName(int)
    *  index 0でルートの次の Pathオブジェクトを返す。
    *

〇 （6） C
Ｘ （7） E -> F
    => Connectionオブジェクトの生成が行われておらず、コンパイルエラー。
    *  Connection.createStatement()は不可。
    *
    *  Connection conn = DriverManager.getConnection(url, "user", "pass");
    *  Statement st = conn.createStatement();
    *  ResultSet rs = st.executeQuery(sql);
    *
    *  Class<T> Class.forName(String);
    *  クラスローダーの pathが "/META-INF/service/Driver.jar"でないことは
    *  問題にしていない様子。

〇 （8） C
    => new Random().nextDouble()はインスタンスメソッドのため、
    *  static参照不可。newしてから利用。
    *
〇 （9） A
    => Ｘ Locale() 引数なしのコンストラクタは定義されていない。

〇 （10） B
    => Thread.run()を main()で run()すると、
    *  メインスレッドによる通常のメソッド呼出。
    *
    *  Thread.start()を２度呼び出すと、
    *    IllegalThreadStateException〔runtime〕

〇 （11） A
    => B: 引数なしのコンストラクタはデフォルトコンストラクタが自動生成。
    *  引数ありのコンストラクタが既にある場合は必要。

〇 （12） B, C
    => 両方のメソッドで警告が出る
    *  func(): ジェネリックを利用した可変長引数
    *    @SafeVarargs, @SuppressWarnings("unchecked")
    *  main(): 型引数を定義せずにコレクションを利用
    *    @SuppressWarnings("unchecked")

〇 （13） B
〇 （14） B
    => Comparatorの問というより、ジェネリックのインスタンスの問題
    *  A: <>を左項の変数型宣言不可。
    *  C: <?>をインスタンス時不可。左右とも。
    *  D: var で <>はコンパイルＯＫ。
    *      Comparator<Object>となり、メソッドの引数 Integerと矛盾。

〇 （15） A
    => 〇A: Stream.of(l1,l2).flatMap(list -> list.stream())
    *  Ｘ B: List.doubleStream()は存在しない。
    *  Ｘ C: Stream.flatMap(
    *         Function<? super T,
    *                  ? extends Stream<? extends R>>)
    *  Streamの型を指定する必要がある。
    *
    *  Ｘ D: DoubleStream flatMapToDouble(
    *         Function<? super T, ? extends DoubleStream>)
    *  list -> list.stream() となっており、Stream<Double>をつくるラムダ式。
    *  コンパイルエラー。

〇 （16） E
〇 （17） D
Ｘ （18） A -> D
    => Test<T>の型引数を指定せずにインスタンス -> Test<Object>となる。
    *  setValue(999); int 999 -> Integer -> Objectは superよりＯＫ。
    *  Object + Integerの演算でコンパイルエラー。

〇 （19） A
〇 （20） D
〇 （21） B
    => Map<Boolean, List<Customer>>
    *    Collectors.patitioningBy(Predicate<T>)
    *  Map.get(Boolen key)で List<Customer>を取得。
    *  collect()は終端処理のため、再度 stream()でストリーム化
    *  map()で Customer.getName()から名前を取得。
    *  collect()で HashSetを newして格納
    *    -> Set<Customer>の変数に代入可。
    *
    *  Ｘ A: get(false)で条件違う
    *  Ｘ C: List.map()となっており、stream()が抜けコンパイルエラー。
    *  Ｘ D: Map.stream()でコンパイルエラー。
    *    Map.entrySet().stream()
    *    Map.keySet().stream()
    *    Map.get(Boolean).streamが必要。

Ｘ （22） A -> B private
    => 実装クラスでオーバーライド不可 static, private
    => 他クラスから参照不可 private
    *  Ｘ private defaultはコンパイルエラー。

〇 （23） D
Ｘ （24） B -> E
    => ConcurrentHashMapに nullを入れると NullPointerException

〇 （25） B
    => Stream<String> Files.lines(Path)
    => List<String> Files.readAllLines(Path)
〇 （26） A
〇 （27） D
Ｘ （28） A -> B
    => Consumer<T> 引数１つ、戻り値なし。
    *    Ｘ A: String argsは main()で定義済。ラムダ式はＯＫ。
    *    〇 B: System.out::println;
    *    Ｘ C: return不可
    *    Ｘ D: (var s) と()で囲む。varはＯＫ。

〇 （29） E
〇 （30） B, D
〇 （31） B, C
〇 （32） C
    => Objectクラスのメソッドは abstractでも、Overrideすべきメソッドにならない。
    => Objectクラスのメソッドは defaultにするとコンパイルエラー。

〇 （33） B
〇 （34） B
〇 （35） B
    => int AtomicInteger.getAndIncrement()
    => int AtomicInteger.addAndGet(int): 引数に増分を指定

〇 （36） C
〇 （37） B
    => A instanceof B: Aは Bのオブジェクトの領域に含まれているか
    MusicCD extends CDより、
    MusicCD instanceof CD / MusicCDは CDオブジェクトの領域に含まれず。false.

〇 （38） D
    => 部分的なソートの完了する 18行目で assertチェック。

〇 （39） F
    => StringBuilderは 「==」も、 equals()も 参照同一性の比較。

〇 （40） B
〇 （41） B
〇 （42） C
Ｘ （43） B -> D
    => Iterator<Path> Path.itrator()
    *  ルート C:は除外、最初のディレクトリ要素から順に取得。

〇 （44） E
〇 （45） B
    => throws Exceptionでも
    *  e.getClass()は、元の原因となった例外がでる。

〇 （46） B
〇 （47） A, D
〇 （48） C
〇 （49） B
    => java.security.AllPermission
    *  全ての権限を許可している。
    *  動作試験時に複数のセキュリティ許可を管理する手間を省くために用意された。
    *
    *  Ｘ A: 原則として最小限の許可内容でツールやアプリケーションを実行できることが妥当。
    *  〇B: 必要な許可だけが与えられるよう報告するのは妥当。
    *  Ｘ C: アプリへの適切な許可制限は必要
    *  Ｘ D: 付与している許可を削除すると、アプリ内の機能が動作しなくなる可能性もある。

〇 （50） A, D
    => Thread.setPriority(int) MAX_PRIORITYなど
    => Thread.yield()は自分以外のスレッドに優先権を渡すメソッド。
    *  そのため、自スレッドの処理中や、synchronized内で使っても意味がない。

〇 （51） C
    => スレッドプールが２つなので、最初の２つがほぼ同時に処理し、
    *  あとからCCCを処理。

〇 （52） C
    => PreparedStatementの「?」
    *  execute()前に全ての値が入っている必要がある。 SQLException
    *  「?」の値を変えて、２度 execute()することも可能。
    *  ２度目以降に値をsetXxxx()していない場合は前回の値をそのまま利用。
    *
    *  ただし、ResultSetから値を取得する or
    *  executeQuery()後 executeUpdate()を実行すると、ResultSetが close()
    *  その後にResultSetから値を取得しようとすると、SQLException
    *
〇 （53） B
〇 （54） A, C, D
〇 （55） A, D
    => replaceAll(UnaryOperator<T>)
    *  UnaryOperatorは 引数と戻り値が同じ型の Function
〇 （56） A
    => 〇A: (var i) はＯＫ。
    *  Ｘ B: ジェネリックの型引数に var不可。
    *  Ｘ C: returnを記述するなら { }で囲む。
    *  Ｘ D: { }なら returnが必要。

〇 （57） A, C
    => Integer.valueOf(null); コンパイルは通るが
    *  実行すると、引数が nullのため、 NullPointerException
    => int -> Long, int -> Double
    *  ラッパークラスに暗黙の型変換は行われず、
    *  long -> Long, double -> Double オートボクシングなら可。

〇 （58） A
〇 （59） C, D
〇 （60） B
    => System.in 標準入力(キーボード) バイナリーストリーム

Ｘ （61） A -> C
    => Paths.move(Path p1, Path p2, StandardCopyOption...)
    *  p1が p2にリネームされる。

Ｘ （62） A -> B
    => Exam.getCert()より、static呼出
    => Exam.values()[3]は配列の[3]で該当する要素なし

〇 （63） B
〇 （64） C
Ｘ （65） B
    => var list = new ArrayList<>();はコンパイルＯＫ。
    *  <Object>となる。
    *  set(3, "exam");が原因で実行時に
    *      IndexOutOfBoundsException

Ｘ （66） A -> B
    => SingleThreadExecutor()より、呼び出されるタスクは１つずつ。

〇 （67） B, C
    => ◆機密情報
    *    ＊アクセス制限をする
    *    ＊入力値のチェック
    *    ＊なるべく保存せず、確実に破棄。

〇 （68） A, E
〇 （69） A
〇 （70） B
〇 （71） D
    => Files.readAttributes(Path,
    *      Class<A extends BasicFileAttributes>,
    *      LinkOption...)
    *  引数 Pathのみでコンパイルエラー。
    *
〇 （72） B
    => Comparator
    *    Comparator<R> comararing(Function<T,R>)
    *    Comparator<R> thenComaraing(同上)
    *    Comparator<T> reversed(): 逆順

Ｘ （73） A -> D
    => RirectoryStream<Path>
    *      Files.newDirectoryStream(Path, String pattern)
    *  String pattern: 検索パターンは１つのみ、"*.{java,txt}"と指定する。
    *
Ｘ （74） E -> B
    => E: コンパイルエラーの回答理由:
    *       implements Comparatorとなっていたため、Comparableが正しいと思ったが、
    *       TreeSet(Comparator)とコンストラクタに入れるためのクラスなので、
    *       Comparatorで良い。
    => TreeSetは idの逆順でソート。要素の重複追加は無視される。

〇 （75） A, D
    => Collector<T, ?, Double>
    *    collect(Collectors.averagingDouble(ToDoubleFunction))
    *  B: IntStream Stream.mapToInt()
    *     OptionalDouble IntStream.avarage()
    *  C: Streamに直で avaragingDouble()は不可。
    *  D: double OptionalDouble.getAsDouble()
    *  E: Streamに直で avarge()は不可。 IntStream.average(), DobleSteram.average()
Ｘ （76） B, D, E -> A, B, E
    => AtomicInteger extends Number

〇 （77） D
〇 （78） D
〇 （79） B
〇 （80） A, B

開始時刻 09:17
終了時刻 11:42
所要時間 144 分
正答率 81.25 ％ ( 〇65問 / 全80問 )
*/

