package multiThread.chap06MT.readWriteLock;

import org.apache.catalina.tribes.util.Arrays;

public class ReadThread extends Thread {
    private final ReadWriteData data;

    public ReadThread(ReadWriteData data) {
        this.data = data;
    }

    public void run() {
        try {
            while(true) {
                String[] readBuffer = data.read();
                System.out.println(
                    getName() + " reads " + Arrays.toString(readBuffer));
            }//while loop
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
