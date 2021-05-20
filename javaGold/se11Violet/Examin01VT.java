/**
 * @title javaGold / se11Violet / Examin01VT.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content  Violet総合問題１
 * @author shika
 * @date 2021-05-20
 */
/* Appendix 2021-05-20
 * @costTime 08:37 - 11:27 ( 169 分)
 * @correctRate 正答率 72.50 ％ ( 〇58問 / 全80問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Examin01VT {

    public static <T> void main(String[] args) {
        new PracticeEditor();
    }//main()
}//class

/*
//====== 2021-05-20 ======
 Violet総合問題１
〇 （1） D
    => ◆アンボクシング LapperClass -> primitive
    *  int Integer.intValue()
    *  boolean Boolean.booleanValue()
    *  long Long.longValue()
    *  LapperClassに nullは格納可だが、上記メソッドで変換時に
    *  NullPointerException

〇 （2） A, D
    => ◆Object.equals(), hashCode()
    *  equals()が trueのとき、必ず hashCode()は等しい。
    *  equals()が falseのとき hashCode()は等しいとは限らない。
    *  Overrideして、hashCode()が異なる時、equals()も falseになるよう実装する。

〇 （3） B
      => Outer,Innerで同名のメソッドはＯＫ。

〇 （4） B
      => enumのコンストラクタは private。(無記)だとコンパイル時に暗黙付記。
      *  Boolean.FALSE, Boolen.TRUEという定数が存在する。
      *  値はfalse, true

〇 （5） F
      => X <- Y / X <- Zという継承関係
      *  X obj1 = new Y();は問題なし
      *  Z obj2 = (Z) obj1;は キャストして X型からZ型へ変換。
      *  X <- Zという継承関係があるため、コンパイルは通る。
      *  obj1が参照しているのは Y型なので、実行時に ClassCastException

Ｘ （6） E, F -> B, E
  => ◆ インターフェイスでの抽象メソッド
  *    ＊public, abstractのみ
  *
  *  ◆ インターフェイスでの具象メソッド
  *    ＊static: public,private
  *    ＊default: publicのみ
  *    ＊非static: privateのみ
  *
  *  A: Ｘ static abstractは不可。
  *  B: private staticは可。
  *  C: Ｘ private abstractは不可。Overrideを前提。
  *  D: Ｘ private defaultは不可。他クラスからの利用を前提。
  *  F: Ｘ 具象メソッドは static, defaultである必要はない。

〇 （7） C
    => 継承した同階層に同名の defaultメソッド
    *  呼出時に どちらを呼び出すか選択できず、コンパイルエラー。

Ｘ （8） F -> E
    => 継承時 public foo()よりアクセス修飾子を狭くしているのでコンパイルエラー。

Ｘ （9） A, E, F -> A, C, F
    => A: boolean Object.equals(Object)
    *  C: int Object.hashCode()
    *  の Override
    => F: インターフェイスの abstractは暗黙で public。 Ｘ E

Ｘ （10） B, E -> A, E
    => A: Objectクラスのメソッドを defaultにするとコンパイルエラーだが
    *  設問の default equals()は引数がなく、オーバロードなので可。
    *
    *  Ｘ B: インターフェイス内の具象メソッドは static, default, privateのみ。
    *
Ｘ （11） C -> B
    => @SafeVarargsは、static, final, privateのいずれか必要。
    *  可変長引数 List<T>...の定義でもコンパイル後は配列になるので
    *  lengthでＯＫ。

〇 （12） A, B
    => @Target({ElementType.TYPE}) は
    *  クラス、インターフェイス、enum

〇 （13） F
〇 （14） E
〇 （15） G -> F -> G
    => G: 回答理由 static class fooでコンパイルエラーかと
    *  【Eclipse検証】 ほらっ
    *  static class foo { }
    *  //クラス foo の修飾子が正しくありません。
    *  //public、abstract、および final のみが許可されています

    => Innerクラスの static classはある。= メソッド扱いだから
    *  { }閉じてるか確認したし、インデントもしていない。
    *  頼むよ。山本道子。
    *  よって正解とす。

    => Throwable[] e.getSuppress()

〇 （16） E, F?
    => java.lang.AutoCloseable：
    *    void close() throws Exception
    *  java.io.Closeable：
    *    void close() throws IOException

Ｘ （17） B, C? -> A, C
    => assert: 予約語で識別子不可。
    => assertは デバック目的の命令なので、
    *  インクリメントなど通常処理を含むことは不適切。
    *  assert無効でも処理が成り立つようにするには、
    *  通常処理を含めないようにする必要がある。

〇 （18） F
〇 （19） A, B, D, E
Ｘ （20） F? -> H
    => T Stack.pop() 先頭から要素を削除。 null時はnull
    *  T Queue.remove() 先頭から要素を削除。null時は例外。
    *  T Stack/Queue.peek() 先頭の要素を調査。削除せず。null時は null.
    *
    *  deque.pop()
    *  deque.peek()
    *  deque.remove()は
    *  いづれも print処理をしていないので、表示はされない。
    *
    *  while(deque.remove() != null)のため、
    *  remove()は null時に例外のため、
    *  NoSuchElementException 〔runtime〕

〇 （21） A, E, F
    => Vector implements List

〇 （22） E
Ｘ （23） B, D, E -> A, D, E
    => Class.<T>foo(T)のようにジェネリックの型宣言をすることは可能。
    *  B: Test.<Throwable>foo(new Exception("ex"));
    *  <Throwable>宣言しているので Throwable型となる。

    => RuntaimeException extends Exception
    *  Exeption extends Throwable
    *  Error extends Throwable
    *
    *  Throwable
    *    ┗ Error
    *    ┗ Exception
    *        ┗ IOException, SQLExceptionなど checked例外
    *        ┗ RuntimeException
    *             ┗ NullPointer, IndexOutOfBoundsなど unchecked例外

〇 （24） B, D
〇 （25） A
Ｘ （26） C? -> D
    => int Collection.binarySearch(T)
    *    引数の要素にあたる indexを返す。
    *    利用前に sort()によって、自然順序昇順にしておかないと、
    *    正しい検索結果を保証できない。

〇 （27） B, F
〇 （28） B
    => メソッド宣言のジェネリックの型宣言は 修飾子と戻り値の間

〇 （29） C
〇 （30） D
Ｘ （31） C? -> D
    => R DuobleFunction<R>.apply(double)

    => Cの回答理由: 引数 doubleなのは気付いていたが、
    *  int 100を入れても暗黙の型変換で int -> doubleは可能なはず。
    *
    => 【Eclipse検証】  案の上、コンパイルエラーは起こらず
    *  DoubleFunction<Double> d = f -> f * 1.0;
    *  double result = d.apply(100);
    *  System.out.println(result);
    *  //実行結果: 100.0
    *
    *  ただ設問は<>の記載がなく <Object>なため、
    *  Object -> Double の型変換は不可。コンパイルエラーが正しい。
    *
    *  DoubleFunction f = i -> i * 0.1;
    *  Double ans = f.apply(100);
    *  //型の不一致: Object から Double には変換できません

Ｘ （32） C -> B
    => IntStream.rangeClosed(0, 11)
    *  .skip(1)で 0除外
    *  .limit(10)で 11除外 skip()で減った分は考慮せず、
    *  元のrange()の個数 10個
    *
    *  C: peek(a -> val += a)
    *         final違反でコンパイルエラー。
    *
〇 （33） D
    => itrator("", s -> s + "a")の ""も初期値としてＯＫ。
    *  .limit(2)より a
    *  .map(x -> x + "x")で xax

Ｘ （34） A -> E
    => anyMatch(), noneMatch()とも終端処理のため、
    *  １つ目終了して、２つ目を実行すると、
    *  IllegalStateException

〇 （35） D, E
〇 （36） A
〇 （37） C
〇 （38） C
〇 （39） D
    => DoubleStreamは 引数、戻り値とも double
    *  mapToInt()は 戻り値 intのためコンパイルエラー。
    *
    *  ◆ DoubleStream -> Stream<Integer>
    *  Stream<Double> stream5 = DoubleStream.mapToObj(a -> a);
    *  Stream<Integer> stream6 = stream5.map(a -> a.intValue())

〇 （40） C?
    => ◆ Stream<T> Stream.empty()
    *  Map<Boolean, List<T>> Collectors.patitioningBy())
    *    {false=[], true=[]}
    *  Map<K, List<V>> Collectors.groupingBy()
    *    {}
    *
〇 （41） E
Ｘ （42） A, D -> B, F
    => ◆Stream<T> empty = Stream.empty();
    => <T>のままだとコンパイルエラー。コンパイル時に<Object>となり、
    *  foo(Stream<Integer>)には渡せない。
    *
    *  ◆Streamのままだと警告は出るが、
    *  foo(Stream<Integer>)には渡せる。
    *  Stream empty = Stream.empty();
    *  foo(empty);
    *  //型の安全性: 型 Stream の式は、未検査の型変換を使用して
    *  //Stream<Integer> に準拠するようにする必要があります
    *
    *  public static void foo(Stream<Integer> in) { }
    *
    * よって、解答の通り、実行時に NoSuchElementException
    *
    * foo(Stream.of(5, 10) stream)
    * stream.filter(n -> n < 5)より要素を持たず、
    * max()で NoSuchElementException

〇 （43） F
Ｘ （44） E -> A
    => E: 回答理由: 何も実行されない
    *  collect(Collectors.toLIst())が Listに代入されていなかったため
    *  実行しても何も処理されないと思ったが
    *  peek(x -> System.out.print(x + " "))
    *  があるので、終端処理があれば表示される。

〇 （45） D
    => s.collect()で終端処理が完了したのち、
    *  s.map()と次の処理をしているので
    *  IllegalStateException

〇 （46） C
〇 （47） D
    => OptionalDouble XxxxSteam.avarage()
    *  double OptionalDouble.getAsDouble()

    => Optional<T> Stream.reduce(BinaryOperator)
    *  T Optional.get()/ orElse(T)

〇 （48） C
    => int OptionalInt.getAsInt()

〇 （49） B
〇 （50） A
〇 （51） D
〇 （52） B
    => ServiceLoader<T> ServiceLoader.load(Class<T>)
    *  Iterator<T> ServiceLoader.itreator()

Ｘ （53） B, D -> D, E
    => ◆ jlinkコマンド
    *  必要なモジュールのみで構成されたランタイム(実行環境)を作成。
    *  --launcherでランチャーファイル(起動ファイル)を作成することもできる。

Ｘ （54） A -> C
    => 「Xは Yを利用、Yは Zを利用」 Xが最下位のモジュール
    => 無名モジュールはクラスパスに配置されているが、
    *  モジュール化したものから、モジュールパス上に配置していく。

〇 （55） C
〇 （56） E
〇 （57） E, F
    => 同じスレッドプールを利用した場合は 順序不定
    => 違うスレッドプールなら、デッドロックの可能性

〇 （58） F
〇 （59） A, E
〇 （60） C
Ｘ （61） C -> E
    => new CyclicBarrier(1);なので
    *  ひとつのスレッドが通過すればトリップ(解放)する
    *  ３回 exec()されるので、３回表示。

Ｘ （62） D, E, F -> B, C, E
    => PrintWriter Cosole.writer()
    *  void PrintWriter.println()
    => Console.format()
    *  Console.printf()
    *  Ｘ print(), println()は未定義

〇 （63） E
Ｘ （64） E? -> D
    => mark(),reset()は BufferedInputStreamのメソッド
    *  FileInputStreamには未定義、reset()時に
    *  IOException
    *
    => BufferedInputReader.mark(int)
    *  BufferedInputStream.mark(int)
    *  引数の intはマークを維持しながら読み込める文字数の上限を設定

Ｘ （65） B -> F
    => 5行目のpath.subpath(1, 3)により「doc/sample」が得られ、
    *  getName(1)により「sample」が得られます。
    *  toAbsolutePath()は絶対パスを返すため、
    *  現在のカレントディレクトリである「/tmp/miko」に「sample」を結合した
    *  「/tmp/miko/sample」を返します。
    *
    *  ？絶対パスならカレント関係ないのでは？

〇 （66） B, C, D
    => /fooは/doc/manualディレクトリへのシンボリックリンクファイルであるため、
    *  testディレクトリが作成されると、
    *  /doc/manual/test、/foo/testのいずれのパスでも
    *  アクセスが可能です。

〇 （67） G
    => Stream<Path> Files.find(Path, int, BiPredicate)
    *  intの検索深度 0 だと Pathで示された場所のみ検索

Ｘ （68） D, E -> A, B
    => find()の第3引数は BiPredicate<T super Path, U extends BasicFileAttributes>
    *  boolen BiPredicate.test(Path, BasicFileAttribute)

〇 （69） B, E
    => ClassLoader Class.getClassLoader()
    *  Class<?> Class.forName(String className,
    *                         boolean initialize,
    *                         Classloader)
    *  クラスが見つからないと  ClassNotFoundException

〇 （70） C
〇 （71） E
〇 （72） D
    => void ResultSet.beforeFirst()
    *  void ResultSet.afterLast()
    *  どちらも voidのため print()の引数に入れるとコンパイルエラー。

〇 （73） C, D
〇 （74） C
    => ListResourceBundleは String以外の型も扱えるが
    *  プロパティファイルは全て Stringとして読み込まれる。


〇 （75） E
〇 （76） B
〇 （77） A
    => boolean Path.equals(Path) 文字列としての等しさを判定

〇 （78） A
〇 （79） E
    => setString()で列名を入力しても、
    *  値が文字列なのでコンパイルでは判定不可。
    *  実行時に SQLException

Ｘ （80） A -> D
    => A: add()メソッドを呼び出す前に、
    *  num1とnum2の桁チェックは行うべきです。
    *  B: BigIntegerクラスは、
    *  基本データ型では扱えない大きい値を扱うことができます。
    *  C: Math.addExact(long x, long y)メソッドは、
    *  引数の合計を返します。
    *  その結果がlongをオーバーフローする場合は例外をスローするため、
    *  例外処理を適切に行うことでオーバーフローへの対応が可能です。
    *  D: 問題文のnum1とnum2は、
    *  基本データ型のlong型であるため、上位の整数型はありません。
    *  よってアップキャストができないため、誤りです。

開始時刻 08:37
終了時刻 11:27
所要時間 169 分
正答率 72.50 ％ ( 〇58問 / 全80問 )
*/

