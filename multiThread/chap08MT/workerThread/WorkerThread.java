package multiThread.chap08MT.workerThread;

public class WorkerThread extends Thread {
    private final ChannelWork channel;
    private volatile boolean terminated = false;

    public WorkerThread(String name, ChannelWork channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            while(!terminated) {

                try {
                    RequestWork request = channel.takeRequest();
                    request.execute();

                } catch (InterruptedException e) {
                e.printStackTrace();
                }
            }//while
        } finally {
            System.out.println(
                Thread.currentThread().getName() + " is terminated.");
        }
    }//run()

    public void stopThread() {
        terminated = true;
        interrupt();
    }
}//class
