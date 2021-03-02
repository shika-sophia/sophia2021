/**
 * @title multiThread / chap04MT / Practice04MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第４章 Balking / 練習問題 4-1, 練習問題 4-5
 * @author shika
 * @date 2021-03-02
 */
/* Appendix
 * @costTime 09:16 - 09:31 ( 14 分)
 * @correctRate 正答率 75.00 ％ ( 〇9問 / 全12問 )
 */
package multiThread.chap04MT;

import javaGold.PracticeEditor;

public class Practice04MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-02 ======
 第４章 Balking / 練習問題 4-1
〇 （1） save()は SaveThreadからのみ。Ｘ
〇 （2） synchronizedを全て外して、changedに volatile。Ｘ -> change(),save()に別のスレッドが入るとズレる。？
    => save(), change()とも、synchronizedを外すと、 SingleThreadExecutionにならないので、
    同時に複数のスレッドが処理をすると、意図しない結果となる。
    volatileは コンパイラ最適化のキャッシュ保存をしなくなり、
    最新の状態をスレッドキャッシュに読み込ませる機能。
    排他制御の機能はない。

〇 （3） Ｘ -> { }を抜けるまでは synchronized なので、どちらも同じ。
〇 （4） doSave()は synchronizedではない。〇
〇 （5） doSave()は同時に２つのスレッドから呼び出されない。 〇 -> privateで synchronized の save()からしか呼ばれていないから

 練習問題 4-2
Ｘ （1） 別紙

 練習問題 4-3
Ｘ （1） ノート

 練習問題 4-4
Ｘ （1） 別紙

 練習問題 4-5
〇 （1） 一度 start()して終了したスレッドを 再度 start()させることはできない。
〇 （2） -> IllegalThreadStateException(Runtime)
〇 （3） 意図どうりにループさせたければ while(true)ループを main()ではなく、
〇 （4） TestThred内の for文の外側に記述するとよい。
    => 一度 Thread.start()したスレッドには Balkingパターンが使われ、
    2回目は start()できなくなっており、上記の例外を throwする。

開始時刻 09:16
終了時刻 09:31
所要時間 14 分
正答率 75.00 ％ ( 〇9問 / 全12問 )
*/

