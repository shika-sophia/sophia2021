/**
 * @title multiThread / chap07MT / threadPerMessage / MainOnly.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第７章 Thread-Per-Message / 練習問題 7-2
 * @author shika
 * @date 2021-03-10
 */

package multiThread.chap07MT.threadMainOnly;

import multiThread.chap07MT.threadPerMessage.HostPerMess;

public class MainOnly {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        HostPerMess host = new HostMainOnly();
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main: END");
    }//main()

}//class

/*
main: BEGIN
     request(10, A) BEGIN
     handle(10, A) BEGIN
AAAAAAAAAA
     handle(10, A) END
     request(10, A) END
     request(20, B) BEGIN
     handle(20, B) BEGIN
BBBBBBBBBBBBBBBBBBBB
     handle(20, B) END
     request(20, B) END
     request(30, C) BEGIN
     handle(30, C) BEGIN
CCCCCCCCCCCCCCCCCCCCCCCCCCCCCC
     handle(30, C) END
     request(30, C) END
main: END

【考察】 request()は handle()が完了してから戻ってきて、次の request()へ
他スレッドの干渉がないので、文字は同じものだけ表示。
とても遅い。
requst()の応答性は向上しないまま。(練習問題 7-3も同様)
*/