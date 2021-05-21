/**
 * @title javaGold / se08Black / Examin02BK.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  Black 総合問題２
 * @author shika
 * @date 2021-05-21
 */
/* Appendix 2021-05-21
 * @costTime 10:53 - 13:35 ( 162 分)
 * @correctRate 正答率 76.47 ％ ( 〇65問 / 全85問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Examin02BK {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-21 ======
 Black 総合問題２
〇 （1） C
〇 （2） E
〇 （3） A, E
〇 （4） B
〇 （5） A
    => LocalDateは不変オブジェクトのため代入が必要
    *  System.out.printnln(ld.withYear(2021))なら可。

Ｘ （6） B, D -> D, E
    => B: super()はコンパイラが自動で挿入する。
    *  D: super(int)は記述しないといけない
    *  E: Y.doIt()は publicなので、Z.doIt()も publicにする。

〇 （7） D
〇 （8） A
    => Ｘ E: Instantクラスは 一時点を表す。new Instant()は未定義。

〇 （9） C
〇 （10） B
Ｘ （11） D -> B
    => enum E implements X は可。/ extendsは不可。
    *  コンパイルによって Enumクラスサブクラスになるので
    *  enum定数 E.A instanceof E
    *  enum定数 E.B instanceof X
    *  enum定数 instanceof Enumは 全て true

〇 （12） C
〇 （13） A, C
Ｘ （14） A -> C
    => A: 回答理由 interfaceに staticがなかったので 非static参照かと
    *  インナー interface の staticは暗黙付与
    => <? super Y> より X, Yのみ可、Z不可。
    *  A<T> を new A()は警告が出るもコンパイル可。

〇 （15） B
〇 （16） B?
    => Function<String,String> doIt(Function<Integer,String>)
    *  引数に Function, 戻り値も Function
    *  関数型インターフェイスは ラムダ式でのメソッド定義が可能。
    *
    *  Foo foo = (Function<Integer,String> f) -> ラムダ式
    *  Foo foo = f -> ラムダ式
    *  Foo foo = f -> (String s) -> String型戻り値
    *  Foo foo = f -> s -> "#" + f.apply(s.length());
    *  f.apply()によって Function<Integer,String> f を実行。
    *  System.out.println(foo.doIt(x -> x + "$").apply("ABC"));
    *  doIt()には Intrger -> Stringのラムダ式を渡す
    *  doIt()で返る Function<String,String> は
    *  上式 s -> "#" + f.apply(s.length()) で定義され、
    *  そこに apply("ABC")で実行。
    *
    *  ？ちとこれ、ようわからん。ギブアップ。

〇 （17） C?
    => ZonedDateTime zdt = ZonedDateTime.now(ZoneOffset.UTC);
    *  Date dt = Date.from(zdt.toInstance())
    *  一旦 Instantクラスでエポック秒を取得してから
    *  Date.from(Instant)に渡して変換。

〇 （18） C
〇 （19） C
〇 （20） C
〇 （21） D?
    => B: DoubleFunction<Integer>は 引数 double, 戻り値 int -> Integer
    *     題意は int -> doubleで不可。
    *  C: DoubleFunction<Double>で上記の問題はクリア
    *     実行メソッド applyAsDouble()となっており、不可。正しくは apply()
    *
Ｘ （22） B, E, F -> B, D, E (基本問題)
    => Month LocalDate.getMonth()
    *  戻り値は Month列挙型
    *  曜日は
    *  DayOfWeek LocalDate.getDayOfWeek()
    *  戻り値は DayOfWeek列挙型

Ｘ （23） A -> C
    => A:コンパイルエラーの回答理由: Fooは Barを implementsしてないのに
    *  Fooオブジェクトを Bar型の変数に入れているから
    *  解答の説明では触れていないので 誤植ということで
    *  implementsしてあるものとして、進めよう。
    *
    *  あっ、 Bar bar = Foo::new;は
    *  関数型インターフェイスのメソッド定義であって、
    *  ここでインスタンスしているわけではない。
    *  上記の implementsは不要で、継承関係になくても記述できる。
    *  実際にインスタンス実行しているのは、
    *  bar.doIt(10);の時点。
    *
    => メソッド参照やコンストラクタ参照では
    *  SAMで定義した抽象メソッドの引数に一致したメソッドが
    *  自動的に選択される。

〇 （24） A
〇 （25） C, E
〇 （26） B
Ｘ （27） C -> B
    => ArrayListは nullを許容するため list.add(null)はＯＫ。
    *  list.add(map);は
    *  Map内のジェネリック型が異なるMapを代入しているため、
    *  コンパイルエラー

〇 （28） B, C, D
Ｘ （29） B -> C
    => boolean Map.remove(K, V) K,Vが一致する要素があった場合、削除。
    *  boolean? Map.removeAll(BiFunction<K,V,V>)

Ｘ （30） C -> A
    => ForkJoinTaskのcompute()を起動させるのは
    *    void ForkJoinPool.execute(ForkJoinTask)
    *    T ForkJoinPool.invove(ForkJoinTask)
    *    ForkJoinTask<T> ForkJoinPool.submit(ForkJoinTask)
    *  このうち、渡した非同期処理の終了を待つのは invoke()のみ

〇 （31） C
〇 （32） A
    => Comparator<T> Map.Entry.comparingByKey()
    *  Comparator<T> Map.Entry.comparingByValue()
    *  Map.Entryの valueでソート。
    *  引数なしなら、大文字・小文字を区別。
    *  sort()のデフォルトで大文字が先。
    *  引数に String.CASE_INSENSITIVE_ORDERを入れると
    *  大文字・小文字を区別しない。
    *  valueが同値なら、keyでソート

〇 （33） C
〇 （34） C
〇 （35） B
Ｘ （36） D -> A
    => Predicate.isEqual(T)
    *  ラムダ式の s -> s.equals(T)を置換できる。
    *  C: equals()は staticではない。
    *  B,D: メソッド参照の構文仕様上の誤り(？よくわからず)

Ｘ （37） B -> A
    => java.time.temporal.ChronoUnit列挙定数
    *  ChronoUnit.YEARは１年の期間単位を表す定数。
    *
    *  Duration ChronoUnit.YEAR.getDuration()で
    *    ChronoUnitが持つ期間の Durationオブジェクトを取得。
    *
    *  Duration Duration.multipliedBy(T)
    *    元の Durationに引数を乗算したDurationを返す
    *
〇 （38） A
    => ◆ java.time.MonthDayクラス
    *  MonthDay MonthDay.of(TemporalUnit? month, TemporalUnit? day)
    *  MonthDay MonthDay.from(Tempral?)
    *    引数 LocalDate.now()などから MonthDayオブジェクトに変換。

〇 （39） A
〇 （40） C
〇 （41） A, C
〇 （42） C
〇 （43） B, D
Ｘ （44） B, D -> A, B
    => A: Work-Stealingアルゴリズムは、
    *    他の ExecutorServiceにはない。
    *  B: デフォルトの並行性レベルは
    *    システム上で利用可能なプロセッサ数と同じ。
    *  D: 分割統治アルゴリズム Divide and Conquer Algorithm
    *    大きなタスクを小さく分割して、最終結果を統合する。
    *    タスク間の協調や調整には向いていない。

〇 （45） C
〇 （46） C
    => getBundle(String baseName)だけ指定すると、
    *  default / setDefault()の 言語_国コードが一致するものを探す。

Ｘ （47） B -> D
    => itrator()で Iterator<T>を取得後に
    *  もとのコレクションを変更すると
    *  ConcurrentModificationException
    *
    *  通常のコレクションではなく、
    *  並行処理ユーティリティに含まれるクラス
    *  ConcurrentHashMap, ConcurrentSkipListSet
    *  CopyOnWriteArraySetなどは
    *  上記の例外は起きず。

    *
〇 （48） E
〇 （49） C
    => ラムダ式を囲むブロックのローカル変数をラムダ内で利用するなら
    *  実質 finalである必要がある。
    *  ラムダ式後にそのローカル変数を変更してもコンパイルエラー。

〇 （50） B
    => Function.identity()
    *  ラムダ式で i -> iのように引数と同じ戻り値を返すものに置換可。

〇 （51） C
〇 （52） A
    => super <- subインターフェイス
    *  Function<T,R> <- UnaryOparator<T>
    *  BiFunction<T,U,R> <- BinaryOparator<T>
    *  Ｘ  Functionと BiFunctionに継承関係はない。

〇 （53） D
Ｘ （54） A -> D
    => ◆ AtomicInteger
    *  int getAndAccumulate(int 更新値x, IntBinaryOperator)
    *  int accumulateAndget(int 更新値x, IntBinaryOperator)
    *  IntBinaryOperator.applyAsInt(int 現在値, int 更新値x)

Ｘ （55） B -> A
    => boolean Stream.anyMatch(Prericate<T>)
    *  boolean IntStream.anyMatch(IntPredicate)

Ｘ （56） B -> D
    => このコードでも
    *  for(int i = 0; i < 3; i++) {
    *      new Inc().start();
    *      new Dec().start();
    *  }
    *  全部で６つの個別のスレッドが生成される。
    *  Atomicな演算で処理が待たされ、ロックと解放の処理をしている。
    *  実行順序は保証されていないため、毎回違う結果となる。

〇 （57） D
〇 （58） A, B
    => 列挙定数を print()に渡すと暗黙的に toString()が呼ばれ
    *  値が表示される。

〇 （59） C
    => List<?>
    *  <?>は <? extends Object>で、コンパイル時に <Object>に変換。
    *  List<?>に List<Integer>の空の値を代入。
    *  Intger i = list2.get(0);としており、
    *  ObjectのListから 取り出した値を Integerの変数に代入。
    *  ここでコンパイルエラー。
    *
    *  (Intger)でキャストするか、Objectの変数にすれば
    *  コンパイルは通るが、
    *  空のListに、list2.get(0)で
    *  IndexOutOfBoundsException

Ｘ （60） A -> C
    => void BufferedReader.mark(int)
    *  引数intで マーク後の読み取り文字数を入れないと
    *  コンパイルエラー。


〇 （61） C
〇 （62） A
Ｘ （63） C -> D
    => createStatment()は引数１つのものがなく、コンパイルエラー。
    *  createStatment(ResultSet.TYPE_SCROLL_INSENTIVE,
    *                 ResultSet.CONCUR_READ_ONLY)
    *  と引数２つで指定する。

〇 （64） B
〇 （65） A
〇 （66） C
〇 （67） C
    => Collector<T> thenComparing()をしても部分ソートにはならず
    *  最初のソートで firstNameがソートされ、
    *  次に lastNameでソートし、この時点で、
    *  firstName昇順、lastName昇順になっているので、
    *  reversed()で、逆順・逆順とす。

〇 （68） A
〇 （69） D
Ｘ （70） A -> C
    =>  groupingBy(word -> word, Collectors.counting())
    *  groupingBy()で出現回数を値としてグループ化
    *  comparingByValue()で値によるソートをしており
    *  {Blue=1, Green=2, Red=3}
    *  その keyのみ表示。

〇 （71） C
Ｘ （72） C -> B
    => void Optional.ifPresent(Comsumer)
    *  voidのため、これに続けて .orElse()などを記述不可。
    *  コンパイルエラー。

〇 （73） A
    => Stream要素の""空文字も要素として残っている

〇 （74） A?
    => Stream.flatMap()は三連ネストは
    *  一番外側のListを外した二重ネストとなる新たなStreamを生成。
    *  map(String::toLowerCase())は
    *  map(s -> s.toLowerCase())と同じ。
    *  Streamの要素は List<String>であるため、コンパイルエラー。

〇 （75） C
〇 （76） B, D
〇 （77） C, D
〇 （78） A, C, D
Ｘ （79） C -> B
    => Collectionなど Comparableを実装するクラスは
    *  reverseOrder()の引数なしだと、Comparableの順序を参考に逆順とする。
    => Map.Entryは Comparableを実装しておらず、
    *  reverseOrder()を引数なしで利用するとコンパイルエラー

〇 （80） D
〇 （81） A, B
〇 （82） B
〇 （83） C
〇 （84） C
〇 （85） A

開始時刻 10:53
終了時刻 13:35
所要時間 162 分
正答率 76.47 ％ ( 〇65問 / 全85問 )
*/

