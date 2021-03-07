package multiThread.chap06MT.reentrantDataMap;

import java.util.concurrent.atomic.AtomicInteger;

public class RetrieveThread extends Thread {
    private final AbsDataMap<String, String> dataMap;
    private final String key;
    private static final
        AtomicInteger atomCount = new AtomicInteger(0);

    public RetrieveThread(
            AbsDataMap<String, String> dataMap, String key) {
        this.dataMap = dataMap;
        this.key = key;
    }

    public void run() {
        while(true) {
            int count = atomCount.incrementAndGet();
            String value = dataMap.retrieve(key);
            System.out.printf("%d: <%s, %s> \n", count, key, value);
        }//while loop
    }//run()

    public static AtomicInteger getAtomcount() {
        return atomCount;
    }
}//class
