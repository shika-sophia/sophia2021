/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainMapMerge.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 関数型インターフェイスと ラムダ式
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @content Map with Lambda / p475 / List 10-10
 * @content V Map.merge(K, V, BiFunction<K,V,V>)
 *          キーが存在するときは関数の処理を実行。現在値と設定値をもとに値を生成。
 *          キーが存在しないときは新しい値を設定。 新しい「key=vlaue」を生成。
 *          引数: <? super K>, <? super V>
 *          戻値: <? extends V>
 * @author shika
 * @date 2021-04-18
 */
package javaGold.se11Violet.sampleCode.chap05VT;

import java.util.HashMap;
import java.util.Map;

public class MainMapMerge {

    public static void main(String[] args) {
        var map = new HashMap<String,String>(
            Map.of("orange", "みかん"));

        map.merge("melon","メロン", MergeDefine::concat);
        map.merge("orange","オレンジ", MergeDefine::concat);
        System.out.println("map: " + map);

        map.merge("orange", "", MergeDefine::concat);
        System.out.println("map: " + map);
    }//main()

}//class

class MergeDefine {
    public static String concat(String v1, String v2) {
        if(v2 == "") {
            return null;
        }

        return v1 + ", " + v2;
    }//concat()
}//class

/*
map: {melon=メロン, orange=みかん, オレンジ}
map: {melon=メロン}

【考察】 DJ p476
key: melon, value: メロン の keyは存在しないので 新しい「key=vlaue」を生成。
key: orange, value: オレンジ は keyが重複するするので、値のみ「,」で結合。
結合関数が nullを返したとき、keyそのものが破棄される。
とあるが、よく解らん。

さっき入れた 「melon, オレンジ」はどうなった。
Map.put(K, V)をするわけではなさそう。

下記に Map.merge()のAPI Reference?の定義を引用してみたが、
もっと解らん。
*/
/*
//====== Map.merge() definition in API Reference ======
@Override
public V merge(K key, V value,
               BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
    if (value == null)
        throw new NullPointerException();
    if (remappingFunction == null)
        throw new NullPointerException();
    int hash = hash(key);
    Node<K,V>[] tab; Node<K,V> first; int n, i;
    int binCount = 0;
    TreeNode<K,V> t = null;
    Node<K,V> old = null;
    if (size > threshold || (tab = table) == null ||
        (n = tab.length) == 0)
        n = (tab = resize()).length;
    if ((first = tab[i = (n - 1) & hash]) != null) {
        if (first instanceof TreeNode)
            old = (t = (TreeNode<K,V>)first).getTreeNode(hash, key);
        else {
            Node<K,V> e = first; K k;
            do {
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k)))) {
                    old = e;
                    break;
                }
                ++binCount;
            } while ((e = e.next) != null);
        }
    }
    if (old != null) {
        V v;
        if (old.value != null) {
            int mc = modCount;
            v = remappingFunction.apply(old.value, value);
            if (mc != modCount) {
                throw new ConcurrentModificationException();
            }
        } else {
            v = value;
        }
        if (v != null) {
            old.value = v;
            afterNodeAccess(old);
        }
        else
            removeNode(hash, key, null, false, true);
        return v;
    }
    if (value != null) {
        if (t != null)
            t.putTreeVal(this, tab, hash, key, value);
        else {
            tab[i] = newNode(hash, key, value, first);
            if (binCount >= TREEIFY_THRESHOLD - 1)
                treeifyBin(tab, hash);
        }
        ++modCount;
        ++size;
        afterNodeInsertion(true);
    }
    return value;
}
*/