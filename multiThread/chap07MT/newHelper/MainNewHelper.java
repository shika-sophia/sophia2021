/**
 * @title multiThread / chap07MT / threadPerMessage / MainNewHelper.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第７章 Thread-Per-Message / 練習問題 7-4
 * @author shika
 * @date 2021-03-10
 */
package multiThread.chap07MT.newHelper;

import multiThread.chap07MT.threadPerMessage.HostPerMess;

public class MainNewHelper {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        HostPerMess host = new HostNewHelper();
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
     handle(30, C) BEGIN
main: END
BCAABCACBACBCBABCABACCABCABBA
C	 handle(10, A) END
CBCBBCCBBCBCCBBCBCB
     handle(20, B) END
CCCCCCCCCCC
     handle(30, C) END

*/
