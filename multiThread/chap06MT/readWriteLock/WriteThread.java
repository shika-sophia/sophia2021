package multiThread.chap06MT.readWriteLock;

import java.util.Random;

public class WriteThread extends Thread {
    private static final Random random = new Random();
    private final ReadWriteData data;
    private final String filter;
    private int index = 0;

    public WriteThread(ReadWriteData data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    public void run() {
        try {
            while(true) {
                String str = nextStr();
                data.write(str);
                Thread.sleep(random.nextInt(3000));
            }//while loop
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }//run()

    private String nextStr() {
        char c = filter.charAt(index);
        index = ++index % filter.length();

        return String.valueOf(c);
    }//nextStr()

}//class
