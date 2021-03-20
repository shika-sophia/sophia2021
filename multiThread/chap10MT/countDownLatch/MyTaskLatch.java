package multiThread.chap10MT.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyTaskLatch implements Runnable {
    private final CountDownLatch latch;
    private final int context;
    private final Random random = new Random(314159);

    public MyTaskLatch(CountDownLatch latch, int context) {
        this.latch = latch;
        this.context = context;
    }

    @Override
    public void run() {
        doTask();
        latch.countDown();
    }//run()

    protected void doTask() {
        String thName = Thread.currentThread().getName();
        System.out.printf(
            "%s: doTask() BEGIN %d \n", thName, context);

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf(
                "%s: doTask() END %d \n", thName, context);
        }
    }//doTask()

}//class
