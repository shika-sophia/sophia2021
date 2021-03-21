package multiThread.chap10MT.noFlagTermination;

public class CountupNoFlagThread extends Thread {
    private long counter = 0; //カウンター変数

    //終了要求を受けるメソッド
    public void shutdownRequest() {
        interrupt();
    }//shutdownRequest()

    //作業前チェック
    public final void run() {
        try {
            while(!isInterrupted()) {
                doWork();
            }//while
        } catch (InterruptedException e) {
            //e.printStackTrace();
        } finally {
            doShutdown();
        }
    }

    //作業
    protected void doWork() throws InterruptedException {
        var actCount = new Runnable() {
            public void run() {
                for(int i = 0; i < 100; i++) {
                    System.out.println("doWork(): counter = " + counter);
                    counter++;
                }//for
            }//run()
        };

        new Thread(actCount).start();
        new Thread(actCount).start();
        new Thread(actCount).start();
        new Thread(actCount).start();
        new Thread(actCount).start();
    }//doWork()

    private void doShutdown() {
        System.out.println("doShutdown(): counter = " + counter);
    }//doShutdown()
}//class
