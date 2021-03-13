/**
 * @title multiThread / chap08MT / workerThread / MainClientWorker.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第８章 WorkerThread / List 8-1, 8-2, 8-3, 8-4, 8-5
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
    }//main()

}//class

/*
Worker-4 executes [Request from Bobby No.0]
Worker-1 executes [Request from Chris No.0]
Worker-0 executes [Request from Alice No.0]
Worker-3 executes [Request from Bobby No.1]
Worker-1 executes [Request from Alice No.1]
Worker-2 executes [Request from Alice No.2]
Worker-3 executes [Request from Chris No.1]
Worker-1 executes [Request from Bobby No.2]
Worker-0 executes [Request from Chris No.2]
Worker-4 executes [Request from Bobby No.3]
Worker-3 executes [Request from Bobby No.4]
Worker-2 executes [Request from Alice No.3]
Worker-0 executes [Request from Bobby No.5]
Worker-1 executes [Request from Chris No.3]
Worker-2 executes [Request from Bobby No.6]
Worker-3 executes [Request from Alice No.4]
Worker-1 executes [Request from Bobby No.7]
Worker-0 executes [Request from Alice No.5]
Worker-2 executes [Request from Chris No.4]
Worker-4 executes [Request from Alice No.6]
Worker-1 executes [Request from Bobby No.8]
Worker-2 executes [Request from Chris No.5]
Worker-3 executes [Request from Alice No.7]
Worker-0 executes [Request from Chris No.6]
Worker-2 executes [Request from Bobby No.9]
Worker-3 executes [Request from Alice No.8]
Worker-0 executes [Request from Chris No.7]
Worker-4 executes [Request from Bobby No.10]

*/

