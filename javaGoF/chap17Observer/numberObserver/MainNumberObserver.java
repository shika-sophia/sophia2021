/**
 * @title javaGoF / chap17Observer / numberObserver / MainNumberObserver.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第17章 Observer / List 17-1 ～ 17-6
 *          状態の変化を通知する
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
 * @class DigitObserver implements INumberObserver
 *        / update(AbsNumberGenerator)
 * @class GraphObserver implements INumberObserver
 *        / update(AbsNumberGenerator)
 *
 * @author shika
 * @date 2021-06-19
 */
package javaGoF.chap17Observer.numberObserver;

public class MainNumberObserver {

    public static void main(String[] args) {
        AbsNumberGenerator generator
            = new RandomNumberGenerator();
        INumberObserver observer1 = new DigitObserver();
        INumberObserver observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }//main()

}//class

/*
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
*/
