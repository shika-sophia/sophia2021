/**
 * @title multiThread / chap12MT / activeObjectPattern / MainActive.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第12章 Active Object パターン / List 12-1 ～ 12-15
 *
 * @package ---- (default) ----
 * @class + MainActive / ◆main(), ActObj, MakeTh, ShowTh
 * @class + MakeClientThread / ActObj(Proxy).makeString()
 * @class + ShowClientThread / ActObj(Proxy).showString()
 * @package ---- activeObject ----
 * @interface + ActObj / super of ActProxy, Servant
 * @class ~ ActObjFactory / new Servant, SchedulerThread, ActQueue, ActProxy
 * @class ~ ActProxy implements ActObj / Clientのメソッド呼出をRequestインスタンスに変える
 * @class ~ Servant implements ActObj / Scheduleに呼ばれ makeString(),showString()の実行処理
 * @class ~ SchedulerThread / Requestを ActQueueに格納、Requestを取り出し Servantに渡す。
 * @class ~ ActQueue / Requestの格納と取り出し。Producer-Consumerの Channel役。
 * @class ~ AbsRequest / super of MakeRequest, ShowRequest
 * @class ~ MakeRequest extends AbsRequest /　リクエストのオブジェクト化
 * @class ~ ShowRequest extends AbsRequest / リクエストのオブジェクト化
 * @class + AbsResult / super of FutureResult, RealResult
 * @class ~ FutureResult extends AbsReault / Futureパターン仮結果
 * @class ~ RealResult extends AbsResult/ Futureパターン実結果
 * @note UML +:public, ~:package, #:protected, -:private
 *
 * @author shika
 * @date 2021-03-26
 */
package multiThread.chap12MT.activeObjectPattern;

import multiThread.chap12MT.activeObjectPattern.activeObject.ActObj;
import multiThread.chap12MT.activeObjectPattern.activeObject.ActObjFactory;

public class MainActive {

    public static void main(String[] args) {
        ActObj actObj = ActObjFactory.createActObj();
        new MakeClientThread("Alice", actObj).start();
        new MakeClientThread("Bobby", actObj).start();
        new ShowClientThread("Chris", actObj).start();
    }//main()

}//class

/*
showString(): Chris: 0
Alice: value =
Bobby: value =
Alice: value = A
Bobby: value = B
showString(): Chris: 1
Alice: value = AA
showString(): Chris: 2
Bobby: value = BB
showString(): Chris: 3
Alice: value = AAA
showString(): Chris: 4
Bobby: value = BBB
showString(): Chris: 5
showString(): Chris: 6
Alice: value = AAAA
showString(): Chris: 7
Bobby: value = BBBB
showString(): Chris: 8
showString(): Chris: 9
showString(): Chris: 10
Alice: value = AAAAA
showString(): Chris: 11
showString(): Chris: 12
Bobby: value = BBBBB
showString(): Chris: 13
showString(): Chris: 14
showString(): Chris: 15
Alice: value = AAAAAA
showString(): Chris: 16
showString(): Chris: 17
showString(): Chris: 18
  :
( ^C )
*/