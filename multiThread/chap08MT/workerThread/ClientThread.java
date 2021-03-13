package multiThread.chap08MT.workerThread;

import java.util.Random;

public class ClientThread extends Thread {
    private final ChannelWork channel;
    private static final Random random = new Random();

    public ClientThread(String name, ChannelWork channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            for(int i = 0; true; i++) {
                RequestWork request = new RequestWork(getName(), i);
                channel.putRequest(request);

                Thread.sleep(random.nextInt(1000));
            }//for
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
