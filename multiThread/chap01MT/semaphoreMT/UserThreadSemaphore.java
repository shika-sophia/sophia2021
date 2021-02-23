package multiThread.chap01MT.semaphoreMT;

import java.util.Random;

public class UserThreadSemaphore extends Thread {
    private final static Random rdm = new Random(26535);
    private final BoundedResource resource;

    public UserThreadSemaphore(BoundedResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            while(true) {
                resource.callResouce();
                Thread.sleep(rdm.nextInt(3000));
            }//while

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
