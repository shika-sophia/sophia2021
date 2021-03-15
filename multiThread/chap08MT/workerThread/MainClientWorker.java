/**
 * @title multiThread / chap08MT / workerThread / MainClientWorker.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第８章 WorkerThread / List 8-1, 8-2, 8-3, 8-4, 8-5
 * @refernce ◆Javaで空きメモリの量を簡単に調べる
 *           https://qiita.com/arai-wa/items/482091c6a8d2ade6f5ba
 *           Runtime.getRuntime().freeMemory()
 * @author shika
 * @date 2021-03-13
 */
package multiThread.chap08MT.workerThread;

public class MainClientWorker {

    public static void main(String[] args) {
        ChannelWork channel = new ChannelWork(5);
        channel.startWorker();

        new ClientThread("Alice",channel).start();
        new ClientThread("Bobby",channel).start();
        new ClientThread("Chris",channel).start();

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("totalRequest: " + ChannelWork.getTotalRequest());
        System.out.println("totalExecute: " + ChannelWork.getTotalExecute());
        System.out.printf("freeMemory: %,d \n",
                Runtime.getRuntime().freeMemory());
        System.exit(0);
    }//main()

}//class

/*
Worker-4 executes [Request from Bobby No.0]
Worker-0 executes [Request from Alice No.0]
Worker-1 executes [Request from Chris No.0]
Worker-3 executes [Request from Bobby No.1]
Worker-0 executes [Request from Alice No.1]
Worker-2 executes [Request from Chris No.1]
Worker-4 executes [Request from Alice No.2]
Worker-1 executes [Request from Chris No.2]
Worker-0 executes [Request from Alice No.3]
Worker-1 executes [Request from Bobby No.2]
Worker-3 executes [Request from Chris No.3]
Worker-2 executes [Request from Bobby No.3]
Worker-4 executes [Request from Alice No.4]
Worker-0 executes [Request from Alice No.5]
Worker-1 executes [Request from Chris No.4]
Worker-2 executes [Request from Bobby No.4]
Worker-4 executes [Request from Alice No.6]
Worker-3 executes [Request from Chris No.5]
Worker-2 executes [Request from Alice No.7]
Worker-1 executes [Request from Bobby No.5]
Worker-0 executes [Request from Bobby No.6]
Worker-4 executes [Request from Bobby No.7]
Worker-2 executes [Request from Chris No.6]
Worker-0 executes [Request from Bobby No.8]
Worker-0 executes [Request from Alice No.8]
Worker-3 executes [Request from Chris No.7]
Worker-1 executes [Request from Bobby No.9]
Worker-2 executes [Request from Alice No.9]
Worker-4 executes [Request from Bobby No.10]
Worker-0 executes [Request from Alice No.10]
Worker-1 executes [Request from Chris No.8]
Worker-1 executes [Request from Alice No.11]
Worker-3 executes [Request from Alice No.12]
totalRequest: 35
totalExecute: 35
freeMemory: 261135280

*/

