package multiThread.chap10MT.gracefulThread;

public class GracefulThread extends Thread {
    private volatile boolean shutdownRequest = false;

    public final void shutdownRequest() {
        shutdownRequest = true;
        interrupt();
    }

    public final boolean isShutdownRequest() {
        return shutdownRequest;
    }

    public final void run() {
        try {
            while(!isShutdownRequest()) {
                doWork();
            }//while

        } catch (InterruptedException e) {
            //e.printStackTrace();
        } finally {
            doShutdown();
        }
    }//run()

    protected void doWork() throws InterruptedException { }

    protected void doShutdown() { }

}//class
