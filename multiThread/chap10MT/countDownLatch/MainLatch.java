/**
 * @title multiThread / chap10MT / countDownLatch / MainLatch.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第10章 Two-Phase-Termination / List 10-4, 10-5
 * @content CountDownLatchクラス / 指定回数 カウントダウンするまで待機する
 * @author shika
 * @date 2021-03-20
 */
package multiThread.chap10MT.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainLatch {
    private static final int TASK =10;

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        ExecutorService exeService = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(TASK);

        try {
            //仕事を開始する
            for(int i = 0; i < TASK; i++) {
                exeService.execute(new MyTaskLatch(latch, i));
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
main: BEGIN
pool-1-thread-1: doTask() BEGIN 0
pool-1-thread-5: doTask() BEGIN 4
main: await()
pool-1-thread-4: doTask() BEGIN 3
pool-1-thread-3: doTask() BEGIN 2
pool-1-thread-2: doTask() BEGIN 1
pool-1-thread-4: doTask() END 3
pool-1-thread-2: doTask() END 1
pool-1-thread-5: doTask() END 4
pool-1-thread-3: doTask() END 2
pool-1-thread-3: doTask() BEGIN 8
pool-1-thread-1: doTask() END 0
pool-1-thread-5: doTask() BEGIN 7
pool-1-thread-2: doTask() BEGIN 6
pool-1-thread-4: doTask() BEGIN 5
pool-1-thread-1: doTask() BEGIN 9
pool-1-thread-3: doTask() END 8
pool-1-thread-2: doTask() END 6
pool-1-thread-5: doTask() END 7
pool-1-thread-4: doTask() END 5
pool-1-thread-1: doTask() END 9
main: END

*/