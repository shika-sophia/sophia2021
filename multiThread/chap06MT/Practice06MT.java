/**
 * @title multiThread / chap06MT / Practice06MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第６章 Read-Write Lock / 練習問題 6-1, 6-2, 6-5, 6-6, 6-7
 * @author shika
 * @date 2021-03-06
 */
/* Appendix
 * @costTime 16:20 - 16:44 ( 23 分)
 * @correctRate 正答率 53.33 ％ ( 〇8問 / 全15問 )
 */
package multiThread.chap06MT;

import javaGold.PracticeEditor;

public class Practice06MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-06 ======
 第６章 Read-Write Lock / 練習問題 6-1
〇 （1） 〇 -> doWrite()はロックされてます。
Ｘ （2） 〇 -> doRead()はロックされてます。
    => doRead()は 複数の ReadThreadが利用可能。

〇 （3） 〇-> doWrite()中は readingThread = 0
〇 （4） 〇 -> doRead()中は writingThreadも止まってて 0です。

 練習問題 6-2
〇 （1） 読んでいる最中にも書き込みがされ、「read: aaaabbbbcc」のように文字が入り混じる。

 練習問題 6-3
〇 （1） 両方 synchronizedした SingleTheadExecutionパターン。
Ｘ （2） あとで System.currentTimeMillis();してみます。

 練習問題 6-4
Ｘ （1） 別紙

 練習問題 6-5
Ｘ （1） finallyブロックから try内の lock()は不可視で、
Ｘ （2） lock()されているものしか unlock()できないとかかな。？
Ｘ （3） 解りません。
    =>【解答】
        interrupt()されると、lock()途中で reading++がされないまま、
        catch節 unlockに進み reading--;がなされる。
        readingの値が マイナスになる可能性がある。

        try節の外なら、interrupt()されても、unlock()に進むことはない。

 練習問題 6-6
〇 （1） ReadThreadのほうが、たくさんあり、処理も速いため、
〇 （2） なかなか書き込めない状況が続く。
Ｘ （3） WriteThreadの待ち中には優先的に書けるよう preferWriteフィールドがある。？
    =>【解答】
        waitWriteフィールドがないと、ReadThreadが多いため、なかなか WriteThreadが入れない。

        preferWriteフィールドを falseにしないと、今度は Writeの次に Writeが優先されて、
        Readが なかなか入れなくなる。
        readUnlock() -> preferWrite = true;
        writeUnlock() -> preferWrite = false;
        にすることで、信号機のような役割をしている。

 練習問題 6-7
〇 （1） 答え合わせの後で

開始時刻 16:20
終了時刻 16:44
所要時間 23 分
正答率 53.33 ％ ( 〇8問 / 全15問 )
*/

