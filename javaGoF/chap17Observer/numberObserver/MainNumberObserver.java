/**
 * @title javaGoF / chap17Observer / numberObserver / MainNumberObserver.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第17章 Observer / List 17-1 ～ 17-6
 *          状態の変化を通知する。
 *          RandomNumerGenerator 乱数を生成。
 *          DigitObserber 数値を表示
 *          GraphOvserber 数値に対応するグラフを「*」で表示。
 * @content 練習問題 17-1
 *          IncementNumberGeneratorを追加。
 *          開始、終了、間隔の intをコンストラクタで指定。
 *
 * @class MainNumberObserver / ◆main()
 * @interface INumberObserver
 *            / abstract void update(AbsNumberGernerator)
 * @class AbsNumberGenerator
 *       / List<INumberObserver> observerList /
 *       addObserver(), deleteObserver(), notifyObserver()
 *       abstract int getNumber();
 *       abstract void execute();
 * @class RandomNumberGenerator extends AbsNumberGenerator
 *        / Random random, int number,
 *          final int TIMES, final int RANGE /
 *        getNumber(), execute()
 * @class IncrementNumberGenerator extends AbsNumberGenerator
 *        / int number, int begin, int end, int step /
 *        getNumber(), execute()
 * @class DigitObserver implements INumberObserver
 *        / update(AbsNumberGenerator)
 * @class GraphObserver implements INumberObserver
 *        / update(AbsNumberGenerator)
 *
 * @package ---- swingObserver / 練習問題 17-2 ----
 * @class MainSwingObserver
 *        / ◆main()
 *        new DataListObserver, new BarGraphObserver用
 *        new CircleGraphObserver
 * @class DataListObserver implements INumberObserver
 *        / List<Integer> dataList /
 *        update()
 * @class BarGraphObserver extends JFrame
 *        / final int TIMES, final int RANGE,
 *        List<Integer> dataList /
 *        BarGraphObserver(int, int, List<Integer>),
 *        paint(Graphics)
 * @class CircleGraphObserver
 *            extends Frame implements INumberObserver, ActionListener
 *        / GraphText textGr,
 *          GraphCanvas canvasGr,
 *          Button buttonClose /
 *        update(), actionPerformed()
 * @class GraphText 〔with CircleGraphObserver.java〕
 *            extends java.awt.TextField implements INumberObserver
 *        update()
 * @class GraphCanvas 〔with CircleGraphObserver.java〕
 *            extends java.awt.Canvas implements INumberObserver
 *        / int number /
 *        update(), paint()
 *
 * @see MainSwingObserver/
 * @see resultBarGraphObserver.jpg
 * @see resultCircleGraphObserver.jpg
 *
 * @author shika
 * @date 2021-06-19, 06-20
 */
package javaGoF.chap17Observer.numberObserver;

public class MainNumberObserver {

    public static void main(String[] args) {
        //---- RandomNumberGenerator ----
        //AbsNumberGenerator generator
        //    = new RandomNumberGenerator();

        //---- IncrementNumberGenerator ----
        AbsNumberGenerator generator
            = new IncrementNumberGenerator(10, 50, 5);

        //---- Observer ----
        INumberObserver observer1 = new DigitObserver();
        INumberObserver observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);

        //---- execute() ----
        generator.execute();
    }//main()

}//class

/*
//---- RandomNumberGenerator ----
DigitObserver: 49
GraghObserver: *************************************************
DigitObserver: 37
GraghObserver: *************************************
DigitObserver: 9
GraghObserver: *********
DigitObserver: 18
GraghObserver: ******************
DigitObserver: 8
GraghObserver: ********
DigitObserver: 27
GraghObserver: ***************************
DigitObserver: 18
GraghObserver: ******************
DigitObserver: 24
GraghObserver: ************************
DigitObserver: 32
GraghObserver: ********************************
DigitObserver: 46
GraghObserver: **********************************************
DigitObserver: 8
GraghObserver: ********
DigitObserver: 42
GraghObserver: ******************************************
DigitObserver: 11
GraghObserver: ***********
DigitObserver: 28
GraghObserver: ****************************
DigitObserver: 14
GraghObserver: **************
DigitObserver: 32
GraghObserver: ********************************
DigitObserver: 7
GraghObserver: *******
DigitObserver: 47
GraghObserver: ***********************************************
DigitObserver: 17
GraghObserver: *****************
DigitObserver: 7
GraghObserver: *******

//---- IncrementNumberGenerator ----
DigitObserver: 10
GraghObserver: **********
DigitObserver: 15
GraghObserver: ***************
DigitObserver: 20
GraghObserver: ********************
DigitObserver: 25
GraghObserver: *************************
DigitObserver: 30
GraghObserver: ******************************
DigitObserver: 35
GraghObserver: ***********************************
DigitObserver: 40
GraghObserver: ****************************************
DigitObserver: 45
GraghObserver: *********************************************

//====== Practice17JG Copy ======
(1) 練習問題 17-1
    => IncrementNumberGeneratorを追加。
    => 〔回答〕 My Answer
    *  public void execute() {
    *    for(number = begin; number < end; number += step) {
    *        notifyObserver();
    *    }//for
    *  }//execute()
    *
    => 【解答】 Text Answer
    *  ※ コンストラクタで number = begin;
    *
    *  while(number < end){
    *    notifyObserver();
    *    number += step;
    *  }//while
    *
    => 【考察】
    *  for文より、while文のがシンプル。
    *  私もコンストラクタで begin代入を考えたが、
    *  他のロジックに転用できなくなるので、メソッド内で begin代入とした。

*/
