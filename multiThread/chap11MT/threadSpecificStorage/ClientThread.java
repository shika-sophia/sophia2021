package multiThread.chap11MT.threadSpecificStorage;

import java.util.stream.IntStream;

public class ClientThread extends Thread {
    public ClientThread(String name) {
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
                LogThreadLocal.printLog("i = " + i);
            });

        LogThreadLocal.close();
        System.out.println(getName() + ": END");
    }//run()
}//class
