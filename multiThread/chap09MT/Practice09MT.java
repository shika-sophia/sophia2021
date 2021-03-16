/**
 * @title multiThread / chap09MT / Practice09MT.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第９章 Futureパターン / 練習問題 9-1, 9-2
 * @author shika
 * @date 2021-03-16
 */
/* Appendix 2021-03-16
 * @costTime 13:39 - 13:52 ( 13 分)
 * @correctRate 正答率 87.50 ％ ( 〇7問 / 全8問 )
 */
package multiThread.chap09MT;

import javaGold.PracticeEditor;

public class Practice09MT {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-03-16 ======
 第９章 Futureパターン / 練習問題 9-1
〇 （1） 〇 request()で新しいThreadが起動
〇 （2） 〇 request()の戻り値は Data型だが、実際は FutreDataのインスタンス
〇 （3） Ｘ -> setRealData()を呼び出すのは、HostでnewしたThreadが RealDataを完成させたとき
Ｘ （4） Ｘ -> RealDataの getContent()を実行するのは FutureDataの getContent()
    => data1.getContent()は、戻り値FutureDataなので、これで正解。

〇 （5） Ｘ -> Hostは フィールドを持たない immutable。request()の変数は引数で与えられる固有の値なので、synchronizedは不要。

 練習問題 9-2
〇 （1） Mainのほか、３スレッド。 RealDataを作成し、FutureDataのフィールドにセット。notifyAll()で wait中を起こす。

 練習問題 9-3
〇 （1） 別パッケージ

 練習問題 9-4
〇 （1） 別パッケージ

開始時刻 13:39
終了時刻 13:52
所要時間 13 分
正答率 87.50 ％ ( 〇7問 / 全8問 )
*/

