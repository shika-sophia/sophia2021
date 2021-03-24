/**
 * @title multiThread / chap11MT / Practice11MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第11章 Thread-Specific-Storage / 練習問題 11-1, 11-2, 11-4, 11-5, 11-6
 * @author shika
 * @date 2021-03-25
 */
/* Appendix 2021-03-25
 * @costTime 06:28 - 06:56 ( 27 分)
 * @correctRate 正答率 60.00 ％ ( 〇9問 / 全15問 )
 */
package multiThread.chap11MT;

import javaGold.PracticeEditor;

public class Practice11MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-25 ======
 第11章 Thread-Specific-Storage / 練習問題 11-1
〇 （1） Ｘ -> ThreadLocalのインスタンスは１つ
Ｘ （2） Ｘ -> PrintWriterのインスタンスは１つ
    =>LogTSのインスタンスごとに生成されるので３つ

〇 （3） 〇 -> ThreadLocal.set()は３回呼び出される。
〇 （4） Ｘ -> 新規作成時や書き込み時など３回以上
    => println() 10回, close()１回ごとに呼ばれる
    11 * 3 = 33回

Ｘ （5） Ｘ -> LogTSは元クラス１つ
    => 元クラスから、ClientThreadごとにインスタンスが作られ３つ

Ｘ （6） 〇 -> LogThreadLocalは ClientThreadがインスタンスして３つある
    LogThreadLocalは振り分け役で１つ
    => staticなので インスタンスは１つも生成されない

 練習問題 11-2
〇 （1） LogTSが synchronizedされていないのは、各スレッドごとにインスタンスされ別々だから
〇 （2） LogThreadLocalクラスは フィールドのThreadLocalクラスCollectionでスレッドごとに振り分けているから
    => prinln(), close()は複数スレッドからアクセスされるが、
    状態を表すフィールドを持っていない
    ThreadLocalは内部でThreadごとに振り分ける thread-safeなフィールド

 練習問題 11-3
〇 （1） Log.close()の自動化 / 別package
    => try-catch- resource文だと、run()する前に終了してしまう。
    => 【解答】 スレッドが終了するのを待つ Threadを新たに立ち上げ状態を監視している。

 練習問題 11-4
Ｘ （1） Clientコンストラクタ時点では LogTSインスタンスができておらず、nullが返り新規作成される
Ｘ （2） return LogTSで println(str)に戻るから表示されそうだけど、なんでやろ。
    => コンストラクタにアクセスするのは mainスレッド。
    run()は ClientThreadが起動。
    main_log.txtが生成されるが main.close()していないので正しく保存されるかは不明とのこと。

 練習問題 11-5
Ｘ （1） Threadの thread-internalな情報: currentThread()の戻り値
〇 （2） getName()の threadName, getId()の threadId
    -> 間違いではないが追記、ノートにも転記。
    => ◆Threadの thread-internal情報
        getPriority(): スレッドの優先度
        getThreadGroup(): スレッドグループ
        isInterrupted(): インターラプト状態
        isDaemon(): デーモンスレッドかどうか
        isAlive(): スレッドが生存しているか
        getId(): スレッドを識別する long値
        getState(): スレッドの状態
        getUncaughtExceptionHandler(): キャッチされない例外

練習問題 11-6
〇 （1） ThreadPoolで３個しか作っておらず、Threadをキーとして値を取り出すので
〇 （2） WorkerThreadパターンとの併用は不可。ThreadPoolで仕事が終了したら次の仕事に使いまわし、動いているスレッドは３つだけだから
    => Thread-Specific-Storageパターンでは、
    Threadの数だけ固有の領域が確保される。
    各々が別のスレッドで実行されることを保証する必要がある

開始時刻 06:28
終了時刻 06:56
所要時間 27 分
正答率 60.00 ％ ( 〇9問 / 全15問 )
*/

