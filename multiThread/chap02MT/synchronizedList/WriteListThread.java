package multiThread.chap02MT.synchronizedList;

import java.util.List;

public class WriteListThread extends Thread {
    private final List<Integer> list;

    public WriteListThread(List<Integer> list) {
        super("WriteTread");
        this.list = list;
    }

    public void run() {
        for(int i = 0; true; i++) {
            list.add(i);
            list.remove(0);
        }//for loop
    }//run()

}//class
