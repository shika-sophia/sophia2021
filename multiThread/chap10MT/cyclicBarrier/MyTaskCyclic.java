package multiThread.chap10MT.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyTaskCyclic implements Runnable {
    private final int PHASE = 5;
    private final CyclicBarrier cyclic;
    private final CountDownLatch latch;
    private final int context;
    private final Random random = new Random(314159);

    public MyTaskCyclic(
            CyclicBarrier cyclic, CountDownLatch latch, int context) {
        this.cyclic = cyclic;
        this.latch = latch;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < PHASE; i++) {
                doPhase();
                cyclic.await();
            }//for
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }//run()

    protected void doPhase() {
        String thName = Thread.currentThread().getName();
        System.out.printf(
            "%s: doPhase() BEGIN %d \n", thName, context);

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf(
                "%s: doPhase() END %d \n", thName, context);
        }
    }//doPhase()

}//class
