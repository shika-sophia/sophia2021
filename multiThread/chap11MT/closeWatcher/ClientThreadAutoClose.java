package multiThread.chap11MT.closeWatcher;

import java.util.stream.IntStream;

public class ClientThreadAutoClose extends Thread {
    public ClientThreadAutoClose(String name) {
        super(name);
    }

    public void run() {
        System.out.println(getName() + ": BEGIN");

        IntStream.range(0, 10)
            .peek(i -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            })
            .forEach(i -> {
                LogThLocalWatcher.printLog("i = " + i);
            });

        //LogThLocalWatcher.close(); //watcherがあるのでコメントアウト
        System.out.println(getName() + ": END");
    }//run()
}//class
