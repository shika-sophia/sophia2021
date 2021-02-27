/**
 * @title multiThread / chap03MT / guardedSuspention / MainCientServer.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 *
 * @note ◆Random(seed): long seed値を指定すると毎回同じ順序の乱数を生成。
 * @reference ＊Javaで毎回完全に異なる乱数を取得する方法
 *                  ～ long seed = System.currentTimeMillis();
 *                  ～ long seed = Runtime.getRuntime().freeMemory();
 *             https://npnl.hatenablog.jp/entry/20090116/1232120896
 *
 * @content 第３章 GuardedSuspention / List 3-5
 * @author shika
 * @date 2021-02-27
 */
package multiThread.chap03MT.guardedSuspention;

public class MainClientServer {

    public static void main(String[] args) {
        var requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Client", 3141492L).start();
        new ServerThread(requestQueue, "Server", 6535897L).start();
    }//main()

}//class

/*
Alice requests [Request: No.0]
Bobby handles [Request: No.0]
Alice requests [Request: No.1]
Alice requests [Request: No.2]
Bobby handles [Request: No.1]
Alice requests [Request: No.3]
Bobby handles [Request: No.2]
Bobby handles [Request: No.3]
Alice requests [Request: No.4]
Bobby handles [Request: No.4]
Alice requests [Request: No.5]
Bobby handles [Request: No.5]
Alice requests [Request: No.6]
Bobby handles [Request: No.6]
Alice requests [Request: No.7]
Bobby handles [Request: No.7]
Alice requests [Request: No.8]
Bobby handles [Request: No.8]
Alice requests [Request: No.9]
Alice requests [Request: No.10]
Bobby handles [Request: No.9]

＊Aliceが requestし、 Bobbyが受け取ってロックを解放する。
Client, Severにしたほうが判りやすいと思う。

Client requests [Request: No.0]
Server handles [Request: No.0]
Client requests [Request: No.1]
Client requests [Request: No.2]
Server handles [Request: No.1]
Client requests [Request: No.3]
Server handles [Request: No.2]
Server handles [Request: No.3]
Client requests [Request: No.4]
Server handles [Request: No.4]
Client requests [Request: No.5]
Server handles [Request: No.5]

*/