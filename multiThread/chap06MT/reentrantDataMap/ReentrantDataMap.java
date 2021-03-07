package multiThread.chap06MT.reentrantDataMap;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantDataMap<K, V> extends AbsDataMap<K, V> {
    private final ReentrantReadWriteLock lock
        = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    //keyと valueを セット
    public void assign(K key, V value) {
        writeLock.lock();
        try {
            slowly(500L);
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }//assign()

    //keyに対応する valueを取得
    public V retrieve(K key) {
        readLock.lock();
        try {
            slowly(50L); //他より軽い処理をシミュレーション
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }//retrieve()

    public void clear() {
        writeLock.lock();
        try {
            slowly(500L);
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }//clear()

}//class
