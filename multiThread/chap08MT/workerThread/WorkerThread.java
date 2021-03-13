package multiThread.chap08MT.workerThread;

public class WorkerThread extends Thread {
    private final ChannelWork channel;

    public WorkerThread(String name, ChannelWork channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        while(true) {
            RequestWork request = channel.takeRequest();
            request.execute();
        }
    }
}//class
