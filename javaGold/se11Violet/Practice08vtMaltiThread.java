/**
 * @title javaGold / se11Violet / Practice08vtMaltiThread.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content  第８章 並行処理
 * @author shika
 * @date 2021-04-27
 */
/* Appendix 2021-04-27
 * @costTime 11:07 - 11:47 ( 39 分)
 * @correctRate 正答率 68.75 ％ ( 〇11問 / 全16問 )
 */
/* Appendix 2021-05-11
 * @costTime 16:52 - 17:28 ( 36 分)
 * @correctRate 正答率 87.50 ％ ( 〇14問 / 全16問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice08vtMaltiThread {

    public static void main(String[] args) {
        new PracticeEditor();

        //ExecutorService es = null;
        //es.exec();
    }//main()

}//class
/*
//====== 2021-04-27 ======
 第８章 並行処理
〇 （1） A, E
   => synchronized(this): Fooクラスのインスタンスをロック
      static synchronized getFoo(): Fooクラスのオブジェクトのロック

〇 （2） D
〇 （3） B, F
    => Collection.parallelStream()
       BaseStream.parallel()

〇 （4） C
     => ラムダ内から参照するローカル変数は final, 実質final。
        ++numと変更を加えるとコンパイルエラー
〇 （5） D
    => Arrays.asList()は List扱いなので parallelStream()

Ｘ （6） A -> D
    => reduce(T, BinaryOperator<T>) 初期値や引数の型と、戻り値の型が違うとコンパイルエラー。

Ｘ （7） C, F -> D, F
   => groubingByConcurrent()でも、Map<Boolean,List<T>>にしてよい。
      partitioningBy()でなければいけないと思っていたが、
      key決定式の戻り値を Booleanにすればできる。

Ｘ （8） B, C, E, G -> B, E, F, G
    => V call() throw Exception
       void run()

Ｘ （9） A, C, F -> A, C, E
     => F: 戻り値を返していないのでＸ

〇 （10） C
     => ExecutorServiceの ThreadPoolは、タスクを実行できるThreadがないと、
        実行できるまで待機。GuardedSuspensionパターンが備わっている。

〇 （11） A
      => Executor.newSingleThreadExecutor()なので
         常にシングルスレッドで実行される。
         val2はアトミックではないので、マルチスレッド環境ではスレッドセーフではない。

〇 （12） E
Ｘ （13） B, D -> C, D
    Executor.newSingleThreadScheduledExecutor()の戻り値は、
    ScheduledExecutorService。 ExecutorServiceは superのためコンパイルは通る。
    scheduleWithFixedDelay()は ScheduledExecutorServiseにしか定義されていないので、
    ここでコンパイルエラー。

    => scheduleXxxFixedXxx(Runnable, int, int , TimeUnit)
    第１引数は Runnableのみで Callable不可。
    1回以上実行されるので、Callableの戻り値があると処理しきれない。

    => schedule()はどちらも可。実行は１回のみ。

〇 （14） A, D
    => Future.get()は前処理の戻り値がでるまで待機する。
    => Future<?> ExecutorService.submit(Runnable)
        Future<?>は nullも格納可。実行時例外の例外オブジェクトも格納可。
〇 （15） B
    => findFirst()はパラレルストリームでも常に最初の値を返す。

〇 （16） D
    => ExecutorService.exec()なんていうメソッドはない。(Eclipseで確認済)
    => execute()の誤植として解答も話が進んでいる。
    void execute(Runnable)のため、戻り値 Future<Object>は不可。

    => Future<?>.get()は nullも取り出し可。

開始時刻 11:07
終了時刻 11:47
所要時間 39 分
正答率 68.75 ％ ( 〇11問 / 全16問 )
*/

/*
//====== 2021-05-11 ======
 MultiThread [２回目]
〇 （1） A, E
〇 （2） D
〇 （3） B, F
〇 （4） C
〇 （5） D
〇 （6） D
     => T Stream.reduce(T, BinaryOperator<T>)
         引数と戻り値は同じ型でないとコンパイルエラー
     => U Stream.reduce(
             U identity,
             BiFunction<U, ? super T,U> accumurator,
             BinaryOperator<U> combiner)
         *Streamの型引数と結果の型が異なる場合に利用

〇 （7） D, F
       => groupingByConcurrent(): マルチスレッド環境でもスレッドセーフにグループ化


〇 （8） B, E, F, G
     => Callable.call() throws Exception
         * checked例外をスローできる
         * Runnable.run()は不可。
     => Runnable.run()も unchecked例外は throw可

〇 （9） A, C, E
〇 （10） C
〇 （11） A
〇 （12） E
Ｘ （13） B, D -> C, D
      Executors.newSingleThreadScheduledExecutor()の戻り値は
      ScheduledExecutorService。
      ExecutorServiceは superのためコンパイルエラーにはならない。

      scheduledWithFixedDelay()は ScheduledExecutorServiceのメソッドのためコンパイルエラー。
      9行目: Callableの定義ラムダ式、System.out.print()は void
          戻り値を返さないとコンパイルエラー。
      scheduledWithFixedDeray(Runnable, long, long, TimeUnit)
      Callableを入れるとコンパイルエラー。

Ｘ （14） B, D -> A, D
     => Future.get()は処理が完了するまで待機する
     => Future<?>なので、null,Exceptionクラスも格納可。
         1回ではなく 10回表示される。

〇 （15） B
〇 （16） D
       => void ExecutorService.execute() 戻り値 voidなのでコンパイルエラー。
       Future<T> ExecutorService.submit()ならＯＫ。
       その場合、実行結果は null, null, null

    => List<Future<Object>>だが
    for(Future<?> f : list)でも扱える。

開始時刻 16:52
終了時刻 17:28
所要時間 36 分
正答率 87.50 ％ ( 〇14問 / 全16問 )
*/

