package multiThread.chap10MT.hanoiTower;

public class HanoiThread extends Thread {
    private volatile boolean shutdownRequest = false; //終了要求
    private volatile long requestTime = 0L;

    //終了要求
    public void shutdownRequest() {
        requestTime = System.currentTimeMillis();
        shutdownRequest = true;
        interrupt();
    }

    //終了要求が出されたどうかのテスト
    public boolean isShutdownRequest() {
        return shutdownRequest;
    }

    //動作
    public void run() {
        try {
            for (int level = 0; !isShutdownRequest(); level++) {
                System.out.printf("==== Level %d ====\n", level);
                doWork(level, 'A', 'B', 'C');
                System.out.println();

            }//for
        } catch (InterruptedException e) {

        } finally {
            doShutdown();
        }
    }//run()

    private void doWork(int level, char posA, char posB, char posC)
            throws InterruptedException {
        if(level > 0 && !isShutdownRequest()) {
            doWork(level - 1, posA, posC, posB);
            System.out.printf("%s->%s ", posA, posB);
            doWork(level - 1, posC, posB, posA);
        }
    }//doWork()

    private void doShutdown() {
        long shutdownTime = System.currentTimeMillis();
        long costTime = shutdownTime - requestTime;
        System.out.printf("doShutdown(): Latency = %d msec. \n", costTime);
    }//doShutdown()
}//class
