package multiThread.chap06MT.reentrantDataMap;

public class SyncDataMap<K, V> extends AbsDataMap<K, V> {

    //keyと valueを セット
    public synchronized void assign(K key, V value) {
        slowly(500L);
        map.put(key, value);
    }//assign()

    //keyに対応する valueを取得
    public synchronized V retrieve(K key) {
        slowly(50L); //他より軽い処理をシミュレーション
        return map.get(key);
    }//retrieve()

    public synchronized void clear() {
        slowly(500L);
        map.clear();
    }//clear()
}//class

