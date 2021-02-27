/**
 * @title multiThread / chap03MT / blockingQueue / MainCientServer.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第３章 GuardedSuspention / List 3-6
 * @content BlockingQueueで synchronizedと同様の動作するかを検証。
 * @author shika
 * @date 2021-02-27
 */
package multiThread.chap03MT.blockingQueue;

import multiThread.chap03MT.guardedSuspention.ClientThread;
import multiThread.chap03MT.guardedSuspention.RequestQueue;
import multiThread.chap03MT.guardedSuspention.ServerThread;

public class MainBlockClientServer {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestBlockingQueue();
        new ClientThread(requestQueue, "Client", 3141492L).start();
        new ServerThread(requestQueue, "Server", 6535897L).start();
    }//main()

}//class

/*
//====== Test BlockingQueue ======
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
Client requests [Request: No.6]
Server handles [Request: No.6]
Client requests [Request: No.7]
Server handles [Request: No.7]
Client requests [Request: No.8]
Server handles [Request: No.8]
Client requests [Request: No.9]
Client requests [Request: No.10]
Server handles [Request: No.9]

*/