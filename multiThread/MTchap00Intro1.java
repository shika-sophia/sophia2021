/**
 * @title multiThread / MTchap00Intro1.java
 * @reference 結城 浩『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content Javaスレッド 練習問題
 * @author shika
 * @date 2021-02-20
 */
/* Appendix
 * @costTime 06:17 - 06:34 ( 17 分)
 * @correctRate 正答率 76.92 ％ ( 〇20問 / 全26問 )
 */
package multiThread;

import javaGold.PracticeEditor;

public class MTchap00Intro1 {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class

/*
//====== 2021-02-20 ======
 Javaスレッド 練習問題 / 問題I1-1
〇 （1） 〇少なくとも１つのスレッドは動作している。
〇 （2）  Ｘ Thread.run()で起動 -> start()で起動
〇 （3） Ｘ Runnableは start(),run()を宣言。 -> run()のみ
〇 （4） 〇 同一インスタンスが複数スレッドから呼び出されることがある。
Ｘ （5） Ｘ Threadクラスの１つのインスタンスが複数スレッドから呼び出される。 -> start()からだけ
〇 （6） Ｘ sleep()で全てのスレッドが一定時間停止。 -> そのスレッドだけ
〇 （7） Ｘ synchronizedで他の全てのスレッド処理が停止。 -> ここにエントリーできないだけ
〇 （8） Ｘ sleep()でウエイトセットに入る。-> そのスレッドが眠るだけ
〇 （9） Ｘ wait()はsynchronized内に記述。-> ロックを取った状態なので少し違う
Ｘ （10） Ｘ notifyAll()は Objectのインスタンスメソッド。-> staticメソッド

 問題I1-2
Ｘ （1） for文の{ }ブロック内の処理中は、データレースは起こらず、｝まで行って繰り返す際に起こりうる。

 問題I1-3
〇 （1） Thread.run()ではスレッド起動せず、このスレッド内のメソッド呼び出しになっているから。

 問題I1-4
〇 （1） 別紙

 問題I1-5
〇 （1） Thread.sleep()はカレントスレッドにのみ有効？

 問題I1-6
〇 （1） 〇
〇 （2） 〇
〇 （3） 〇
〇 （4） Ｘ
Ｘ （5） 〇
Ｘ （6） Ｘ
〇 （7） 〇
〇 （8） 〇
Ｘ （9） Ｘ
〇 （10） Ｘ
〇 （11） Ｘ
〇 （12） Ｘ

開始時刻 06:17
終了時刻 06:34
所要時間 17 分
正答率 76.92 ％ ( 〇20問 / 全26問 )
*/
