/**
 * @title multiThread / chap10MT / Practice10MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第10章 Two-Phase-Termination / 練習問題 10-1, 10-6, 10-8
 * @author shika
 * @date 2021-03-20
 */
/* Appendix 2021-03-20
 * @costTime 15:56 - 16:20 ( 24 分)
 * @correctRate 正答率 68.75 ％ ( 〇11問 / 全16問 )
 */
package multiThread.chap10MT;

import javaGold.PracticeEditor;

public class Practice10MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-20 ======
 第10章 Two-Phase-Termination / 練習問題 10-1
〇 （1） 〇 shutdownRwquest()を呼び出すのは mainスレッド
〇 （2） Ｘ -> doWork()は何度も呼ばれます。
〇 （3） 〇 finally { doShutdown(); }なので必ず呼ばれます。
Ｘ （4） th.shutdownRequest()なので、呼び出しているのは mainスレッドかな。
〇 （5） -> だとしたら Thread.currentThread().interrupt()は不可。
     =>interrupt()は this.interrupt()と同義。
     よって、どのスレッドから呼び出されても、
     interrupt()するのは this〔= CountupThread〕となる。
     題意の Thread.currentThread().interrupt()とすると、
     これを呼び出したmainThreadが interrupt()されてしまい、意図した動作と異なる。

 練習問題 10-2
〇 （1） フラグ削除 / 別パッケージ

 練習問題 10-3
〇 （1） FileWriterへの応用 / 別パッケージ

 練習問題 10-4
〇 （1） Gracefulの継承 / 別パッケージ

 練習問題 10-5
〇 （1） GUIへの応用 / 別パッケージ

 練習問題 10-6
〇 （1） フラグ shutdownRequestは 終了フラグが立つと false -> trueに変化するため,
〇 （2） JVMによる最適化でキャッシュが残っていると応答性を損なうので volatile。
    => synchronized: 排他制御と同期化
    => volatile: 同期化のみ行う
    サンプルプログラムでは、排他制御は不要だが、フィールドの同期化は必要。

 練習問題 10-7
〇 （1） ハノイの塔 応答性修正 / 別パッケージ

 練習問題 10-8
Ｘ （1） interruptパズル 「....*...」と表示。
Ｘ （2） interrupt()によって catch節に飛び「*」
Ｘ （3） catchされたので、interrupt状態は解除され、次の isInterrupted()は false
Ｘ （4） よって、InterruptedExceptionは throwされない。
    => catchによって interrupt状態は変化しない。
       InterruptedExceptionが throwされると interrupt状態は解消される。
             なので設問を実行すると「......*******」の表示が正解。
       isInterrupted()は 状態の判定だけをして interrupt状態は変化しない。
       interrupted()を判定に用いると一度だけ「*」を表示し、
       interrupｔ状態を解消し(= 変化させ)、「...」に戻す。

開始時刻 15:56
終了時刻 16:20
所要時間 24 分
正答率 68.75 ％ ( 〇11問 / 全16問 )
*/

