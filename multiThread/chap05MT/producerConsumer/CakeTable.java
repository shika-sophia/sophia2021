package multiThread.chap05MT.producerConsumer;

public class CakeTable {
    private final String[] buffer;//テーブルに置いているケーキ
    private final int BOUND;//bufferの上限 = buffer.length
    private int count;      //buffer内の cake数
    private int head;       //次に takeする index
    private int tail;       //次に putする index

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
            wait();
        }//while

        System.out.println(
            Thread.currentThread().getName() + " puts " + cake);
        buffer[tail] = cake;
        tail = (tail + 1) % BOUND;
        count++;
        notifyAll();
    }//put()

    public synchronized String take()
            throws InterruptedException {
        while(count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % BOUND;
        count--;
        notifyAll();
        System.out.println(
            Thread.currentThread().getName() + " takes " + cake);

        return cake;
    }//take()

}//class
