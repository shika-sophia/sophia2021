package multiThread.chap06MT.reentrantDataMap;

import java.util.HashMap;
import java.util.Map;

public abstract class AbsDataMap<K, V> {
    protected final Map<K,V> map = new HashMap<>();

    public abstract V retrieve(K key);
    public abstract void assign(K key, V value);
    public abstract void clear();

    protected void slowly(long rest) {
        try {
            Thread.sleep(rest);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//slowly()
}//class
