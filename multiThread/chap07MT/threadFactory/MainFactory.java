/**
 * @title multiThread / chap07MT / threadFactory / MainFactory.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第７章 Thread-Per-Message / List 7-6, 7-7
 * @author shika
 * @date 2021-03-10
 */
package multiThread.chap07MT.threadFactory;

import java.util.concurrent.ThreadFactory;

import multiThread.chap07MT.threadPerMessage.HostPerMess;

public class MainFactory {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        HostPerMess host = new HostFactory(
            new ThreadFactory() {
                public Thread newThread(Runnable r) {
                    return new Thread(r);
                }
            });
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main: END");
    }//main()

}//class

/*
main: BEGIN
     request(10, A) BEGIN
     request(10, A) END
     request(20, B) BEGIN
     handle(10, A) BEGIN
     request(20, B) END
     request(30, C) BEGIN
     handle(20, B) BEGIN
     request(30, C) END
main: END
     handle(30, C) BEGIN
CBABCABACCBACABCABBCACABCABABC
     handle(10, A) END
BCBCCBBCCBCBBCCBCBCB
     handle(20, B) END
CCCCCCCCCC
     handle(30, C) END

*/
