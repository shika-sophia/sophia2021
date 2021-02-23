package multiThread.chap01MT.mutex;

import java.util.concurrent.Semaphore;

public class MutexSemaphore {
    private final Semaphore semaphore;
    private final int permit; //リソース数

    public MutexSemaphore(int permit) {
        this.semaphore = new Semaphore(permit);
        this.permit = permit;
    }

    public void lock() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()
                + ": BEGIN: used = "
                + (permit - semaphore.availablePermits()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//lock()

    public void unlock() {
        semaphore.release();
        System.out.println(Thread.currentThread().getName()
            + ": END:   used = "
            + (permit - semaphore.availablePermits()));
    }//unlock()

}//class
