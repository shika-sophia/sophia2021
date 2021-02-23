package multiThread.chap01MT.semaphoreMT;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BoundedResource {
    private final Semaphore semaphore;
    private final int permit; //リソース数
    private final static Random rdm = new Random(314159);

    public BoundedResource(int permit) {
        this.semaphore = new Semaphore(permit);
        this.permit = permit;
    }

    //リソースの要求
    public void callResouce() throws InterruptedException {
        semaphore.acquire();

        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }//use()

    //リソースの実際の使用(処理に見立てた sleep())
    protected void doUse() throws InterruptedException {
        Log.println("BEGIN: used = "
            +(permit - semaphore.availablePermits()));

        Thread.sleep(rdm.nextInt(500));

        Log.println("END:   used = "
            +(permit - semaphore.availablePermits()));
    }//doUse()
}//class BoundedResource

class Log {
    public static void println(String str) {
        System.out.println(
            Thread.currentThread().getName() + ": " + str);
    }
}//class Log
