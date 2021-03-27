/**
 * @title multiThread / chap12MT / Practice12MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第12章 ActiveObject / 練習問題 12-1
 * @author shika
 * @date 2021-03-27
 */
/* Appendix 2021-03-27
 * @costTime 13:49 - 14:01 ( 12 分)
 * @correctRate 正答率 66.66 ％ ( 〇6問 / 全9問 )
 */
package multiThread.chap12MT;

import javaGold.PracticeEditor;

public class Practice12MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-27 ======
 第12章 ActiveObject / 練習問題 12-1
〇 （1） 〇 Proxy, Servantは ActObjを実装。
Ｘ （2） 〇 Proxy.makeStr()は Servant.makeStr()で実行処理される
    => MakeClientThreadが呼ぶ makeStr()は Proxyで実装

〇 （3） 〇 showStr()を呼び出すために SchedulerThreadが起動する。
〇 （4） Ｘ Servantは SchedulerThreadのみで実行なので排他処理は不要。
〇 （5） 〇 ActQueue.putRequest()は複数のClientスレッドから呼ばれる。
〇 （6） Ｘ Act.Queue.takeRequestは Shedulerからのみ、
        フィールドをputと共有しているので要synchronized
〇 （7） 〇 GuardedSuspensionパターン
Ｘ （8） Ｘ -> 文字列はMakeRequestで出来上がっている
  => Servantが作る文字列が大きいほど時間が掛かる。
      文字列は servantで作ってます。

Ｘ （9） 〇 countが大きいほど、charを複数入れ１文字ごとの時間が掛かるため
    => MakeClientが呼ぶときはインスタンスを作り ActQueueに入れるだけなので
        制御はすぐに戻ってくる。

開始時刻 13:49
終了時刻 14:01
所要時間 12 分
正答率 66.66 ％ ( 〇6問 / 全9問 )
*/

