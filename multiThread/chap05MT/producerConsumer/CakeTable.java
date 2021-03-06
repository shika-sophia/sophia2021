package multiThread.chap05MT.producerConsumer;

public class CakeTable {
    protected final String[] buffer;//テーブルに置いているケーキ
    protected final int BOUND;//bufferの上限 = buffer.length
    protected int count;      //buffer内の cake数
    protected int head;       //次に takeする index
    protected int tail;       //次に putする index

    public CakeTable(int BOUND) {
        this.buffer = new String[BOUND];
        this.BOUND = BOUND;
        this.count = 0;
        this.head = 0;
        this.tail = 0;
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
        notifyAll();
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
        notifyAll();
        System.out.println(
            Thread.currentThread().getName() + " takes " + cake);

        return cake;
    }//take()

    private void printWaitStatus(String status) {
        System.out.println(Thread.currentThread().getName() + status);
    }//printThread

}//class
