/**
 * @title multiThread / chap04MT / deadLockTimeout / RequestQueueTimeout.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第４章 Balking / List 4-9
 * @author shika
 * @date 2021-03-02
 */
package multiThread.chap04MT.deadLockTimeout;

import java.util.LinkedList;
import java.util.Queue;

import multiThread.chap03MT.guardedSuspension.Request;
import multiThread.chap03MT.guardedSuspension.RequestQueue;

public class RequestQueueTimeout extends RequestQueue {
    private final Queue<Request> queue
        = new LinkedList<Request>();
    private final long timeout = 30000L;

    public synchronized Request getRequest() {
        while(queue.peek() == null) {
            System.out.println(
                Thread.currentThread().getName() + ": wait() begin" + queue);
            try {
                waitTimeout(timeout);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                Thread.currentThread().getName() + ": wait() end" + queue);
        }//while

        return queue.remove();
    }//getRequest()

    private void waitTimeout(long timeout)
            throws InterruptedException {
        long rest = 0L;
        while(rest < timeout) {
            long start = System.currentTimeMillis();
            wait(timeout - rest);
            long end = System.currentTimeMillis();
            rest = end - start;
        }//while()

        try {
            throw new LivenessException(
                "wait()が  " + rest + " ミリ秒経過しました。");
        } catch (LivenessException e) {
            notifyAll();
        }
    }//waitTimeout()

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        System.out.println(
            Thread.currentThread().getName() + ": notifyAll() begin" + queue);
        notifyAll();
        System.out.println(
            Thread.currentThread().getName() + ": notifyAll() end" + queue);
    }//putRequest()

}//class
