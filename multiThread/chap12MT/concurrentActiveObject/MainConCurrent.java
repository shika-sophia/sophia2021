/**
 * @title multiThread / chap12MT / concurrentActiveObject / MainConcurrent.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第12章 Active Object パターン / List 12-16 ～ 12-21
 * @content サンプルコード２ / concurrentパケージの各クラスを用いてサンプル１と同様の動作を実現
 *
 * @class + MainConcurrent / ◆main(), IActObj, MakeTh, ShowTh, ActObj.shutdown()
 * @class + MakeClientThread / IActObj(ActObjImpl).makeStr()
 * @class + ShowClientThread / IActObj(ActObjImpl).showStr()
 * @interface + IActObj / abstract makeStr(),showStr(),shutdown()
 * @class + ActObjFactory / new ActObjImpl
 * @class + ActObjImpl implements IActObj / IActObjを実装、Requestをローカルクラスとしてインスタンス
 *               //SchedulerThreadの代わり
 *               ExecutorService exeService= Executors.newSingleThreadExecutor();
 * @class     MakeRequest implements Callable / LocalClass, call()内で Servantの実行処理
 * @class     ShowRequest implements Runnable / LocalClass, run()内で Servantの実行処理
 *
 * @author shika
 * @date 2021-03-27
 */

package multiThread.chap12MT.concurrentActiveObject;

public class MainConCurrent {

    public static void main(String[] args) {
        IActObj actObj = ActObjFactory.createActObj();

        try {
            new MakeClientThread("Alice", actObj).start();
            new MakeClientThread("Bobby", actObj).start();
            new ShowClientThread("Chris", actObj).start();

            Thread.sleep(5000);
        } catch (InterruptedException e ) {
            e.printStackTrace();
        } finally {
            System.out.println("**** shutdown() ****");
            actObj.shutdown();
        }
    }//main()

}//class

/*
Alice: realResult =
Bobby: realResult =
showStr(): Chris: 0
Alice: realResult = A
Bobby: realResult = B
showStr(): Chris: 1
Alice: realResult = AA
showStr(): Chris: 2
Bobby: realResult = BB
showStr(): Chris: 3
Alice: realResult = AAA
Bobby: realResult = BBB
showStr(): Chris: 4
showStr(): Chris: 5
Alice: realResult = AAAA
showStr(): Chris: 6
showStr(): Chris: 7
Bobby: realResult = BBBB
showStr(): Chris: 8
showStr(): Chris: 9
showStr(): Chris: 10
Alice: realResult = AAAAA
showStr(): Chris: 11
showStr(): Chris: 12
Bobby: realResult = BBBBB
showStr(): Chris: 13
showStr(): Chris: 14
showStr(): Chris: 15
Alice: realResult = AAAAAA
showStr(): Chris: 16
showStr(): Chris: 17
Bobby: realResult = BBBBBB
showStr(): Chris: 18
showStr(): Chris: 19
showStr(): Chris: 20
**** shutdown() ****

java.util.concurrent.RejectedExecutionException: Task multiThread.chap12MT.concurrentActiveObject.ActObjImpl$1ShowRequest@74ebacfc rejected from java.util.concurrent.ThreadPoolExecutor@31e93c05[Shutting down, pool size = 1, active threads = 1, queued tasks = 5, completed tasks = 35]
Alice: realResult = AAAAAAA
showStr(): Chris: 21
java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@4b0398b1[Not completed, task = multiThread.chap12MT.concurrentActiveObject.ActObjImpl$1MakeRequest@6eebe5c1] rejected from java.util.concurrent.ThreadPoolExecutor@31e93c05[Shutting down, pool size = 1, active threads = 1, queued tasks = 4, completed tasks = 36]

showStr(): Chris: 22
showStr(): Chris: 23
showStr(): Chris: 24
java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@30a490ab[Not completed, task = multiThread.chap12MT.concurrentActiveObject.ActObjImpl$1MakeRequest@3bdb3c7b] rejected from java.util.concurrent.ThreadPoolExecutor@31e93c05[Shutting down, pool size = 1, active threads = 1, queued tasks = 0, completed tasks = 40]

Bobby: realResult = BBBBBBB

*/