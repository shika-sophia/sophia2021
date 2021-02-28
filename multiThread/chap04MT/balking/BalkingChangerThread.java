package multiThread.chap04MT.balking;

import java.io.IOException;
import java.util.Random;

public class BalkingChangerThread extends Thread {
    private final BalkingData data;
    private final Random random = new Random();

    public BalkingChangerThread(String name, BalkingData data) {
        super(name);
        this.data = data;
    }

    //====== データを変更・保存する ======
    public void run() {
        try {
            for(int i = 0; true; i++) {
                data.change("No." + i);  //データを変更する
                Thread.sleep(random.nextInt(1000)); //仕事のつもり
                data.save();             //明示的に保存する
            }//for
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//run()
}//class
