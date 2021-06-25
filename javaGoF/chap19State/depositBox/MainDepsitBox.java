/**
 * @title javaGoF / chap19State / depositBox / MainDepsitBox.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第19章 State / List 19-3 ～ 19-8
 *          状態をクラスで表す。DayState, NightState
 *          昼間か夜間かを調べる if文は書かなくて済む。
 *          DepositBox: 貸金庫
 *          昼間 09:00 - 16:59 / 夜間 17:00 - 08:59
 * @content 練習問題 19-3 / 12:00-14:00 昼食時の状態と処理を追加
 *          LunchStateを追加。
 *          doClock()に昼間と昼食時と夜間への状態遷移
 *          DayState.doClock(), NightState.doClock()を修正。
 *          =>下記【考察】へ
 *
 * @content 練習問題 19-4 / 非常ベルを押すと [<!>非常時]状態に移行
 *          時間に関係なく非常時の処理をする。
 *          問題の懸案であった通常時への移行は
 *          09:00に Y/Nをユーザー入力により復帰する設定とした。
 *          EmergencyStateを追加。
 *          各State.doAlarm()に
 *          context.chageState(EmergencyState.getInstance());を追加。
 *
 * @class MainDepositBox / ◆main()
 * @interface IStateSecurity
 *            (abstract) doClock(), doUse(), doAlarm(), doPhone()
 * @interface IContextDeposit
 *            (abstract) setClock(), changeState(), callCenter(), recordLog()
 * @class DayState implements IStateSecurity
 *        / -static DayState sinpleton /
 *        -DayState(), +static getInstance()
 *        doClock(), doUse(), doAlarm(), doPhone(), toString()
 * @class NightState implements IStateSecurity
 *        / -static NightState sinpleton /
 *        -NightState(), +static getInstance()
 *        doClock(), doUse(), doAlarm(), doPhone(), toString()
 * @class LunchState implements IStateSecurity
 *        / -static LunchState sinpleton /
 *        -LunchState(), +static getInstance(), toString()
 *        doClock(), doUse(), doAlarm(), doPhone()
 * @class EmergencyStarte implements IStateSecurity
 *        / -static LunchState sinpleton /
 *        -LunchState(), +static getInstance()
 *        doClock(), doUse(), doAlarm(), doPhone(), toString()
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

【考察】 練習問題 19-3
doClock()は３つほぼ同じなので
IStateに default doClock()として記述。
３クラスから @Override doClock()を削除。

という変更をしたところ、確かにちゃんと状態遷移はするのだが、
    現在時刻は 02:00
    状態変化: [夜間] -> [夜間]
のように、毎回 状態遷移を行い[夜間] -> [夜間]と無駄なことをしている。
そもそも、Stateで せっかく ifによる状態判定をなくしたのに、
interfaceとはいえ、ifで毎回状態判定するのは、なんか違う。
doClock()は元に戻して LinkedListのように次の状態を指定することにする。
それに伴い開始状態を 夜間からとする。 00:00からなので

ちなみに IStateSecurityの条件判定はこちら
 public default void doClock(
        IContextDeposit context, int hour) {  //状態遷移
    if(9 <= hour && hour < 17) {
        if(12 <= hour && hour < 13) {
            context.changeState(LunchState.getInstance());
        } else {
            context.changeState(DayState.getInstance());
        }

    } else if(hour < 9 || 17 <= hour) {
        context.changeState(NightState.getInstance());
    }
}//doClock()

現在時刻は 00:00
現在時刻は 01:00
現在時刻は 02:00
現在時刻は 03:00
java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=金庫使用,when=1624604359366,modifiers=] on button0
現在時刻は 04:00
現在時刻は 05:00
現在時刻は 06:00
現在時刻は 07:00
現在時刻は 08:00
現在時刻は 09:00
現在時刻は 10:00
現在時刻は 11:00
現在時刻は 12:00
状態変化: [昼間] -> [昼食時]
現在時刻は 13:00
java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=金庫使用,when=1624604369806,modifiers=] on button0
現在時刻は 14:00
状態変化: [昼食時] -> [昼間]
現在時刻は 15:00
現在時刻は 16:00
java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=金庫使用,when=1624604372674,modifiers=] on button0
現在時刻は 17:00
状態変化: [昼間] -> [夜間]
現在時刻は 18:00
現在時刻は 19:00
現在時刻は 20:00
現在時刻は 21:00
現在時刻は 22:00
java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=終了,when=1624604378637,modifiers=] on button1

//練習問題 19-4
現在時刻は 12:00
状態変化: [昼間] -> [昼食時]
java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=非常ベル,when=1624607463784,modifiers=] on button1
状態変化: [昼間] -> [<!>非常時]

現在時刻は 09:00
非常時を解除しますか？ [Y] YES / [N] NO y

状態変化: [<!>非常時] -> [昼間]
現在時刻は 10:00
現在時刻は 11:00
*/