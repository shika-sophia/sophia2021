package multiThread.chap08MT.workerThread;

import java.util.Random;

public class ClientThread extends Thread {
    private final ChannelWork channel;
    private static final Random random = new Random();
    private volatile boolean terminated = false;

    public ClientThread(String name, ChannelWork channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            for(int i = 0; !terminated; i++) {
                RequestWork request = new RequestWork(getName(), i);
                channel.putRequest(request);

                Thread.sleep(random.nextInt(1000));
            }//for
        } catch (InterruptedException e) {
            terminated = true;
            e.printStackTrace();
        }
    }//run()

    public void stopThread() {
        terminated = true;
        this.interrupt();
    }
}//class
