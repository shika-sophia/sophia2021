/**
 * @title javaGold / se11White / Practice05whFunctionLambda.java
 * @reference 日本サードパーティ 『Java Gold SE11 オラクル認定問題集 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 Function, Lambda
 * @author shika
 * @date 2021-04-05
 */
/* Appendix 2021-04-05
 * @costTime 15:17 - 15:38 ( 21 分)
 * @correctRate 正答率 76.47 ％ ( 〇13問 / 全17問 )
 */
/* Appendix 2021-05-05
 * @costTime 14:22 - 14:47 ( 24 分)
 * @correctRate 正答率 94.12 ％ ( 〇16問 / 全17問 )
 */
package javaGold.se11White;

import javaGold.PracticeEditor;

public class Practice05whFunctionLambda {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-04-05 ======
 第５章 Collection, Lambda
〇 （1） B, D
〇 （2） C
    => Objectクラスの抽象メソッドは
    実装クラスで Overrideの対象とならないため
    関数型インターフェイスの要件を満たさない。

Ｘ （3） C -> B
    => interface宣言時 Portable<Integer>
        Portable p = (Integer n) ->
        定義式でジェネリックなし <Object>として扱われ、（Integer n）の引数でコンパイルエラー。
        Portable<Integer> p = (Integer n) ->は可。
        Portable p = n -> は警告が出るがコンパイルは通る。

Ｘ （4） E -> A
    => interface Simple { public int func(int); }
    Simple s4 = { throw new RuntimeException(); }
    戻り値 intを返せていないが、例外 throwでコンパイルは通るとのこと。
    s4を用いた呼出をすると実行時に例外

〇 （5） B
〇 （6） C
〇 （7） C
〇 （8） B
〇 （9） B
〇 （10） A
〇 （11） A
Ｘ （12） B -> C
    => UnaryOperator<T>は T apply(T)より 引数と戻り値が一致。
    List<Integer> の replaceAll()なので 元の型は Integer
    よってコンパイルエラー。

Ｘ （13） A -> B
    => Consumer<Integer> c2 = c1.andThen(
            System.out.println(":" + i * i));
        c1の処理後 ":" i * iをして戻り値。

    c1の時点では定義のみで print()していない。
    c2で初めて println()なので 10:100 となる。
〇 （14） D
〇 （15） C
〇 （16） D
〇 （17） B

開始時刻 15:17
終了時刻 15:38
所要時間 21 分
正答率 76.47 ％ ( 〇13問 / 全17問 )
*/

/*
//====== 2021-05-05 ======
 Function, Lambda [２回目]
〇 （1） B, D
〇 （2） C
    => Object.equals(), toString()は 実装クラスで Overrideの対象とならない。
        たとえ、abstractメソッドでも、@FunctionalInterfaceの要件を満たさない。

〇 （3） B
〇 （4） A
    => Integer Integer.valueOf(int)は戻り値が Integerだが、
        オートアンボクシングされ、intで返る。

〇 （5） B
〇 （6） C
〇 （7） C
〇 （8） B
〇 （9） B
〇 （10） A
〇 （11） A
    => R BiFunction<T, U, R>
       Double BiFunction<Double, Integer, Double>
            bf = (a, b) -> a + b;
            bf.apply(10.0, 10)
        第1引数 Double 10.0, 第2引数 Integer 10が入り、
        計算時 10.0 + 10は オートアンボクシングされ、double + int = doubleとなり、
        戻り値 Doubleに再オートボクシングされる。

〇 （12） C: replaceAll(Collection)では? -> removeAll(Collection<T>)
    => Collection.replaceAll(UnaryOperator<T>)だと、
    引数と戻り値は同じ型である必要がある。
    List<Integer>で定義された Listに Doubleを返すとコンパイルエラー。

〇 （13） B
    => ◆関数型インターフェイスの合成 Function,Consumer, Operator
        before.andThen(after)
        after.compose(before)

        Predicate<T>
        a.and(b), a.or(b), a.negate(b)
    => 〔DJ 131B〕

Ｘ （14） A -> D
    => Function<String,Integer> f = t -> t.length();
       t::lengthだと、tを定義していないためコンパイルエラー。
       引数を利用するインスタンスメソッドの呼出はクラス名を使う。
       String::lengthで 引数 String.length()、戻り値 int -> Integer
〇 （15） C
〇 （16） D
〇 （17） B
    => String str = "Java";
       ToIntFunction<String> f =  value -> str.valueOf(value);
       ToIntFunction<String> f = str::valueOf;
       f.applyAsInt("J");

開始時刻 14:22
終了時刻 14:47
所要時間 24 分
正答率 94.12 ％ ( 〇16問 / 全17問 )
*/

