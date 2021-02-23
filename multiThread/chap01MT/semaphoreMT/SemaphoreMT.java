/**
 * @title multiThread / chap01MT / semaphoreMT / SemaphoreMT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content List 1-11 / p75-76 / Semaphore
 *
 * @clsss SemaphoreMT // main()
 * @class BoundedResource, Log // Semphore.acquire(), release()でリソースの増減を計測
 * @class UserThreadSemaphore extends Thread
 *                             // スレッドのコンストラクタ。run(): callResource()の呼び出し。
 *
 * @author shika
 * @date 2021-02-23
 */
package multiThread.chap01MT.semaphoreMT;

public class SemaphoreMT {

    public static void main(String[] args) {
        //3個のリソースを用意
        BoundedResource resource = new BoundedResource(3);//引数 int permit

        //10個のスレッドが利用する
        for (int i = 0; i < 10; i++) {
            new UserThreadSemaphore(resource).start();
        }
    }//main()

}//class

/*
Thread-0: END:   used = 3
Thread-8: BEGIN: used = 3
Thread-5: END:   used = 3
Thread-9: BEGIN: used = 3
Thread-8: END:   used = 3
Thread-9: END:   used = 2
Thread-2: BEGIN: used = 2
Thread-7: END:   used = 2
Thread-8: BEGIN: used = 2
Thread-3: BEGIN: used = 3
Thread-2: END:   used = 3

*/