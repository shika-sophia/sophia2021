/**
 * @title javaGold / se11Violet / sampleCode / chap11Locale / resourceBundle / MainProperties.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第11章 Locale, Format / List 11-6, 11-7
 * @content 読み込んできた「key=value」(プロパティ)情報をどう保持するか
 *          Set<T> ResourceBundle.keySet()
 *          Enumeration<T> ResourceBundle.getKeys()
 *          Iterator<T> Enumuration.asIterator()
 *          Hashtable.put(), get()
 *          Set<Entry<K, V>> Properties.entrySet()
 *          String Properties.getProperty(String key [, String default])
 *
 * @author shika
 * @date 2021-04-29
 */
package javaGold.se11Violet.sampleCode.chap11Locale.resourceBundle;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class MainProperties {

    public static void main(String[] args) {
        String here = System.getProperty("sun.java.command"); //ここの完全修飾名
        String dir = here.substring(0, here.lastIndexOf("."));//クラス名を除去
        dir = dir + "."; //「.」を追加。下記 旧dirと同じ dirを作成。
        //String dir = "javaGold.se11Violet.sampleCode.chap11Locale.resourceBundle.";
        //System.out.println(dir);

        final var rb = ResourceBundle.getBundle(dir + "resource.MyLocale", Locale.US);

        //---- ResourceBundle.keySet() ----
        Set<String> keySet = rb.keySet();
        keySet.stream()
            .map(key -> key + ": " + rb.getString(key))
            .forEach(System.out::println);
        System.out.println();

        //---- ResourceBundle.getKeys() -> Enumeration.asIterator() ----
        Enumeration<String> keyEnum = rb.getKeys();
        Iterator<String> keyItr = keyEnum.asIterator();
        while(keyItr.hasNext()) {
            String key = keyItr.next();
            System.out.println(key + "/ " + rb.getString(key));
        }//while
        System.out.println();

        //---- Properties.put(), rb.getString(key) ----
        final Properties pt = new Properties();
        keySet.stream()
            .forEach(key -> pt.put(key, rb.getString(key)));

        showProperty(pt);
    }//main()

    private static void showProperty(Properties pt) {
        //---- Properties.entrySet() ----
        pt.entrySet()
          .forEach(System.out::println);
        System.out.println();

        //---- Properties.get(), getProperty() ----
        System.out.println(pt.get("send"));
        System.out.println(pt.getProperty("send"));
        System.out.println(pt.get("xxxx"));
        System.out.println(pt.getProperty("xxxx"));
        System.out.println(pt.getProperty("xxxx", "default"));
    }//showProperty()

}//class

/*
//---- ResourceBundle.keySet() ----
cancel: cancel
send: send

//---- ResourceBundle.getKeys() -> Enumeration.asIterator() ----
cancel/ cancel
send/ send

//---- Properties.entrySet() ----
cancel=cancel
send=send

//---- Properties.get(), getProperty() ----
send
send
null
null
default

【考察】
ResourceBundle.keySet()で keyのみ取り出した Set<String>を作る。

ResourceBundle.getKeys()で Enumeration<String>
Ｘ Enumeration.stream()も forEach()も不可。
Enueration.asIterator()で Iterator<String>を取得。

Ｘ ResourceBundle.entrySet()は未定義。

Properties extends Hashtableなので 〔<- tableは小文字の t〕
Hashtable.put(), get()を継承。
Properties.getProperty()は第２引数に default値を設定可。
keyが存在しなくて、値が nullのとき、default値を表示。

*/