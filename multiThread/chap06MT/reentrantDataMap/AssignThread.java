package multiThread.chap06MT.reentrantDataMap;

import java.util.Random;

public class AssignThread extends Thread {
    private static Random random = new Random(314159);
    private final AbsDataMap<String, String> dataMap;
    private final String key;
    private final String value;

    public AssignThread(
            AbsDataMap<String, String> dataMap, String key, String value) {
        this.dataMap = dataMap;
        this.key = key;
        this.value = value;
    }

    public void run() {
        while(true) {
            System.out.printf("%s: assign(%s, %s) \n",
                getName(), key, value);
            dataMap.assign(key, value);

            //「書く」頻度が低いことをシミュレート
            dataMap.slowly(random.nextInt(3000));
        }//while loop
    }//run()
}//class
