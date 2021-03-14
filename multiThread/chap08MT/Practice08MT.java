/**
 * @title multiThread / chap08MT / Practice08MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第８章 WorkerThreadパターン / 練習問題 8-1, 8-4
 * @author shika
 * @date 2021-03-14
 */
/* Appendix
 * @costTime 12:08 - 12:21 ( 13 分)
 * @correctRate 正答率 92.31 ％ ( 〇12問 / 全13問 )
 */
package multiThread.chap08MT;

import javaGold.PracticeEditor;

public class Practice08MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-14 ======
 第８章 WorkerThreadパターン / 練習問題 8-1
〇 （1） Ｘ -> requestがないとき WorkerThreadは wait()してる。
〇 （2） Ｘ -> Clientの putRequest()と Workerの takeRequest(), execute()は別のスレッド。同時進行もありうる。
〇 （3） 〇 -> putRequest()は Clientのみ
〇 （4） 〇 -> takeRequest()は Workerのみ
Ｘ （5） Ｘ -> execute()は Workerで競合するので、synchronizedが必要。
    サンプルプログラムは 1つの Requestに対し executeするのは1つのスレッドなので
    synchronizedする必要はない。

 練習問題 8-2
〇 （1） 別パッケージ

 練習問題 8-3
〇 （1） 別パッケージ

 練習問題 8-4
〇 （1） invokeAndWait()は実行するまで制御が帰ってこない。
〇 （2） 本来はEventDispatchThreadにさせる処理を他スレッドから呼び出すために利用するメソッド
〇 （3） invokeAndWait(Runnable) -> EventDispatchThreadで再帰呼び出し invoke ->
〇 （4） 永久ループ？
    =>◆【EventDispatchThreadからの invokeAndWait()呼び出し】
    ・生存性が失われる
    ・イベントキューのひとつとして invokeAndWait()が詰まれる
    ・イベントキューはずっと完了せず、invokeAndWait()から戻れなくなる。
    ・GUIの状態変更は全て EventDispatchThread１つでしているので、GUI全体のイベント処理が滞る。
    ・上記の理由から java.lang.Errorが投げられる。

 練習問題 8-5
〇 （1） GUIの応用 / 別パッケージに記述

 練習問題 8-6
〇 （1） 別紙

開始時刻 12:08
終了時刻 12:21
所要時間 13 分
正答率 92.31 ％ ( 〇12問 / 全13問 )
*/

