/**
 * @title multiThread / chap03MT / blockingQueue / RequestBlockingQueue.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第３章 GuardedSuspension / List 3-6
 * @content BlockingQueueで synchronizedと同様の動作するかを検証。
 * @author shika
 * @date 2021-02-27
 */
package multiThread.chap03MT.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import multiThread.chap03MT.guardedSuspension.Request;
import multiThread.chap03MT.guardedSuspension.RequestQueue;

public class RequestBlockingQueue extends RequestQueue {
    private final BlockingQueue<Request> queue
        = new LinkedBlockingQueue<Request>();

    @Override
    public Request getRequest() {
        Request req = null;
        try {
            req = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return req;
    }//getRequest()

    @Override
    public void putRequest(Request request) {
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//putRequest()

}//class
