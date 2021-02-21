/**
 * @title multiThread / Intro1.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [改訂増補版]』, 2006
 * @content Introduction1 / Javaスレッド / 練習問題
 * @author shika
 * @date 2021-02-20
 */
/* Appendix
 * @costTime 06:17 - 06:34 ( 17 分)
 * @correctRate 正答率 76.92 ％ ( 〇20問 / 全26問 )
 */
package multiThread.chap00MT;

import javaGold.PracticeEditor;

public class Intro1 {

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
Ｘ （5） Ｘ Threadクラスの１つのインスタンスが複数スレッドから呼び出される。
   -> Ｘ start()からだけ
   => 〇 インスタンスなので、他スレッドから呼び出されることもありうる。
〇 （6） Ｘ sleep()で全てのスレッドが一定時間停止。 -> そのスレッドだけ
〇 （7） Ｘ synchronizedで他の全てのスレッド処理が停止。 -> ここにエントリーできないだけ
〇 （8） Ｘ sleep()でウエイトセットに入る。-> そのスレッドが眠るだけ
〇 （9） Ｘ wait()はsynchronized内に記述。
    -> ロックを取った状態なので少し違う
    => 〇 別のメソッド内にも記述可。wait()実行時にロックを取っていればいい。
Ｘ （10） Ｘ notifyAll()は Objectのインスタンスメソッド。-> Ｘ staticメソッド
    => インスタンスメソッド。暗黙extends時にインスタンス生成されるので、staticでなくとも大丈夫ぽい。

 問題I1-2
Ｘ （1） for文の{ }ブロック内の処理中は、データレースは起こらず、｝まで行って繰り返す際に起こりうる。
    => クラスライブラリで適切に排他処理が行われ、表示中には入り込まず、次の表示を待たされている。

 問題I1-3
〇 （1） Thread.run()ではスレッド起動せず、このスレッド内のメソッド呼び出しになっているから。
    => このプログラムは、シングルスレッド。すべて main()スレッドで処理を行っている。

 問題I1-4
〇 （1） 別紙

 問題I1-5
〇 （1） Thread.sleep()はカレントスレッドにのみ有効？
    => t.sleep()と記述しても眠るのはインスタンスメソッドではなく、
       この文を実行したスレッドのみ。
    Thread.sleep()と同じ意味。
       誤解を招くので、インスタンス変数 t.sleep()という書き方は避けるべき。

 問題I1-6
〇 （1） 〇
〇 （2） 〇
〇 （3） 〇 非synchronizedはいつでも実行可。synchronized実行中でも、ＯＫ。
〇 （4） Ｘ synchronizedは、同時に１つのスレッドのみ実行。
Ｘ （5） 〇
Ｘ （6） Ｘ => インスタンスが異なれば、ロックも別なので、同時に実行できる。
〇 （7） 〇
〇 （8） 〇 => staticクラスメソッドが synchronizedではないので同時に実行可。
Ｘ （9） Ｘ => synchronizedインスタンスメソッドと、synchronizedクラスメソッドはロックが異なるので複数実行可。
〇 （10） Ｘ => synchronizedクラスメソッド同士は不可。
〇 （11） Ｘ
〇 （12） Ｘ
    => x.cSyncA()は Someting.cSyncA()を呼び出し
    y.cSyncB()は Someting.cSyncB()を呼び出す。
    synchronizedなクラスメソッド同士は不可。
    【註】 クラスメソッドをインスタンス変数で呼び出すとコンパイルで Somethingに変換されるが、
    誤解を招きやすいので、この書き方は避けるべき。

開始時刻 06:17
終了時刻 06:34
所要時間 17 分
正答率 76.92 ％ ( 〇20問 / 全26問 )
*/
