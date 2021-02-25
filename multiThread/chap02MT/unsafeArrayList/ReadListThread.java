package multiThread.chap02MT.unsafeArrayList;

import java.util.List;

public class ReadListThread extends Thread {
    private final List<Integer> list;

    public ReadListThread(List<Integer> list) {
        super("ReadTread");
        this.list = list;
    }

    public void run() {
        while(true) {
            for(int n : list) {
                System.out.print(n + " ");

                if (n % 20 == 0 && n != 0) {
                    System.out.println();
                }
            }//for list
        }//while loop
    }//run()

}//class
