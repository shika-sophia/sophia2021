/**
 * @title javaGoF / chap17Observer / numberObserver / MainNumberObserver.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第17章 Observer
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @see swing / sample / BarGraph.java (棒グラフ)
 * @see swing / sample / Piechart.java (円グラフ)
 * @content 練習問題 17-2
 *           DataListObserverを追加。
 *           Observerはデータ生成ごと逐次処理できる仕様だが、
 *           BarGraphObserverは全てのデータが決まらないと利用できないので
 *           Adapterパターンのように、適用させるためのクラスが DataListObseber
 *           Main内で BarGraphObserverを newして、データを渡す。
 * @content 解答
 *          CircleGraphObserverを追加。
 *          最後のnumberを円グラフで描画。
 *
 * @see MainNumberObserver/ class summary
 * @see resultBarGraphObserver.jpg
 * @see resultCircleGraphObserver.jpg
 * @author shika
 * @date 2021-06-21, 06-22
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
        INumberObserver observer4 = new CircleGraphObserver();
        generator.addObserver(observer3);
        generator.addObserver(observer4);

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

Drawing Swing Window...
java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=Close,when=1624258305065,modifiers=] on button0
@see resultCircleGraphObserver

//====== Practice17JG Copy ======
(2) 17-2
    => package swingObserver
    => 【解答】 CircleGraphObserver
    *  swing登場以前の java.awtのクラス群で円グラフを作っているので
    *  写経しておく。
    *
    *  それと、私は間に DataListObserverを挟まないと
    *  swing描画に持っていけなかったが、解答は直で 描画している。
    *
    *  Obserberパターンは毎回、状態が変わるたびに処理ができる。
    *  解答では、最後のデータでのみ表示。
    *  repaint()により、最終結果には１枚しか現れないが、
    *  本当は回数分を描画している。
    *
    *  全体の結果から割合を円グラフで描画するなら、
    *  やはり、DataListObserverが必要。
*/
