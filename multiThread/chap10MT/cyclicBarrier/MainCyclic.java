/**
 * @title multiThread / chap10MT / cyclicBarrier / MainCyclic.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第10章 Two-Phase-Termination / List 10-6, 10-7
 * @content CyclicBarrierクラス / 指定したスレッド数が待機するまでバリア。繰り返しバリアアクションを実行。
 * @author shika
 * @date 2021-03-20
 */
package multiThread.chap10MT.cyclicBarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainCyclic {
    private static final int THREAD = 3;//スレッドの個数

    public static void main(String[] args) {
        System.out.println("main: BEDIN");

        //仕事を実行するスレッド起動
        ExecutorService exeService = Executors.newFixedThreadPool(THREAD);

        //バリアアクションの定義
        Runnable action = new Runnable() {
            public void run() {
                System.out.println("Barrier Action!");
            }//run()
        };

        //フェーズを合わせる CyclicBarrier
        CyclicBarrier cyclic = new CyclicBarrier(THREAD, action);

        //仕事の終了を調べる CounDownLatch
        CountDownLatch latch = new CountDownLatch(THREAD);

        try {
            for(int i = 0; i < THREAD; i++) {
                exeService.execute(
                    new MyTaskCyclic(cyclic, latch, i));
            }//for

            //仕事の終了を待つ
            System.out.println("main: await()");
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            exeService.shutdown();
            System.out.println("main: END");
        }
    }//main()

}//class

/*
main: BEDIN
pool-1-thread-1: doPhase() BEGIN 0
pool-1-thread-3: doPhase() BEGIN 2
main: await()
pool-1-thread-2: doPhase() BEGIN 1
pool-1-thread-1: doPhase() END 0
pool-1-thread-2: doPhase() END 1
pool-1-thread-3: doPhase() END 2
Barrier Action!
pool-1-thread-3: doPhase() BEGIN 2
pool-1-thread-2: doPhase() BEGIN 1
pool-1-thread-1: doPhase() BEGIN 0
pool-1-thread-2: doPhase() END 1
pool-1-thread-3: doPhase() END 2
pool-1-thread-1: doPhase() END 0
Barrier Action!
pool-1-thread-1: doPhase() BEGIN 0
pool-1-thread-3: doPhase() BEGIN 2
pool-1-thread-2: doPhase() BEGIN 1
pool-1-thread-1: doPhase() END 0
pool-1-thread-2: doPhase() END 1
pool-1-thread-3: doPhase() END 2
Barrier Action!
pool-1-thread-3: doPhase() BEGIN 2
pool-1-thread-2: doPhase() BEGIN 1
pool-1-thread-1: doPhase() BEGIN 0
pool-1-thread-1: doPhase() END 0
pool-1-thread-2: doPhase() END 1
pool-1-thread-3: doPhase() END 2
Barrier Action!
pool-1-thread-3: doPhase() BEGIN 2
pool-1-thread-2: doPhase() BEGIN 1
pool-1-thread-1: doPhase() BEGIN 0
pool-1-thread-3: doPhase() END 2
pool-1-thread-2: doPhase() END 1
pool-1-thread-1: doPhase() END 0
Barrier Action!
main: END

*/