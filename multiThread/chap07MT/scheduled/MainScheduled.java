/**
 * @title multiThread / chap07MT / scheduled / MainScheduled.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第７章 Thread-Per-Message / List 7-11
 * @author shika
 * @date 2021-03-10
 */
package multiThread.chap07MT.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import multiThread.chap07MT.threadPerMessage.HostPerMess;

public class MainScheduled {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        ScheduledExecutorService scheduled
            = Executors.newScheduledThreadPool(5);

        HostPerMess host = new HostScheduled(scheduled);

        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');

        } finally {
            scheduled.shutdown();
            System.out.println("main: END");
        }
    }//main()

}//class

/*
main: BEGIN
     request(10, A) BEGIN
     request(10, A) END
     request(20, B) BEGIN
     request(20, B) END
     request(30, C) BEGIN
     request(30, C) END
main: END
     handle(10, A) BEGIN
     handle(20, B) BEGIN
     handle(30, C) BEGIN
BACBCACBACABBACBACBCABACCABACB
     handle(10, A) END
CBCBBCCBBCBCCBBCBCB
     handle(20, B) END
CCCCCCCCCCC
     handle(30, C) END

*/
