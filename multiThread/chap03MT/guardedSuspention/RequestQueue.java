/**
 * @title multiThread / chap03MT / guardedSuspention / RequestQueue.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第３章 GuardedSuspention / List 3-2
 * @author shika
 * @date 2021-02-27
 */
package multiThread.chap03MT.guardedSuspention;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private final Queue<Request> queue
        = new LinkedList<Request>();

    public synchronized Request getRequest() {
        while(queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while

        return queue.remove();
    }//getRequest()

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }//putRequest()

}//class
