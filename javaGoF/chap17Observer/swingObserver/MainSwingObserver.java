/**
 * @title javaGoF / chap17Observer / numberObserver / MainNumberObserver.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第17章 Observer
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @see swing / sample / BarGraph.java
 * @content 練習問題 17-2
 *           DataListObserverを追加。
 *           Observerはデータ生成ごと逐次処理できる仕様だが、
 *           BarGraphObserverは全てのデータが決まらないと利用できないので
 *           Adapterパターンのように、適用させるためのクラスが DataListObseber
 *           Main内で BarGraphObserverを newして、データを渡す。
 *
 * @see MainNumberObserver/ class summary
 * @see resultBarGraphObserver.jpg
 * @author shika
 * @date 2021-06-21
 */
package javaGoF.chap17Observer.swingObserver;

import java.util.List;

import javaGoF.chap17Observer.numberObserver.AbsNumberGenerator;
import javaGoF.chap17Observer.numberObserver.INumberObserver;
import javaGoF.chap17Observer.numberObserver.RandomNumberGenerator;

public class MainSwingObserver {

    public static void main(String[] args) {
        //---- RandomNumberGenerator ----
        AbsNumberGenerator generator
            = new RandomNumberGenerator(20, 100);

      //---- Observer ----
        INumberObserver observer3 = new DataListObserver();
        generator.addObserver(observer3);

        //---- execute() ----
        generator.execute();

        //---- view Swing ----
        List<Integer> dataList = ((DataListObserver) observer3).getDataList();
        System.out.println("Drawing Swing Window...");
        new BarGraphObserver(20, 100, dataList);
    }//main()

}//class

/*
Drawing Swing Window...
@see resultBarGraphObserver.jpg
*/