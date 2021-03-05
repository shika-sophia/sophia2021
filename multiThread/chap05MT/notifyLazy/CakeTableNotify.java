package multiThread.chap05MT.notifyLazy;

import multiThread.chap05MT.producerConsumer.CakeTable;

public class CakeTableNotify extends CakeTable {

    public CakeTableNotify(int BOUND) {
        super(BOUND);

    }
    //ケーキを置く
    public synchronized void put(String cake)
            throws InterruptedException {

        while(count >= BOUND) {
//            clearCake();
            printWaitStatus(" waits put()");
            wait();
            printWaitStatus(" notified put()");
        }//while

        System.out.println(
            Thread.currentThread().getName() + " puts " + cake);
        buffer[tail] = cake;
        tail = (tail + 1) % BOUND;
        count++;
        //notifyAll() -> notify()に変更
        notify();
    }//put()

//    private void clearCake() {
//        for(int i = 0; i < buffer.length; i++) {
//            buffer[i] = null;
//        }
//        count = 0;
//        System.out.println(
//            Thread.currentThread().getName() + " cleared All cake.");
//        notifyAll();
//    }//clearCake()

    public synchronized String take()
            throws InterruptedException {
        while(count <= 0) {
            printWaitStatus(" waits take()");
            wait();
            printWaitStatus(" notified take()");
        }
        String cake = buffer[head];
        head = (head + 1) % BOUND;
        count--;
        //notifyAll() -> notify()に変更
        notify();
        System.out.println(
            Thread.currentThread().getName() + " takes " + cake);

        return cake;
    }//take()

    private void printWaitStatus(String status) {
        System.out.println(Thread.currentThread().getName() + status);
    }//printThread

}//class
