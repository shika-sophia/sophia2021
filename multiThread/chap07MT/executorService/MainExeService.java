/**
 * @title multiThread / chap07MT / executorService / MainExeService.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第７章 Thread-Per-Message / List 7-11
 * @author shika
 * @date 2021-03-10
 */
package multiThread.chap07MT.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import multiThread.chap07MT.executorInterface.HostIExecutor;
import multiThread.chap07MT.threadPerMessage.HostPerMess;

public class MainExeService {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        ExecutorService exeService
            = Executors.newCachedThreadPool();

        HostPerMess host = new HostIExecutor(exeService);

        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');

        } finally {
            exeService.shutdown();
            System.out.println("main: END");
        }
    }//main()

}//class

/*
main: BEGIN
     request(10, A) BEGIN
     request(10, A) END
     request(20, B) BEGIN
     handle(10, A) BEGIN
     request(20, B) END
     handle(20, B) BEGIN
     request(30, C) BEGIN
     request(30, C) END
main: END
     handle(30, C) BEGIN
CABCBABCABACCBACBACBABACCABA
BC	 handle(10, A) END
BCCBCBBCCBCBCBCBBCB
     handle(20, B) END
CCCCCCCCCCC
     handle(30, C) END

*/
