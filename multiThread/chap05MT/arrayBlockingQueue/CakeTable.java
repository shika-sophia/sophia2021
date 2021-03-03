package multiThread.chap05MT.arrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class CakeTable extends ArrayBlockingQueue<String> {

    public CakeTable(int BOUND) {
        super(BOUND);
    }

    //ケーキを置く
    public void put(String cake)
            throws InterruptedException {
        System.out.println(
            Thread.currentThread().getName() + " puts " + cake);
        super.put(cake);
    }//put()

    public String take()
            throws InterruptedException {
        String cake = super.take();
        System.out.println(
            Thread.currentThread().getName() + " takes " + cake);

        return cake;
    }//take()

}//class
