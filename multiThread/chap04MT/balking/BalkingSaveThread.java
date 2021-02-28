package multiThread.chap04MT.balking;

import java.io.IOException;

public class BalkingSaveThread extends Thread {
    private final BalkingData data;

    public BalkingSaveThread(String name, BalkingData data) {
        super(name);
        this.data = data;
    }

    //====== 定期的にデータを保存 ======
    public void run() {
        try {
            while(true) {
                data.save();
                Thread.sleep(1000);
            }//while loop

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
