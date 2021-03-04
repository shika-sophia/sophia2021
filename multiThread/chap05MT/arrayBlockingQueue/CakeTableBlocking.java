package multiThread.chap05MT.arrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import multiThread.chap05MT.producerConsumer.CakeTable;

public class CakeTableBlocking extends CakeTable {
    @SuppressWarnings("rawtypes")
    private final BlockingQueue queue;

    public CakeTableBlocking(int BOUND) {
        super(BOUND);
        this.queue = new ArrayBlockingQueue<String>(BOUND);
    }

    //ケーキを置く
    @SuppressWarnings("unchecked")
    public void put(String cake)
            throws InterruptedException {
        System.out.println(
            Thread.currentThread().getName() + " puts " + cake);
        queue.put(cake);
    }//put()

    public String take()
            throws InterruptedException {
        String cake = (String) queue.take();
        System.out.println(
            Thread.currentThread().getName() + " takes " + cake);

        return cake;
    }//take()

}//class
