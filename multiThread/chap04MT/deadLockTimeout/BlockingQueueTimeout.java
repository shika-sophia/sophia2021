/**
 * @title multiThread / chap04MT / deadLockTimeout / BlockingQueueTimeout.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第４章 Balking / List 4-10
 * @author shika
 * @date 2021-03-02
 */
package multiThread.chap04MT.deadLockTimeout;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import multiThread.chap03MT.guardedSuspension.Request;
import multiThread.chap03MT.guardedSuspension.RequestQueue;

public class BlockingQueueTimeout extends RequestQueue {
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
