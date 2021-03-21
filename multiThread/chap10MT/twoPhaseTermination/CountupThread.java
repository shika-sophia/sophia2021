package multiThread.chap10MT.twoPhaseTermination;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CountupThread extends Thread {
    private long counter = 0; //カウンター変数
    private volatile boolean shutdownRequest = false;
                             //終了要求を出されたら true

    //終了要求を受けるメソッド
    public void shutdownRequest() {
        shutdownRequest = true;
        interrupt();
    }//shutdownRequest()

    //getter 終了要求を出されたか
    public boolean isShutdownRequest() {
        return shutdownRequest;
    }

    //作業前チェック
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
    }

    //作業
    protected void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }//doWork()

    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);

        String path =
            "src/multiThread/chap10MT/twoPhaseTermination/counter.txt";

        FileWriter writer = null;
        try {
            writer = new FileWriter(path, true);
            writer.write(String.valueOf(counter) + " ");
            System.out.printf("%s: fileWrite to %s \n",
                Thread.currentThread().getName(), path);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//doShutdown()
}//class
