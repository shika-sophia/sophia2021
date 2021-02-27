/**
 * @title multiThread / chap03MT / guardedSuspention / ClientThread.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 *
 * @note ◆Random(seed): long seed値を指定すると毎回同じ順序の乱数を生成。
 * @reference ＊Javaで毎回完全に異なる乱数を取得する方法
 *                  ～ long seed = System.currentTimeMillis();
 *                  ～ long seed = Runtime.getRuntime().freeMemory();
 *             https://npnl.hatenablog.jp/entry/20090116/1232120896
 *
 * @content 第３章 GuardedSuspention / List 3-3
 * @author shika
 * @date 2021-02-27
 */
package multiThread.chap03MT.guardedSuspention;

import java.util.Random;

public class ClientThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;

    public ClientThread(
            RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }


    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No." + i);
            System.out.println(
                currentThread().getName() + " requests " + request);

            requestQueue.putRequest(request);

            try {
                sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//for
    }//run()
}//class
