/**
 * @title multiThread / chap01MT / mutex / MainMutex.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content List 1-17 / p84 / mutex = mutual exclusion (相互排他)
 * @content 練習問題 1-7 / synchronizedを使わずに排他制御せよ。
 *
 * @clsss MainMutex // main()
 * @class GateMutex      // Gateクラスに mutex.lock(),unlock()を付け、synchronizedを外す
 * @class UserMutex extends Thread
 *                       // スレッドのコンストラクタ。run(): pass()の呼び出し。
 *        ---- Mutex ----
 * @class MutexSemaphore // Semphore.acquire(), release()でリソースの増減を計測
 * @class MutexWait      // List A1-9 / boolean busy, wait(), notifyAll()
 * @class MutexWaitOwner // List A1-10 / lockCount, owner, assert
 * @class MutexReent extends ReentrantLock // list A1-11
 *
 * @author shika
 * @date 2021-02-23
 */
package multiThread.chap01MT.mutex;

public class MainMutex extends Thread {

    public static void main(String[] args) {
        var gate = new GateMutex();
        new UserMutex(gate, "Alice", "Alaska").start();
        new UserMutex(gate, "Bobby", "Brazil").start();
        new UserMutex(gate, "Chris", "Canada").start();
    }//main()
}//class

/*
  :
Thread-1: BEGIN: used = 3
Thread-1: END:   used = 2
Thread-1: BEGIN: used = 3
Thread-0: BEGIN: used = 2
Thread-0: END:   used = 1
Thread-0: BEGIN: used = 2
Thread-0: END:   used = 1
Thread-0: BEGIN: used = 2
Thread-0: END:   used = 1
Thread-2: BEGIN: used = 2
Thread-2: END:   used = 1
  :
(BROKENは起こらず)
*/
/*
【解答１】 解説 p478 / List A1-9
boolean busyをフィールドとし
lock()で while(busy){ wait(); }; busy = true;
unLock()で busy = false; notifyAll();

この方法だと起こる制約
〔制約１〕「再入ができない」「reentrantではない」
    同じクラスが２度続けて lock()を呼び出すと、
    先ほどの通過で trueになっているので wait()で待たされる

〔制約２〕誰でも unlock()できる
  lock()を呼び出していないスレッドでも、
  unlock()を呼び出すことができてしまう。

【解答２】 List A1-10
  上記の制約の解決法として、
  lockCountフィールド、ownerフィールドを設ける。
  assert で意図しない値を検出。

【解答３】 List A1-11(下記)
java.util.concurrent.locks.ReentrantLockクラスは
解答２の機能を全て含んでいるので Mutexに extendsするだけでよい。

〔List A1-11〕
import java.util.concurrent.locks.ReentrantLock;

public class Mutex extends ReentrantLock { }

*/