package multiThread.chap10MT.swingExeCancel;

import multiThread.chap10MT.gracefulThread.GracefulThread;

public class ServiceAnsThread extends GracefulThread {
    private final int MAX = 50;
    private volatile int count = 0;

    @Override
    protected void doWork() throws InterruptedException {
        System.out.print(".");
        Thread.sleep(100);
        count++;

        if (count >= MAX) {
            shutdownRequest();
        }
    }//doWork()

    @Override
    protected void doShutdown() {
        System.out.println(" done/");
    }//doShutdown()
}//class

/*
//====== doWork() Stream version ======
Stream.generate(() -> ".").limit(MAX)
    .peek(s -> count++)
    .peek(s -> {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    })
    .peek(s -> {
        if(count >= 50) {
            shutdownRequest();
        }
    })
    .forEach(System.out::print);
*/