/**
 * @title multiThread / chap08MT / threadPerMessage / MainPerMess.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第８章 WorkerThread / 練習問題 8-2, 8-3
 * @refernce ◆Javaで空きメモリの量を簡単に調べる
 *           https://qiita.com/arai-wa/items/482091c6a8d2ade6f5ba
 *           Runtime.getRuntime().freeMemory()
 * @author shika
 * @date 2021-03-15
 */
 /* Appendix 5秒間のスループット(=単位時間当たりの処理量)の比較
  * ====== WorkerThread Pattern / MainClientWorker ======
  * totalRequest: 37         //全リクエスト数(= WorkerThread: 5)
  * totalExecute: 37         //全実行数
  * freeMemory: 261,638,616  //メモリ空き容量
  *
  * ====== Thread-Per-Message Pattern / MainPerMess ======
  * totalRequest: 30         //全リクエスト数(= WorkerThread: 30)
  * totalExecute: 30         //全実行数
  * freeMemory: 258,492,888  //メモリ空き容量
  */
package multiThread.chap08MT.threadPerMessage;

import multiThread.chap08MT.workerThread.ChannelWork;
import multiThread.chap08MT.workerThread.ClientThread;

public class MainPerMess {

    public static void main(String[] args) {
        ChannelWork channel = new ChannelPerMess(5);
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
[Request from Chris No.0] executes [Request from Alice No.0]
[Request from Bobby No.0] executes [Request from Bobby No.0]
[Request from Alice No.0] executes [Request from Chris No.0]
[Request from Bobby No.0] executes [Request from Chris No.1]
[Request from Chris No.1] executes [Request from Bobby No.1]
[Request from Chris No.0] executes [Request from Alice No.1]
[Request from Bobby No.0] executes [Request from Chris No.2]
[Request from Alice No.1] executes [Request from Chris No.3]
[Request from Bobby No.0] executes [Request from Chris No.4]
[Request from Chris No.3] executes [Request from Alice No.2]
[Request from Alice No.1] executes [Request from Bobby No.2]
[Request from Bobby No.1] executes [Request from Alice No.3]
[Request from Alice No.1] executes [Request from Alice No.4]
[Request from Bobby No.0] executes [Request from Chris No.5]
[Request from Bobby No.1] executes [Request from Bobby No.3]
[Request from Chris No.4] executes [Request from Alice No.5]
[Request from Alice No.1] executes [Request from Chris No.6]
[Request from Alice No.2] executes [Request from Bobby No.4]
[Request from Chris No.3] executes [Request from Alice No.6]
[Request from Alice No.0] executes [Request from Alice No.7]
[Request from Alice No.5] executes [Request from Chris No.7]
[Request from Chris No.3] executes [Request from Alice No.8]
[Request from Alice No.1] executes [Request from Bobby No.5]
[Request from Alice No.0] executes [Request from Bobby No.6]
[Request from Chris No.4] executes [Request from Bobby No.7]
[Request from Alice No.2] executes [Request from Bobby No.8]
[Request from Alice No.1] executes [Request from Alice No.9]
[Request from Chris No.7] executes [Request from Chris No.8]
totalRequest: 30
totalExecute: 30
freeMemory: 258,492,888

*/

