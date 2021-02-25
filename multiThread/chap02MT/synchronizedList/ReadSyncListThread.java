package multiThread.chap02MT.synchronizedList;

import java.util.List;

public class ReadSyncListThread extends Thread {
    private final List<Integer> list;

    public ReadSyncListThread(List<Integer> list) {
        super("ReadTread");
        this.list = list;
    }

    public void run() {
        while(true) {
            synchronized(list) {
                int count = 0;
                for(int n : list) {
                    System.out.print(n + " ");

                    if (count % 10 == 0 && count != 0) {
                        System.out.println();
                    }
                    count++;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }//for list
            }//synchronized(list)
        }//while loop
    }//run()

}//class
