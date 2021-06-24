/**
 * @title javaGoF / chap19State / depositBox / MainDepsitBox.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第19章 State / List 19-3 ～ 19-8
 *          状態をクラスで表す。DayState, NightState
 *          昼間か夜間かを調べる if文は書かなくて済む。
 *          DepositBox: 貸金庫
 *          昼間 09:00 - 16:59 / 夜間 17:00 - 08:59
 *
 * @class MainDepositBox / ◆main()
 * @interface IStateSecurity
 *            (abstract) doClock(), doUse(), doAlarm(), doPhone()
 * @interface IContextDeposit
 *            (abstract) setClock(), changeState(), callCenter(), recordLog()
 * @class DayState implements IStateSecurity
 *        / -static DayState sinpleton /
 *        -DayState(), +static getInstance()
 *        doClock(), doUse(), doAlarm(), doPhone()
 * @class NightState implements IStateSecurity
 *        / -static NightState sinpleton /
 *        -NightState(), +static getInstance()
 *        doClock(), doUse(), doAlarm(), doPhone()
 * @class DepositFrame extends Frame
 *            implements IContextDeposit, ActionListener
 *        / -IStateSecurity state /
 *        DepositFrame(), actionPerformed()
 *        setClock(), changeState(), callCenter(), recordLog()
 *
 * @see resultDepositBox.jpg
 * @author shika
 * @date 2021-06-24
 */
package javaGoF.chap19State.depositBox;

public class MainDepsitBox {

    public static void main(String[] args) {
        var frame = new DepositeFrame("State Sample");

        while(true) {
            for(int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//for
        }//while
    }//main()

}//class

/*
現在時刻は 00:00
状態変化: [昼間] -> [夜間]
現在時刻は 01:00
現在時刻は 02:00
現在時刻は 03:00
現在時刻は 04:00
現在時刻は 05:00
現在時刻は 06:00
現在時刻は 07:00
現在時刻は 08:00
現在時刻は 09:00
状態変化: [夜間] -> [昼間]
現在時刻は 10:00
java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=金庫使用,when=1624504509650,modifiers=] on button0
現在時刻は 11:00
現在時刻は 12:00
現在時刻は 13:00
java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=金庫使用,when=1624504512311,modifiers=] on button0
現在時刻は 14:00
現在時刻は 15:00
現在時刻は 16:00
現在時刻は 17:00
状態変化: [昼間] -> [夜間]
現在時刻は 18:00
java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=通常通話,when=1624504517624,modifiers=] on button1
現在時刻は 19:00
現在時刻は 20:00
現在時刻は 21:00
現在時刻は 22:00
現在時刻は 23:00
java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=非常ベル,when=1624504523045,modifiers=] on button2
現在時刻は 00:00
現在時刻は 01:00

*/