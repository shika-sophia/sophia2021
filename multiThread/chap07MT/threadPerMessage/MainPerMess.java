/**
 * @title multiThread / chap07MT / threadPerMessage / MainPerMess.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第７章 Thread-Per-Message / List 7-1, 7-2, 7-3
 * @author shika
 * @date 2021-03-10
 */
package multiThread.chap07MT.threadPerMessage;

public class MainPerMess {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        HostPerMess host = new HostPerMess();
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
BCACBABCABACBCAABCACBABCBCABAC
handle(10, A) END
BCBCBCBCBCBCCBBCBCB
C	 handle(20, B) END
CCCCCCCCCC
handle(30, C) END
*/
