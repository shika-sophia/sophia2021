package multiThread.chap05MT.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ConsumerThread extends Thread {
    private final Exchanger<char[]> exchanger;
    private char[] buffer = null;
    private final Random random;

    public ConsumerThread(
            Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super("ConsumerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while(true) {
                //bufferを交換
                System.out.println(getName() + ": BEFORE exchange()");
                buffer = exchanger.exchange(buffer);
                System.out.println(getName() + ": AFTER  exchange()");

                //bufferから 0文字目を取り出す
                for(int i = 0; i < buffer.length; i++) {
                    System.out.println(
                        getName() + ": -> " + buffer[i]);
                    sleep(random.nextInt(1000));
                }//for
            }//while loop
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
