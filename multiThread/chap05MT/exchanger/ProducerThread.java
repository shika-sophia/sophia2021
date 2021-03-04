package multiThread.chap05MT.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ProducerThread extends Thread {
    private final Exchanger<char[]> exchanger;
    private char[] buffer = null;
    private char index = 0;
    private final Random random;

    public ProducerThread(
            Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super("ProducerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while(true) {
                //bufferに文字を格納
                for(int i = 0; i < buffer.length; i++) {
                    buffer[i] = nextChar();
                    System.out.println(
                        getName() + ": " + buffer[i] + " -> ");
                }//for

                //bufferを交換
                System.out.println(getName() + ": BEFORE exchange()");
                buffer = exchanger.exchange(buffer);
                System.out.println(getName() + ": AFTER  exchange()");
            }//while loop
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() throws InterruptedException {
        char c = (char)('A' + index % 26); //alphabet 26文字の循環
        index++;
        sleep(random.nextInt(1000));
        return c;
    }//nextChar()
}//class
