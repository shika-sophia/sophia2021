/**
 * @title multiThread / chap07MT / Practice07MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content [ 第７章 Thread-Per-Message / 練習問題 7-1,  練習問題 7-2,  練習問題 7-3,  練習問題 7-4,  練習問題 7-5,  練習問題 7-6,  練習問題 7-7,  練習問題 7-8]
 * @author shika
 * @date 2021-03-10
 */
/* Appendix
 * @costTime 10:25 - 10:49 ( 24 分)
 * @correctRate 正答率 63.16 ％ ( 〇12問 / 全19問 )
 */
package multiThread.chap07MT;

import javaGold.PracticeEditor;

public class Practice07MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-10 ======
 第７章 Thread-Per-Message / 練習問題 7-1
〇 （1） 〇 request()が呼び出されるたびに Threadが起動。
〇 （2） Ｘ -> Helperクラスのインスタンスは、Hostインスタンス時に生成。
〇 （3） Ｘ-> handle()は Mainではなく、request()で起動するThread()内で呼び出し
〇 （4） Ｘ -> handle()の文字を記入しているのは main-Threadではない。
〇 （5） Ｘ -> request()は handle()の終了を待たずに終了。 slowly()は handle()からだけ。

 練習問題 7-2
〇 （1） 別紙

 練習問題 7-3
Ｘ （1） new Thread() { run() }.run() で再帰呼び出し -> Exceptionで停止
Ｘ （2） メモリオーバーで JVMが例外をthrowするから。
    => start()ではなく run()になっているので、
    シングルスレッドによる run()の呼び出しになる。
    handle()が終了するまで request()は終了しない。
    (request()の応答性は向上しない)

 練習問題 7-4
〇 （1） 別紙

 練習問題 7-5
〇 （1） swing 別紙

 練習問題 7-6
〇 （1） Serverも 別紙

 練習問題 7-7
〇 （1） 別紙

 練習問題 7-8
〇 （1） ① main: BEGIN
Ｘ （2） ② run: BEGIN
Ｘ （3） ③ Hello!
Ｘ （4） ④ run: END
Ｘ （5） ⑤ execute: BEGIN
Ｘ （6） ⑥ newThread: BEGIN, END
〇 （7） ⑦ main: END
    => main -> execute -> nawThread -> runの順
開始時刻 10:25
終了時刻 10:49
所要時間 24 分
正答率 63.16 ％ ( 〇12問 / 全19問 )
*/

