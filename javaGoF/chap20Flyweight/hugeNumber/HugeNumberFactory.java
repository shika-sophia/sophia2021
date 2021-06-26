package javaGoF.chap20Flyweight.hugeNumber;

import java.util.HashMap;
import java.util.Map;

public class HugeNumberFactory {
    //====== Singleton ======
    private static HugeNumberFactory singleton = new HugeNumberFactory();
    private HugeNumberFactory() { }
    public static HugeNumberFactory getInstance() {
        return singleton;
    }

    //====== Factory ======
    private Map<Integer, String> poolMap = new HashMap<>();

    public synchronized String getNumberData(int index) {
        String hugeStr = poolMap.get(index);

        if(hugeStr == null) {
            var hugeNumber = new HugeNumber(index);
            hugeStr = hugeNumber.getHugeStr();
            poolMap.put(index, hugeStr);
        }

        return hugeStr;
    }//getNumberData()

    public Map<Integer, String> getPoolMap() {
        return poolMap;
    }
}//class
